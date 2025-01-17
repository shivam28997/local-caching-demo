package com.shivam.localcachingdemo.controller;

import com.shivam.localcachingdemo.entity.Restaurant;
import com.shivam.localcachingdemo.entity.User;
import com.shivam.localcachingdemo.service.RestaurantService;
import com.shivam.localcachingdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private UserService userService;

    // API to get nearest restaurants for a given user
    @GetMapping("/nearest-restaurants/{username}")
    public List<Restaurant> getNearestRestaurants(@PathVariable String username) {
        // Retrieve the user location from UserService
        User user = userService.getUserLocation(username);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        // Get the nearest restaurants based on the user's location
        return restaurantService.getNearestRestaurants(user);
    }
}

