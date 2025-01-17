package com.shivam.localcachingdemo.entity;


public class Restaurant {
    private String name;
    private Location location;

    // Constructor
    public Restaurant(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", location=" + location +
                '}';
    }
}


