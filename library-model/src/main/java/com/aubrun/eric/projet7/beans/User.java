package com.aubrun.eric.projet7.beans;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title")
    private String firstName;
    @Column(name = "title")
    private String name;
    @OneToMany( cascade = CascadeType.ALL )
    @LazyCollection( LazyCollectionOption.FALSE )
    @JoinColumn( name = "id_user")
    private List<Loan> loans;

    public User() {
    }

    public User(String firstName, String name, List<Loan> loans) {
        this.firstName = firstName;
        this.name = name;
        this.loans = loans;
    }

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

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", name='" + name + '\'' +
                ", loans=" + loans +
                '}';
    }
}
