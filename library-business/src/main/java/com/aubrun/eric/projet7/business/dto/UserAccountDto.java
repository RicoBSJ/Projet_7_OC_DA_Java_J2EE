package com.aubrun.eric.projet7.business.dto;

import java.util.List;
import java.util.Set;

public class UserAccountDto {

    private Long userId;
    private String firstName;
    private String nameUser;
    private String email;
    private String motDePasse;
    private List<BorrowingDto> borrowingDtoList;
    private Set<RoleDto> roleDtos;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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

    public Set<RoleDto> getRoleDtos() {
        return roleDtos;
    }

    public void setRoleDtos(Set<RoleDto> roleDtos) {
        this.roleDtos = roleDtos;
    }
}
