package com.moncy.monitoring.job.node.config;

import java.time.Duration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    private final int MAX_SECS_TO_CONNECT = 2;
    private final int MAX_SECS_TO_READ = 5;

    @Bean
    public RestTemplate monitoringTemplate(RestTemplateBuilder builder) {
        return builder
                .connectTimeout(Duration.ofSeconds(MAX_SECS_TO_CONNECT)) // Connection timeout
                .readTimeout(Duration.ofSeconds(MAX_SECS_TO_READ))  // Read timeout
                .build();
    }
}
