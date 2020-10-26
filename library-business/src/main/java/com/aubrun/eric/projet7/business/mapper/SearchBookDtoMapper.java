package com.aubrun.eric.projet7.business.mapper;

import com.aubrun.eric.projet7.beans.SearchBook;
import com.aubrun.eric.projet7.business.dto.SearchBookDto;

public class SearchBookDtoMapper {

    static public SearchBookDto toDto(SearchBook searchBook) {

        SearchBookDto dto = new SearchBookDto();
        dto.setSearchBookId(searchBook.getSearchBookId());
        dto.setSearchBookTitle(searchBook.getSearchBookTitle());
        dto.setSearchBookAuthorFirstName(searchBook.getSearchBookAuthorFirstName());
        dto.setSearchBookAuthorLastName(searchBook.getSearchBookAuthorLastName());
        dto.setSearchBookPublishingHouse(searchBook.getSearchBookPublishingHouse());
        dto.setSearchBookReleaseDate(searchBook.getSearchBookReleaseDate());
        return dto;
    }

    static public SearchBook toEntity(SearchBookDto searchBookDto) {

        SearchBook entity = new SearchBook();
        entity.setSearchBookId(searchBookDto.getSearchBookId());
        entity.setSearchBookTitle(searchBookDto.getSearchBookTitle());
        entity.setSearchBookAuthorFirstName(searchBookDto.getSearchBookAuthorFirstName());
        entity.setSearchBookAuthorLastName(searchBookDto.getSearchBookAuthorLastName());
        entity.setSearchBookPublishingHouse(searchBookDto.getSearchBookPublishingHouse());
        entity.setSearchBookReleaseDate(searchBookDto.getSearchBookReleaseDate());
        return entity;
    }
}
