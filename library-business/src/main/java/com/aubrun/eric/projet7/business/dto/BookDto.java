package com.aubrun.eric.projet7.business.dto;

import java.util.Date;

public class BookDto {

    private Integer id;
    private String title;
    private Integer quantity;
    private Boolean renewalLoan;
    private Integer quantityLoan;
    private Date year;
    private AuthorDto authorDto;
    private CategoryDto categoryDto;

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

    public AuthorDto getAuthorDto() {
        return authorDto;
    }

    public void setAuthorDto(AuthorDto authorDto) {
        this.authorDto = authorDto;
    }

    public CategoryDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(CategoryDto categoryDto) {
        this.categoryDto = categoryDto;
    }
}
