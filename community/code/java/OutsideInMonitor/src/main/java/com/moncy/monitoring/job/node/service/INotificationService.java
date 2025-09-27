package com.moncy.monitoring.job.node.service;

public interface INotificationService {
    void notify(String to, String subject, String body);
}
