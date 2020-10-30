package com.aubrun.eric.projet7.beans;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="user_account_id_generator", sequenceName = "user_account_id_seq", allocationSize=1)
@Table(name = "USER_ACCOUNT")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "user_account_id_generator")
    @Column(name = "id_user_account")
    private Integer userId;
    @Column(name = "user_account_first_name")
    private String firstName;
    @Column(name = "user_account_last_name")
    private String nameUser;
    @Column(name = "user_account_email")
    private String email;
    @Column(name = "user_account_mot_de_passe")
    private String motDePasse;

    public UserAccount() {
        super();
    }

    public UserAccount(Integer userId, String firstName, String nameUser, String email, String motDePasse) {
        this.userId = userId;
        this.firstName = firstName;
        this.nameUser = nameUser;
        this.email = email;
        this.motDePasse = motDePasse;
    }

    public UserAccount(String firstName, String nameUser, String email, String motDePasse) {
        this.firstName = firstName;
        this.nameUser = nameUser;
        this.email = email;
        this.motDePasse = motDePasse;
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

    @Override
    public String toString() {
        return "UserAccount{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", nameUser='" + nameUser + '\'' +
                ", email='" + email + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                '}';
    }
}
