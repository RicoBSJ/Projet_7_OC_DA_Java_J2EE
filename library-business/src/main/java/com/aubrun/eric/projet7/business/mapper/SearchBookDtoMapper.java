package com.aubrun.eric.projet7.business.mapper;

import com.aubrun.eric.projet7.beans.SearchBook;
import com.aubrun.eric.projet7.business.dto.SearchBookDto;

public class SearchBookDtoMapper {

    static public SearchBookDto toDto(SearchBook searchBook) {

        SearchBookDto dto = new SearchBookDto();
        dto.setSearchDtoId(searchBook.getSearchDtoId());
        dto.setTitleSearchDto(searchBook.getTitleSearchDto());
        dto.setNameAuthor(searchBook.getNameAuthor());
        dto.setPublishingHouse(searchBook.getPublishingHouse());
        dto.setReleaseDate(searchBook.getReleaseDate());
        return dto;
    }

    static public SearchBook toEntity(SearchBookDto searchBookDto) {

        SearchBook entity = new SearchBook();
        entity.setSearchDtoId(searchBookDto.getSearchDtoId());
        entity.setTitleSearchDto(searchBookDto.getTitleSearchDto());
        entity.setNameAuthor(searchBookDto.getNameAuthor());
        entity.setPublishingHouse(searchBookDto.getPublishingHouse());
        entity.setReleaseDate(searchBookDto.getReleaseDate());
        return entity;
    }
}
