package com.shivam.localcachingdemo.entity;

public class Location {
    private double latitude;
    private double longitude;

    // Constructor
    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getters and setters
    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "Location{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
