package com.aubrun.eric.projet7.beans;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "booksList")
    private List<Book> books;
    @ManyToOne( cascade = { CascadeType.ALL } )
    @JoinColumn( name = "id_loan" )
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
