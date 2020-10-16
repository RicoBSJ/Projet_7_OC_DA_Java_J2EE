package com.aubrun.eric.projet7.controllers;

import com.aubrun.eric.projet7.business.dto.UserDto;
import com.aubrun.eric.projet7.business.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<UserDto> getAllUsers() {
        return this.userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable(value = "id") int userId) {
        return this.userService.findById(userId);
    }

    @PostMapping("/")
    public int createUser(@RequestBody UserDto userDto) {
        userService.save(userDto);
        return userDto.getUserId();
    }

    @PutMapping("/user")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        userService.update(userDto);
        return userDto;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int userId) {
        userService.delete(userId);
    }
}
