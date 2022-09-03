package com.pilgrims.travelagency.controllers;

import com.pilgrims.travelagency.models.User;
import com.pilgrims.travelagency.services.implementations.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller to handle all user related requests
 *
 * @author Ott Pikk
 */
@RestController
@CrossOrigin(origins = "http:://localhost:4200")
public class UserController {
    private UserServiceImpl userServiceImpl;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userServiceImpl.findAllUsers();
    }

    @PostMapping("/users")
    void addUser(@RequestBody User user) {
        userServiceImpl.createUser(user);
    }

}






