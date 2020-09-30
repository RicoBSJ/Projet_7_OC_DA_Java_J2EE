package com.aubrun.eric.projet7.business.dto;

import com.aubrun.eric.projet7.beans.Book;

public class LoanDto {

    private Integer id;
    private BookDto bookDto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BookDto getBookDto() {
        return bookDto;
    }

    public void setBookDto(BookDto bookDto) {
        this.bookDto = bookDto;
    }
}
