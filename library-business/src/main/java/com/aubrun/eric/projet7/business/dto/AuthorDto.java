package com.aubrun.eric.projet7.business.dto;

import com.aubrun.eric.projet7.beans.Book;

import java.util.List;

public class AuthorDto {

    private Integer id;
    private String firstName;
    private String name;
    private List<BookDto> books;

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

    public List<BookDto> getBooks() {
        return books;
    }

    public void setBooks(List<BookDto> books) {
        this.books = books;
    }
}
