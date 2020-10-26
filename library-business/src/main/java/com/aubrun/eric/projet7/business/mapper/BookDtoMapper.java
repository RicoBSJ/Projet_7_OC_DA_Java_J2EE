package com.aubrun.eric.projet7.business.mapper;

import com.aubrun.eric.projet7.beans.Book;
import com.aubrun.eric.projet7.business.dto.BookDto;

public class BookDtoMapper {

    static public BookDto toDto(Book book) {

        BookDto dto = new BookDto();
        dto.setBookId(book.getBookId());
        dto.setTitle(book.getTitle());
        dto.setQuantity(book.getQuantity());
        dto.setRenewalLoan(book.getRenewalLoan());
        dto.setQuantityLoan(book.getQuantityLoan());
        dto.setYearBook(book.getYearBook());
        dto.setBookAuthor(AuthorDtoMapper.toDto(book.getBookAuthor()));
        dto.setBookCategory(CategoryDtoMapper.toDto(book.getBookCategory()));
        dto.setBookEdition(EditionDtoMapper.toDto(book.getBookEdition()));
        return dto;
    }

    static public Book toEntity(BookDto bookDto) {

        Book entity = new Book();
        entity.setBookId(bookDto.getBookId());
        entity.setTitle(bookDto.getTitle());
        entity.setQuantity(bookDto.getQuantity());
        entity.setRenewalLoan(bookDto.getRenewalLoan());
        entity.setQuantityLoan(bookDto.getQuantityLoan());
        entity.setYearBook(bookDto.getYearBook());
        entity.setBookAuthor(AuthorDtoMapper.toEntity(bookDto.getBookAuthor()));
        entity.setBookCategory(CategoryDtoMapper.toEntity(bookDto.getBookCategory()));
        entity.setBookEdition(EditionDtoMapper.toEntity(bookDto.getBookEdition()));
        return entity;
    }
}