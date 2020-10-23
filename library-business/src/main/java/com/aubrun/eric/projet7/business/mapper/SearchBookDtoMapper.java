package com.aubrun.eric.projet7.business.mapper;

import com.aubrun.eric.projet7.beans.Book;
import com.aubrun.eric.projet7.business.dto.SearchBookDto;

public class SearchBookDtoMapper {

    static public SearchBookDto toDto(Book book) {

        SearchBookDto dto = new SearchBookDto();
        dto.setSearchBookId(book.getBookId());
        dto.setSearchBookTitle(book.getTitle());
        dto.setSearchBookAuthor(String.valueOf(book.getBookAuthor()));
        dto.setSearchBookPublishingHouse(String.valueOf(book.getBookEdition()));
        dto.setSearchBookReleaseDate(String.valueOf(book.getYearBook()));
        return dto;
    }

    static public Book toEntity(SearchBookDto searchBookDto) {

        Book entity = new Book();
        entity.setBookId(searchBookDto.getSearchBookId());
        entity.setTitle(searchBookDto.getSearchBookTitle());
        entity.setSearchBookAuthor(searchBookDto.getSearchBookAuthor());
        entity.setSearchBookEdition(searchBookDto.getSearchBookPublishingHouse());
        entity.setSearchBookDate(searchBookDto.getSearchBookReleaseDate());
        return entity;
    }
}
