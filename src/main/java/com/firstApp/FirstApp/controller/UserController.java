package com.firstApp.FirstApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.firstApp.FirstApp.entity.User;
import com.firstApp.FirstApp.services.UserService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class UserController  {
    @Autowired private UserService userService;
     // Save operation

    @PostMapping("/user") 
    public User saveUser(@Validated @RequestBody User user)
    {
        return userService.saveUser(user);
    }

    @GetMapping("/user") 
    public List<User> fetchUsers()
    {
        return userService.fetchUserList();
    }

    @PutMapping("/user/{id}") 
    public User
    updatUser(@RequestBody User user, @PathVariable("id") Long uLong)
    {
        return userService.updateUser(user, uLong);
    }

     @DeleteMapping("/user/{id}") 
    public String deleteUser(@PathVariable("id") Long uLong)
    {
        userService.deleteUserById(uLong);
        return "Deleted Successfully";
    }
}
