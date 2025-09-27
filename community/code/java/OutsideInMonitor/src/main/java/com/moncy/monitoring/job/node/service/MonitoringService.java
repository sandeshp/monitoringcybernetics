package com.moncy.monitoring.job.node.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class MonitoringService {

    private final RestTemplate restTemplate;

    public MonitoringService(@Qualifier("monitoringTemplate") RestTemplate rt) {
        this.restTemplate = rt;
    }

    @Async("monitoringPoolExecutor")
    public CompletableFuture<String> fetch(String targetURL) {
        ResponseEntity<String> result;
        try {
            result = restTemplate.getForEntity(targetURL, String.class);
            if (result.getStatusCode().is2xxSuccessful()) return CompletableFuture.completedFuture("");
        } catch (RestClientException | IllegalArgumentException e) {
            return CompletableFuture.completedFuture("Error: " + e.getMessage());
        }

        return CompletableFuture.completedFuture("Error reaching " + targetURL + " Status Code: " + result.getStatusCode() + " Response Body: " + result.getBody());
    }
}
