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
    public List<UserDto> getAllUsers(){
        return this.userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable(value = "id") int userId){
        return this.userService.findById(userId);
    }

    @PostMapping(name = "/", consumes = "application/json", produces = "application/json")
    public void createUser(@RequestBody UserDto userDto){
        userService.saveOrUpdate(userDto);
    }

    @PutMapping("/{id}")
    public void updateUser(@RequestBody UserDto userDto, @PathVariable("id") int userId){
        UserDto existingUser = userService.findById(userId);
        existingUser.setFirstName(userDto.getFirstName());
        existingUser.setName(userDto.getFirstName());
        existingUser.setEmail(userDto.getEmail());
        existingUser.setMotDePasse(userDto.getMotDePasse());
        existingUser.setLoans(userDto.getLoans());
        userService.saveOrUpdate(existingUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int userId){
        UserDto existingUser = userService.findById(userId);
        userService.delete(existingUser.getId());
    }
}
