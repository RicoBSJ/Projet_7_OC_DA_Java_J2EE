package com.aubrun.eric.projet7.beans;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String title;
    @Column
    private Integer quantity;
    @Column
    private Boolean renewalLoan;
    @Column
    private Integer quantityLoan;
    @Column
    private Date year;
    @ManyToOne( cascade = { CascadeType.ALL } )
    @JoinColumn
    private Author author;
    @ManyToOne( cascade = { CascadeType.ALL } )
    @JoinColumn
    private Category category;

    public Book() {
    }

    public Book(Integer id, String title, Integer quantity, Boolean renewalLoan, Integer quantityLoan, Date year, Author author, Category category) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
        this.renewalLoan = renewalLoan;
        this.quantityLoan = quantityLoan;
        this.year = year;
        this.author = author;
        this.category = category;
    }

    public Book(String title, Integer quantity, Boolean renewalLoan, Integer quantityLoan, Date year, Author author, Category category) {
        this.title = title;
        this.quantity = quantity;
        this.renewalLoan = renewalLoan;
        this.quantityLoan = quantityLoan;
        this.year = year;
        this.author = author;
        this.category = category;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Boolean getRenewalLoan() {
        return renewalLoan;
    }

    public void setRenewalLoan(Boolean renewalLoan) {
        this.renewalLoan = renewalLoan;
    }

    public Integer getQuantityLoan() {
        return quantityLoan;
    }

    public void setQuantityLoan(Integer quantityLoan) {
        this.quantityLoan = quantityLoan;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", quantity=" + quantity +
                ", renewalLoan=" + renewalLoan +
                ", quantityLoan=" + quantityLoan +
                ", year=" + year +
                ", author=" + author +
                ", category=" + category +
                '}';
    }
}
