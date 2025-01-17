package com.shivam.localcachingdemo.controller;

import com.shivam.localcachingdemo.entity.Location;
import com.shivam.localcachingdemo.entity.User;
import com.shivam.localcachingdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // Create a new user with a given username and location
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    // Update the location of an existing user
    @PutMapping("/update/{username}")
    public ResponseEntity<User> updateUserLocation(@PathVariable String username, @RequestBody Location newLocation) {
        User user = userService.updateUserLocation(username, newLocation);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    // Get the current location of a user
    @GetMapping("/{username}")
    public ResponseEntity<User> getUserLocation(@PathVariable String username) {
        User user = userService.getUserLocation(username);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
