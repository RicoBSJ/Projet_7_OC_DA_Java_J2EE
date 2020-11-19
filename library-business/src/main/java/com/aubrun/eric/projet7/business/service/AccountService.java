package com.aubrun.eric.projet7.business.service;

import com.aubrun.eric.projet7.beans.UserAccount;
import com.aubrun.eric.projet7.beans.UserRole;

public interface AccountService {

    UserAccount saveUser(UserAccount userAccount);
    UserRole saveRole(UserRole userRole);
    void addRoleToUser(String username, String roleName);
    UserAccount findUserByUserName(String username);
}
