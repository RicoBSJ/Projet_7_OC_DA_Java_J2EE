package com.aubrun.eric.projet7.business.dto;

import java.util.List;

public class UserDto {

    private Integer id;
    private String firstName;
    private String name;
    private String email;
    private String motDePasse;
    private List<LoanDto> loans;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<LoanDto> getLoans() {
        return loans;
    }

    public void setLoans(List<LoanDto> loans) {
        this.loans = loans;
    }
}
