package com.moncy.monitoring.job.node.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.moncy.monitoring.job.node.model.AppProperties;

@Service
public class EmailNotificationService implements INotificationService {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private AppProperties appProperties;

    @Override
    public void notify(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(appProperties.getSelf().getSenderEmail());
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }
}
