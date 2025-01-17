package com.shivam.localcachingdemo.entity;

public class User {
    private String username;
    private Location location;

    // Constructor
    public User(String username, Location location) {
        this.username = username;
        this.location = location;
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", location=" + location +
                '}';
    }
}
