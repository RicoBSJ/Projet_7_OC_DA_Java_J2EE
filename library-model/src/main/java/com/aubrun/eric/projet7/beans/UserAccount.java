package com.aubrun.eric.projet7.beans;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@SequenceGenerator(name = "user_account_id_generator", sequenceName = "user_account_id_seq", allocationSize = 1)
@Table(name = "USER_ACCOUNT")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "user_account_id_generator")
    @Column(name = "id_user_account")
    private Integer userId;
    @Column(name = "user_account_last_name", unique = true)
    private String username;
    @Column(name = "user_account_email")
    private String email;
    @Column(name = "user_account_mot_de_passe")
    private String password;
    @OneToMany
    @JoinColumn(name = "user_account_borrowings")
    private List<Borrowing> borrowingList;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public UserAccount() {
    }

    public UserAccount(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Borrowing> getBorrowingList() {
        return borrowingList;
    }

    public void setBorrowingList(List<Borrowing> borrowingList) {
        this.borrowingList = borrowingList;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", borrowingList=" + borrowingList +
                ", roles=" + roles +
                '}';
    }
}
