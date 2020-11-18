package com.aubrun.eric.projet7.controllers;

import com.aubrun.eric.projet7.business.dto.UserAccountDto;
import com.aubrun.eric.projet7.business.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserAccountController {

    private final UserAccountService userAccountService;

    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @GetMapping("/")
    public List<UserAccountDto> getAllUsers() {
        return this.userAccountService.findAll();
    }

    @GetMapping("/{id}")
    public UserAccountDto getUserById(@PathVariable(value = "id") int userId) {
        return this.userAccountService.findById(userId);
    }

    @PostMapping("/")
    public void createUser(@RequestBody UserAccountDto userAccountDto) {
        userAccountService.save(userAccountDto);
    }

    @PostMapping("/roleUser")
    public void addUserWithRole(@RequestBody String username, String roleName){
        userAccountService.addRoleToUser(username, roleName);
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserAccountDto userAccountDto) {
        userAccountService.update(userAccountDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int userId) {
        userAccountService.delete(userId);
    }
}
