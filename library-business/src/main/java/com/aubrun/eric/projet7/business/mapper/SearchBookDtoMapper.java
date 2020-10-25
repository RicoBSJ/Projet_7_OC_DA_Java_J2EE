package com.aubrun.eric.projet7.business.mapper;

import com.aubrun.eric.projet7.beans.Book;
import com.aubrun.eric.projet7.business.dto.SearchBookDto;

public class SearchBookDtoMapper {

    static public SearchBookDto toDto(Book book) {

        SearchBookDto dto = new SearchBookDto();
        dto.setSearchBookId(book.getBookId());
        dto.setSearchBookTitle(book.getTitle());
        dto.setSearchBookAuthorFirstName(String.valueOf(book.getBookAuthor().getFirstName()));
        dto.setSearchBookAuthorLastName(String.valueOf(book.getBookAuthor().getNameAuthor()));
        dto.setSearchBookPublishingHouse(String.valueOf(book.getBookEdition()));
        dto.setSearchBookReleaseDate(String.valueOf(book.getYearBook()));
        return dto;
    }

    static public Book toEntity(SearchBookDto searchBookDto) {

        Book entity = new Book();
        entity.setBookId(searchBookDto.getSearchBookId());
        entity.setTitle(searchBookDto.getSearchBookTitle());
        entity.setSearchBookAuthorFirstName(searchBookDto.getSearchBookAuthorFirstName());
        entity.setSearchBookAuthorLastName(searchBookDto.getSearchBookAuthorLastName());
        entity.setSearchBookPublishingHouse(searchBookDto.getSearchBookPublishingHouse());
        entity.setSearchBookReleaseDate(searchBookDto.getSearchBookReleaseDate());
        return entity;
    }
}
