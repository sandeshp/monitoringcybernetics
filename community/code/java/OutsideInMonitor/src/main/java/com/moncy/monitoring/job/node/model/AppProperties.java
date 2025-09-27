
package com.moncy.monitoring.job.node.model;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app")
public class AppProperties {

    private Operation operation;
    private Self self;
    private List<Target> targets;

    public AppProperties() {
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public AppProperties(Operation operation, Self self, List<Target> targets) {
        this.operation = operation;
        this.self = self;
        this.targets = targets;
    }

    public Self getSelf() {
        return self;
    }

    public void setSelf(Self self) {
        this.self = self;
    }

    public List<Target> getTargets() {
        return targets;
    }

    public void setTargets(List<Target> targets) {
        this.targets = targets;
    }

    @Override
    public String toString() {
        return "AppProperties{operation=" + operation + ", self=" + self + ", targets=" + targets + "}";
    }
}
