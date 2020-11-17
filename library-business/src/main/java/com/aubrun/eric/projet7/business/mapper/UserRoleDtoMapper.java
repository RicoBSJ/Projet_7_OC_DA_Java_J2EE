package com.aubrun.eric.projet7.business.mapper;

import com.aubrun.eric.projet7.beans.UserRole;
import com.aubrun.eric.projet7.business.dto.UserRoleDto;

public class UserRoleDtoMapper {

    static public UserRoleDto toDto(UserRole userRole) {

        UserRoleDto dto = new UserRoleDto();
        dto.setUserRoleId(userRole.getUserRoleId());
        dto.setUserRoleName(userRole.getUserRoleName());
        return dto;
    }

    static public UserRole toEntity(UserRoleDto userRoleDto) {

        UserRole entity = new UserRole();
        entity.setUserRoleId(userRoleDto.getUserRoleId());
        entity.setUserRoleName(userRoleDto.getUserRoleName());
        return entity;
    }
}
