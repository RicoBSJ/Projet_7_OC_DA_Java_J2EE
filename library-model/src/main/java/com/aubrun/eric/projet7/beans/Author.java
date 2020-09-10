package com.aubrun.eric.projet7.beans;

import java.util.List;

public class Author {

    private Integer id;
    private String firstName;
    private String name;
    private Boolean loan;
    private List<Book> books;

    public Author() {
    }

    public Author(String firstName, String name, Boolean loan, List<Book> books) {
        this.firstName = firstName;
        this.name = name;
        this.loan = loan;
        this.books = books;
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

    public Boolean getLoan() {
        return loan;
    }

    public void setLoan(Boolean loan) {
        this.loan = loan;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", name='" + name + '\'' +
                ", loan=" + loan +
                ", books=" + books +
                '}';
    }
}
