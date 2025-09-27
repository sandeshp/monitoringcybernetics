package com.moncy.monitoring.job.node.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ThreadPoolConfig {

    @Bean(name = "monitoringPoolExecutor") // Give your executor a unique name
    public ThreadPoolTaskExecutor monitoringPoolExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2); // Minimum number of threads
        executor.setMaxPoolSize(5); // Maximum number of threads
        executor.setQueueCapacity(5); // Capacity of the task queue
        executor.setThreadNamePrefix("moncy-da-"); // Prefix for thread names
        executor.initialize();
        return executor;
    }
}