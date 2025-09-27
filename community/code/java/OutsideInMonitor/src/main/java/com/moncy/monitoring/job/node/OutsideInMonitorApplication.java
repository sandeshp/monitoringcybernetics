package com.moncy.monitoring.job.node;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;

import com.moncy.monitoring.job.node.model.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
@EnableAsync
public class OutsideInMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(OutsideInMonitorApplication.class, args);
	}
}
