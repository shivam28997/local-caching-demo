package com.shivam.localcachingdemo.controller;

import com.shivam.localcachingdemo.entity.User;
import com.shivam.localcachingdemo.entity.Restaurant;
import com.shivam.localcachingdemo.service.RestaurantService;
import com.shivam.localcachingdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private UserService userService;

    // Get nearest restaurants
    @GetMapping("/nearest")
    public List<Restaurant> getNearestRestaurants(@RequestBody User user) {
        if(userService.userExist(user)) {
            return restaurantService.getNearestRestaurants(user);
        }
        return null;
    }

    // Get all restaurants sorted by distance
    @GetMapping("/all")
    public List<Restaurant> getAllRestaurantsSortedByDistance(@RequestBody User user) {
        if(userService.userExist(user)) {
            return restaurantService.getAllRestaurantsSortedByDistance(user);
        }
        return null;
    }

    // Get a restaurant by name
    @GetMapping("/search/{name}")
    public Optional<Restaurant> getRestaurantByName(@RequestBody User user, @PathVariable String name) {
        if(userService.userExist(user)) {
            return restaurantService.getRestaurantByName(name);
        }
        return null;
    }
}
