package com.aubrun.eric.projet7.business.dto;

import com.aubrun.eric.projet7.beans.UserAccount;
import com.aubrun.eric.projet7.beans.UserRole;

import java.util.List;

public class UserAccountDto {

    private Integer userId;
    private String firstName;
    private String nameUser;
    private String email;
    private String motDePasse;
    private List<BorrowingDto> borrowingDtoList;
    private List<UserRoleDto> userRoleDtoList;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public List<BorrowingDto> getBorrowingDtoList() {
        return borrowingDtoList;
    }

    public void setBorrowingDtoList(List<BorrowingDto> borrowingDtoList) {
        this.borrowingDtoList = borrowingDtoList;
    }

    public List<UserRoleDto> getUserRoleDtoList() {
        return userRoleDtoList;
    }

    public void setUserRoleDtoList(List<UserRoleDto> userRoleDtoList) {
        this.userRoleDtoList = userRoleDtoList;
    }
}
