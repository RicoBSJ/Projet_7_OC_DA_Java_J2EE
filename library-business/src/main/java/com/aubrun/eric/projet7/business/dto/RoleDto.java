package com.aubrun.eric.projet7.business.dto;

import com.aubrun.eric.projet7.beans.ERole;

public class RoleDto {

    private Integer roleId;
    private ERole roleName;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public ERole getRoleName() {
        return roleName;
    }

    public void setRoleName(ERole roleName) {
        this.roleName = roleName;
    }
}
