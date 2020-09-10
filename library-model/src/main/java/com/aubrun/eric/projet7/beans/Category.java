package com.aubrun.eric.projet7.beans;

import java.util.List;

public class Category {

    private Integer id;
    private String category;
    private List<Author> authors;
    private List<Book> books;

    public Category() {
    }

    public Category(String category, List<Author> authors, List<Book> books) {
        this.category = category;
        this.authors = authors;
        this.books = books;
    }

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

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", authors=" + authors +
                ", books=" + books +
                '}';
    }
}
