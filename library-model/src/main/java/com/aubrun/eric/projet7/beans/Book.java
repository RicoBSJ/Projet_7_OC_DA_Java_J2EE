package com.aubrun.eric.projet7.beans;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String title;
    @Column
    private String category;
    @Column
    private Integer quantity;
    @Column
    private Boolean renewalLoan;
    @Column
    private Integer quantityLoan;
    @Column
    private Date year;
    @ManyToOne
    @JoinColumn
    private Author author;

    public Book() {
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

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", quantity=" + quantity +
                ", renewalLoan=" + renewalLoan +
                ", quantityLoan=" + quantityLoan +
                ", year=" + year +
                ", author=" + author +
                '}';
    }
}
