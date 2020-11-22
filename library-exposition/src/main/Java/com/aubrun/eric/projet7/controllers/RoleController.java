package com.aubrun.eric.projet7.controllers;

import com.aubrun.eric.projet7.business.dto.RoleDto;
import com.aubrun.eric.projet7.business.service.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/")
    public List<RoleDto> getAllUserRoles() {
        return this.roleService.findAll();
    }

    @GetMapping("/{id}")
    public RoleDto getUserRolesById(@PathVariable(value = "id") int userId) {
        return this.roleService.findById(userId);
    }

    @PostMapping("/")
    public void createUserRole(@RequestBody RoleDto roleDto) {
        roleService.save(roleDto);
    }

    @PutMapping("/role")
    public void updateUserRole(@RequestBody RoleDto roleDto) {
        roleService.update(roleDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUserRole(@PathVariable("id") int userId) {
        roleService.deleteById(userId);
    }
}
