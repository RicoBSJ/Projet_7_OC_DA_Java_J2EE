package com.aubrun.eric.projet7.beans;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "category")
    private String category;
    @OneToMany( cascade = CascadeType.ALL )
    @LazyCollection( LazyCollectionOption.FALSE )
    @JoinColumn( name = "id_category" )
    private List<Author> authors;
    @OneToMany( cascade = CascadeType.ALL )
    @LazyCollection( LazyCollectionOption.FALSE )
    @JoinColumn( name = "category_id")
    private List<Book> books;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
