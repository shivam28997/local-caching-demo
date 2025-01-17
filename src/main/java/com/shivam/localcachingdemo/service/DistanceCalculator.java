package com.shivam.localcachingdemo.service;

import com.shivam.localcachingdemo.entity.Location;
import org.springframework.stereotype.Service;

@Service
public class DistanceCalculator {

    public double calculateDistance(Location userLocation, Location restaurantLocation) {
        double x1 = userLocation.getLatitude();
        double y1 = userLocation.getLongitude();
        double x2 = restaurantLocation.getLatitude();
        double y2 = restaurantLocation.getLongitude();
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

}
