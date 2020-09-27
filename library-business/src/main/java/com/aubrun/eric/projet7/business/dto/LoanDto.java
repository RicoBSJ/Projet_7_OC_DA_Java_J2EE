package com.aubrun.eric.projet7.business.dto;

import com.aubrun.eric.projet7.beans.Book;

public class LoanDto {

    private Integer id;
    private Book book;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
