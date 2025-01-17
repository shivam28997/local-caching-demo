package com.shivam.localcachingdemo.service;

import com.shivam.localcachingdemo.entity.Location;
import com.shivam.localcachingdemo.entity.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    // In-memory storage for users
    private final Map<String, User> users = new HashMap<>();

    // Create a new user
    public User createUser(String username, Location location) {
        User newUser = new User(username, location);
        users.put(username, newUser);
        return newUser;
    }

    // Get the location of a user
    @Cacheable(value = "users", key = "#username")
    public User getUserLocation(String username) {
        return users.get(username); // Get user location from in-memory storage
    }

    // Update the location of an existing user and evict nearby restaurants from cache
    @CacheEvict(value = {"users", "restaurants"}, key = "#username")  // Evict both users and restaurants caches
    public User updateUserLocation(String username, Location newLocation) {
        User updatedUser = users.get(username);
        if (updatedUser != null) {
            updatedUser.setLocation(newLocation);
            users.put(username, updatedUser);
            return updatedUser;
        }
        return null;
    }
}
