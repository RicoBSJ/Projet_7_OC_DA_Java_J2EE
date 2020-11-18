package com.aubrun.eric.projet7.controllers;

import com.aubrun.eric.projet7.business.dto.UserAccountDto;
import com.aubrun.eric.projet7.business.dto.UserRoleDto;
import com.aubrun.eric.projet7.business.service.UserRoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class UserRoleController {

    private final UserRoleService userRoleService;

    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @GetMapping("/")
    public List<UserRoleDto> getAllUserRoles() {
        return this.userRoleService.findAll();
    }

    @GetMapping("/{id}")
    public UserRoleDto getUserRolesById(@PathVariable(value = "id") int userId) {
        return this.userRoleService.findById(userId);
    }

    @PostMapping("/")
    public void createUserRole(@RequestBody UserRoleDto userRoleDto) {
        userRoleService.save(userRoleDto);
    }

    @PutMapping("/role")
    public void updateUserRole(@RequestBody UserRoleDto userRoleDto) {
        userRoleService.update(userRoleDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUserRole(@PathVariable("id") int userId) {
        userRoleService.delete(userId);
    }

    @GetMapping("/roleName")
    public UserRoleDto getByNameRole(String username){
        return userRoleService.obtainByNameRole(username);
    }
}
