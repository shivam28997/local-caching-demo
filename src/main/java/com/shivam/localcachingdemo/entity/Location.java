package com.shivam.localcachingdemo.entity;

public class Location {
    private double x;
    private double y;

    // Constructor
    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Getters and setters
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
