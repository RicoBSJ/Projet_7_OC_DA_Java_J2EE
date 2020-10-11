package com.aubrun.eric.projet7.beans;

import javax.persistence.*;
import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Integer authorId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "name_author")
    private String nameAuthor;
    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name = "author_books")
    private List<Book> authorBooks;

    public Author() {
    }

    public Author(Integer authorId, String firstName, String nameAuthor, List<Book> authorBooks) {
        this.authorId = authorId;
        this.firstName = firstName;
        this.nameAuthor = nameAuthor;
        this.authorBooks = authorBooks;
    }

    public Author(String firstName, String nameAuthor, List<Book> authorBooks) {
        this.firstName = firstName;
        this.nameAuthor = nameAuthor;
        this.authorBooks = authorBooks;
    }

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

    public List<Book> getAuthorBooks() {
        return authorBooks;
    }

    public void setAuthorBooks(List<Book> authorBooks) {
        this.authorBooks = authorBooks;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", firstName='" + firstName + '\'' +
                ", nameAuthor='" + nameAuthor + '\'' +
                ", authorBooks=" + authorBooks +
                '}';
    }
}
