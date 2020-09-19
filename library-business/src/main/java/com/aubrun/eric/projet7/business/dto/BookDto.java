package com.aubrun.eric.projet7.business.dto;

import com.aubrun.eric.projet7.beans.Category;

import java.util.Date;

public class BookDto {

    private Integer id;
    private String title;
    private Integer quantity;
    private Boolean renewalLoan;
    private Integer quantityLoan;
    private Date year;
    private AuthorDto authorDto;
    private Category category;

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

    public AuthorDto getAuthor() {
        return authorDto;
    }

    public void setAuthor(AuthorDto authorDto) {
        this.authorDto = authorDto;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
