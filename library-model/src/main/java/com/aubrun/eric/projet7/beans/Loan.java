package com.aubrun.eric.projet7.beans;

import javax.persistence.*;

@Entity
public class Loan {

    @Id
    @GeneratedValue
    private Integer id;
    @OneToOne
    @JoinColumn
    private Book book;

    public Loan() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", book=" + book +
                '}';
    }
}
