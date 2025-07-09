package com.fxf.springboot.basic.controller;

import com.fxf.springboot.basic.dto.UserDto;
import com.fxf.springboot.basic.entity.User;
import com.fxf.springboot.basic.service.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("rawtypes")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/add-users")
    public ResponseEntity<List<User>> createUsers(@RequestBody List<User> users) {
        return new ResponseEntity<List<User>>(userService.createUsers(users), 
        HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    public UserDto getUser(@PathVariable("id") Integer id) {
        ModelMapper modelMapper = new ModelMapper();
        User userDb = userService.getUserById(id);
        return modelMapper.map(userDb, UserDto.class);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAll();
    }

    @PutMapping("/user/{id}")
    public User updateUser(@RequestBody User user, @PathVariable("id") Integer id) {
        user.setId(id);
        return userService.updateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        return userService.deleteUserById(id);
    }
}

