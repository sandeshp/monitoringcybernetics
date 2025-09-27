package com.moncy.monitoring.job.node.model;

public class Target {

    private String name;
    private String url;
    private String email;
    private int intervalMins;

    public Target() {
    }

    public Target(String name, String url, String email, int intervalMins) {
        this.name = name;
        this.url = url;
        this.email = email;
        this.intervalMins = intervalMins;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIntervalMins() {
        return intervalMins;
    }

    public void setIntervalMins(int intervalMins) {
        this.intervalMins = intervalMins;
    }

    public int getRunMultiple(int recurrenceMins, int total_nodes) {
        return this.intervalMins / (recurrenceMins * total_nodes);
    }

    @Override
    public String toString() {
        return "Target{name='" + name + "', url='" + url + "', email='" + email + "', intervalMins=" + intervalMins + "}";
    }
}


