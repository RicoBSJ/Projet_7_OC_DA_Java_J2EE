package com.aubrun.eric.projet7.beans;

import java.util.Date;

public class Book {

    private Integer id;
    private String title;
    private String category;
    private Date year;
    private Author author;

    public Book() {
    }

    public Book(String title, String category, Date year, Author author) {
        this.title = title;
        this.category = category;
        this.year = year;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", year=" + year +
                ", author=" + author +
                '}';
    }
}
