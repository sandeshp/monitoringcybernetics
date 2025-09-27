
package com.moncy.monitoring.job.node.model;

public class Location {
    private String country;
    private String state;
    private String city;
    private double latitude;
    private double longitude;
    private String carrier;

    public Location() {
    }

    public Location(String country, String state, String city, double latitude, double longitude, String carrier) {
        this.country = country;
        this.state = state;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
        this.carrier = carrier;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    @Override
    public String toString() {
        return "Location{country='" + country + "', state='" + state + "', city='" + city + "', latitude=" + latitude + ", longitude=" + longitude + ", carrier='" + carrier + "'}";
    }
}
