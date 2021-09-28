package com.example.listingapp.controller;


import com.example.listingapp.dto.UserDto;
import com.example.listingapp.model.User;
import com.example.listingapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RestController
public class UserController {

private final UserService userService;
private final ModelMapper mapper;
@GetMapping("/users")
public List<UserDto> findAllUsers() {

    List<User> all = userService.getAllUsers();
    List<UserDto> userDtos = new ArrayList<>();
    for (User user : all) {
        UserDto userDto = mapper.map(user, UserDto.class);
        userDtos.add(userDto);

    }
    return userDtos;
}
@PostMapping("/users/{id}")
public UserDto getUserById(@PathVariable("id") int id ){
    return mapper.map(userService.getUserById(id), UserDto.class);
}

    @PostMapping("/users/add")
    public UserDto addUser(@RequestBody User user){
        return mapper.map(userService.addUser(mapper.map(user,User.class)), UserDto.class);


    }

    @PutMapping("/users/{id}")
    public UserDto putCategory(@PathVariable int id , @RequestBody User user) {
        return mapper.map(userService.putUser(id,mapper.map(user,User.class)), UserDto.class);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}
