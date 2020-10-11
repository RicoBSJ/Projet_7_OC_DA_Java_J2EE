package com.aubrun.eric.projet7.business.dto;

import java.util.Date;

public class BookDto {

    private Integer bookId;
    private String title;
    private Integer quantity;
    private Boolean renewalLoan;
    private Integer quantityLoan;
    private Date yearBook;
    private AuthorDto bookAuthor;
    private CategoryDto bookCategory;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
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

    public Date getYearBook() {
        return yearBook;
    }

    public void setYearBook(Date yearBook) {
        this.yearBook = yearBook;
    }

    public AuthorDto getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(AuthorDto bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public CategoryDto getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(CategoryDto bookCategory) {
        this.bookCategory = bookCategory;
    }

}
