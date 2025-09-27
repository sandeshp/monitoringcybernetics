package com.moncy.monitoring.job.node.model;

public class Self {
    private int num;
    private String id;
    private String name;
    private String sender_email;
    private String description;
    private Location location;

    public Self() {
    }

    public Self(int num, String id, String name, String sender_email, String description, Location location) {
        this.num = num;
        this.id = id;
        this.name = name;
        this.sender_email = sender_email;
        this.description = description;
        this.location = location;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSenderEmail() {
        return sender_email;
    }

    public void setSenderEmail(String sender_email) {
        this.sender_email = sender_email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Self{id='" + id + "', name='" + name + "', description='" + description + "', location=" + location + "}";
    } 
}
