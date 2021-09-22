package com.example.listingapp.controller;


import com.example.listingapp.model.User;
import com.example.listingapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RestController
public class UserController {

private final UserService userService;

@GetMapping("/users")
public List<User> users(){
    return  userService.getAllUsers();
}

@PostMapping("/users/{id}")
public User getUserById(@PathVariable("id") int id ){
   return userService.getUserById(id);
}

    @PostMapping("/users/add")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);

    }

    @PutMapping("/users/{id}")
    public User putCategory(@PathVariable int id , @RequestBody User user) {
        return userService.putUser(id, user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}
