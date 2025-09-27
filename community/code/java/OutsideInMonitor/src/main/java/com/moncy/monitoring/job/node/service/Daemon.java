package com.moncy.monitoring.job.node.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.moncy.monitoring.job.node.model.AppProperties;
import com.moncy.monitoring.job.node.model.Target;

@Component
@Profile("!test") // Exclude this bean from tests as it runs indefinitely
public class Daemon  implements CommandLineRunner {

    @Autowired
    private final AppProperties appProperties;
    @Autowired
    private final MonitoringService monitoringService;
    @Autowired
    private final EmailNotificationService emailNotificationService;

    public Daemon(AppProperties appProperties, MonitoringService monitoringService, EmailNotificationService emailNotificationService) {
        this.appProperties = appProperties;
        this.monitoringService = monitoringService;
        this.emailNotificationService = emailNotificationService;
    }

    @Override
    public void run(String... args) throws Exception {

        final long timeStarted = System.currentTimeMillis();
        long run = 0;

        System.out.println("Daemon initialized with : " + appProperties.toString());
        System.out.println("Daemon Started at: " + timeStarted);

        // If the max runMultiple has been crossed, reset run to 1 to avoid overflow.
        // This assumes that the max intervalMins is a multiple of all other intervalMins
        int maxRunMultiple = 1;
        for (Target target : appProperties.getTargets()) {
            int runMultiple = target.getRunMultiple(appProperties.getOperation().getRecurMins(), appProperties.getOperation().getTotalNodes());
            if (runMultiple > maxRunMultiple) {
                maxRunMultiple = runMultiple;
            }
        }

        while (true) {
            final long timeNow = System.currentTimeMillis();

            for (Target target : appProperties.getTargets()) {

                int runMultiple = target.getRunMultiple(appProperties.getOperation().getRecurMins(), appProperties.getOperation().getTotalNodes());
                if (runMultiple > 0 && (run % runMultiple) == appProperties.getSelf().getNum()) {
                    System.out.println("Running job for target: " + target.toString() + " at " + timeNow + " mins");

                    monitoringService.fetch(target.getUrl())
                            .thenAccept(
                                result -> {
                                    if (result.isEmpty()) {
                                        System.out.println("Target " + target.getName() + " is UP.");
                                    } else {
                                        System.out.println("Target " + target.getName() + " check failed: " + result);
                                        emailNotificationService.notify(target.getEmail(), "Monitoring Alert: " + target.getName(), "Target " + target.getName() + " is DOWN." + result);
                                        System.out.println("Sent error notification to " + target.getEmail() + " regarding failed target " + target.getName());
                                    }
                            }).exceptionally(ex -> {
                                String err_message = "Exception during monitoring of target " + target.getName() + ": " + ex.getMessage();
                                System.out.println(err_message);
                                emailNotificationService.notify(target.getEmail(), "Monitoring Alert: " + target.getName(), "Target " + target.getName() + " is DOWN." + err_message);
                                System.out.println("Sent exception notification to " + target.getEmail() + " regarding failure to reach " + target.getName());
                                return null;
                            });
                }
            }
            run++;
            if (run > maxRunMultiple) run = 0;

            long remaining = (appProperties.getOperation().getRecurMins() * 60000) - (System.currentTimeMillis() - timeNow);
            System.out.println("Daemon cycle completed. Sleeping for " + (remaining > 0 ? remaining : 0) + " ms");

            if (remaining > 0)  Thread.sleep(remaining);
        }
    }
}
