package com.aubrun.eric.projet7.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import java.util.List;

@Entity
@SequenceGenerator(name = "user_account_id_generator", sequenceName = "user_account_id_seq", allocationSize = 1)
@Table(name = "USER_ACCOUNT")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "user_account_id_generator")
    @Column(name = "id_user_account")
    private Long userId;
    @Column(name = "user_account_first_name")
    private String firstName;
    @Column(name = "user_account_last_name", unique = true)
    private String nameUser;
    @Column(name = "user_account_email")
    private String email;
    @Column(name = "user_account_mot_de_passe")
    private String motDePasse;
    @JoinColumn(name = "user_account_borrowings")
    @OneToMany
    private List<Borrowing> borrowingList;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    public UserAccount() {
    }

    public UserAccount(String nameUser, String email, String motDePasse) {
        this.nameUser = nameUser;
        this.email = email;
        this.motDePasse = motDePasse;
    }

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

    @JsonIgnore
    public String getMotDePasse() {
        return motDePasse;
    }

    @JsonSetter
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public List<Borrowing> getBorrowingList() {
        return borrowingList;
    }

    public void setBorrowingList(List<Borrowing> borrowingList) {
        this.borrowingList = borrowingList;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", nameUser='" + nameUser + '\'' +
                ", email='" + email + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                ", borrowingList=" + borrowingList +
                '}';
    }
}
