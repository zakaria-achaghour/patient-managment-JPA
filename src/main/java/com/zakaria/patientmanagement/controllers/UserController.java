package com.zakaria.patientmanagement.controllers;

import com.zakaria.patientmanagement.models.User;
import com.zakaria.patientmanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/{userName}")
    public User user(@PathVariable String userName){
        User user=userService.findUserByUserName(userName);
        return user;
    }
}
