package com.aubrun.eric.projet7.business.dto;

import com.aubrun.eric.projet7.beans.UserAccount;

import java.util.List;

public class UserRoleDto {

    private Integer userRoleId;
    private String userRoleName;

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getUserRoleName() {
        return userRoleName;
    }

    public void setUserRoleName(String userRoleName) {
        this.userRoleName = userRoleName;
    }
}
