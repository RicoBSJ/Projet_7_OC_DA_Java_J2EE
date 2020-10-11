package com.aubrun.eric.projet7.beans;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "name_user")
    private String nameUser;
    @Column(name = "email")
    private String email;
    @Column(name = "mot_de_passe")
    private String motDePasse;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "loan_list")
    private List<Loan> loanList;

    public UserAccount() {
    }

    public UserAccount(Integer userId, String firstName, String nameUser, String email, String motDePasse, List<Loan> loanList) {
        this.userId = userId;
        this.firstName = firstName;
        this.nameUser = nameUser;
        this.email = email;
        this.motDePasse = motDePasse;
        this.loanList = loanList;
    }

    public UserAccount(String firstName, String nameUser, String email, String motDePasse, List<Loan> loanList) {
        this.firstName = firstName;
        this.nameUser = nameUser;
        this.email = email;
        this.motDePasse = motDePasse;
        this.loanList = loanList;
    }

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

    public List<Loan> getLoanList() {
        return loanList;
    }

    public void setLoanList(List<Loan> loanList) {
        this.loanList = loanList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + userId +
                ", firstName='" + firstName + '\'' +
                ", name='" + nameUser + '\'' +
                ", email='" + email + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                ", loans=" + loanList +
                '}';
    }
}
