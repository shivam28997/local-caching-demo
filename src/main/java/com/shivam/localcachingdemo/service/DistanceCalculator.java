package com.shivam.localcachingdemo.service;

import com.shivam.localcachingdemo.entity.Location;
import org.springframework.stereotype.Service;

@Service
public class DistanceCalculator {

    public double calculateDistance(Location userLocation, Location restaurantLocation) {
        double x1 = userLocation.getX();
        double y1 = userLocation.getY();
        double x2 = restaurantLocation.getX();
        double y2 = restaurantLocation.getY();
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

}
