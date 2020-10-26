package com.aubrun.eric.projet7.business.mapper;

import com.aubrun.eric.projet7.beans.Book;
import com.aubrun.eric.projet7.business.dto.SearchBookDto;

public class SearchBookDtoBookMapper {

    static public SearchBookDto toDto(Book book) {

        SearchBookDto dto = new SearchBookDto();
        dto.setSearchBookId(book.getBookId());
        dto.setSearchBookTitle(book.getTitle());
        dto.setSearchBookAuthorFirstName(book.getBookAuthor().getFirstName());
        dto.setSearchBookAuthorLastName(book.getBookAuthor().getLastName());
        dto.setSearchBookPublishingHouse(String.valueOf(book.getBookEdition()));
        dto.setSearchBookReleaseDate(String.valueOf(book.getYearBook()));
        return dto;
    }

    static public Book toEntity(SearchBookDto searchBookDto) {

        Book entity = new Book();
        entity.setBookId(searchBookDto.getSearchBookId());
        entity.setTitle(searchBookDto.getSearchBookTitle());
        entity.setBookAuthorFirstName(searchBookDto.getSearchBookAuthorFirstName());
        entity.setBookAuthorLastName(searchBookDto.getSearchBookAuthorLastName());
        entity.setBookEdition(searchBookDto.getSearchBookPublishingHouse());
        entity.setBookDate(searchBookDto.getSearchBookReleaseDate());
        return entity;
    }
}
