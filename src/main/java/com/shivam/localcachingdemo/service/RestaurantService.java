package com.shivam.localcachingdemo.service;

import com.shivam.localcachingdemo.entity.Location;
import com.shivam.localcachingdemo.entity.Restaurant;
import com.shivam.localcachingdemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    @Autowired
    private DistanceCalculator distanceCalculator;

    private static final Map<Integer, Restaurant> restaurants = new HashMap<>();

    static {
        // Initialize with some mock restaurants
        for (int i = 0; i < 50; i++) {
            restaurants.put(i, new Restaurant("Restaurant " + i, new Location(Math.random() * 100, Math.random() * 100)));
        }
    }

    // Caching the nearest restaurants based on user location
    @Cacheable(value = "restaurants", key = "#user.username")
    public List<Restaurant> getNearestRestaurants(User user) {
        return restaurants.values().stream()
                .sorted((r1, r2) -> {
                    double distance1 = distanceCalculator.calculateDistance(user.getLocation(), r1.getLocation());
                    double distance2 = distanceCalculator.calculateDistance(user.getLocation(), r2.getLocation());
                    return Double.compare(distance1, distance2);
                })
                .limit(10)  // return top 10 nearest restaurants
                .collect(Collectors.toList());
    }

}
