package com.aubrun.eric.projet7.beans;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "category")
    private String category;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "renewalLoan")
    private Boolean renewalLoan;
    @Column(name = "quantityLoan")
    private Integer quantityLoan;
    @Column(name = "year")
    private Date year;
    @ManyToOne( cascade = { CascadeType.ALL } )
    @JoinColumn( name = "id_book" )
    private Author author;

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
}
