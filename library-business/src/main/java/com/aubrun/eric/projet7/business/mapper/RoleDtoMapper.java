package com.aubrun.eric.projet7.business.mapper;

import com.aubrun.eric.projet7.beans.Role;
import com.aubrun.eric.projet7.business.dto.RoleDto;

public class RoleDtoMapper {

    static public RoleDto toDto(Role role) {

        RoleDto dto = new RoleDto();
        dto.setRoleId(role.getRoleId());
        dto.setRoleName(role.getRoleName());
        return dto;
    }

    static public Role toEntity(RoleDto roleDto) {

        Role entity = new Role();
        entity.setRoleId(roleDto.getRoleId());
        entity.setRoleName(roleDto.getRoleName());
        return entity;
    }
}
