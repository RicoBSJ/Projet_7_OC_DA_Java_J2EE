package com.aubrun.eric.projet7.business.mapper;

import com.aubrun.eric.projet7.beans.Book;
import com.aubrun.eric.projet7.business.dto.BookDto;

public class BookDtoMapper {

    static public BookDto toDto(Book book) {

        BookDto dto = new BookDto();
        dto.setId(book.getId());
        dto.setQuantity(book.getQuantity());
        dto.setRenewalLoan(book.getRenewalLoan());
        dto.setQuantityLoan(book.getQuantityLoan());
        dto.setYear(book.getYear());
        /*dto.setAuthor(AuthorDtoMapper.toDto(book.getAuthor()));*/
        dto.setCategory(book.getCategory());
        return dto;
    }

    static public Book toEntity(BookDto bookDto) {

        Book entity = new Book();
        entity.setId(bookDto.getId());
        entity.setTitle(bookDto.getTitle());
        entity.setQuantity(bookDto.getQuantity());
        entity.setRenewalLoan(bookDto.getRenewalLoan());
        entity.setQuantityLoan(bookDto.getQuantityLoan());
        entity.setYear(bookDto.getYear());
        /*entity.setAuthor(AuthorDtoMapper.toEntity(bookDto.getAuthor()));*/
        entity.setCategory(bookDto.getCategory());
        return entity;
    }
}