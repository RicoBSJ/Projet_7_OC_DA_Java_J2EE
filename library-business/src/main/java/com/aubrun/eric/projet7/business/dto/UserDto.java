package com.aubrun.eric.projet7.business.dto;

import java.util.List;

public class UserDto {

    private Integer userId;
    private String firstName;
    private String nameUser;
    private String email;
    private String motDePasse;
    private List<LoanDto> loanList;

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

    public List<LoanDto> getLoanList() {
        return loanList;
    }

    public void setLoanList(List<LoanDto> loanList) {
        this.loanList = loanList;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", nameUser='" + nameUser + '\'' +
                ", email='" + email + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                ", loanList=" + loanList +
                '}';
    }
}
