package com.aubrun.eric.projet7.business.dto;

import java.util.List;

public class AuthorDto {

    private Integer authorId;
    private String firstName;
    private String nameAuthor;
    private List<BookDto> authorBooks;

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public List<BookDto> getAuthorBooks() {
        return authorBooks;
    }

    public void setAuthorBooks(List<BookDto> authorBooks) {
        this.authorBooks = authorBooks;
    }

    @Override
    public String toString() {
        return "AuthorDto{" +
                "authorId=" + authorId +
                ", firstName='" + firstName + '\'' +
                ", nameAuthor='" + nameAuthor + '\'' +
                ", authorBooks=" + authorBooks +
                '}';
    }
}
