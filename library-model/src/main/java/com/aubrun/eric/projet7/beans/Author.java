package com.aubrun.eric.projet7.beans;

import javax.persistence.*;
import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "author_id")
    private Integer authorId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "name_author")
    private String nameAuthor;

    public Author() {
        super();
    }

    public Author(Integer authorId, String firstName, String nameAuthor) {
        super();
        this.authorId = authorId;
        this.firstName = firstName;
        this.nameAuthor = nameAuthor;
    }

    public Author(String firstName, String nameAuthor) {
        super();
        this.firstName = firstName;
        this.nameAuthor = nameAuthor;
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

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", firstName='" + firstName + '\'' +
                ", nameAuthor='" + nameAuthor + '\'' +
                '}';
    }
}
