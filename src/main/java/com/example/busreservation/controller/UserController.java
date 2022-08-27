package com.example.busreservation.controller;

import com.example.busreservation.model.User;
import com.example.busreservation.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/dummy/register")
    public void saveUser()

    @GetMapping(value = "/admin/getUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
}
