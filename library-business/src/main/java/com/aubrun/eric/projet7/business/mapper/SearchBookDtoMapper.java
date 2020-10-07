package com.aubrun.eric.projet7.business.mapper;

import com.aubrun.eric.projet7.beans.SearchBook;
import com.aubrun.eric.projet7.business.dto.SearchBookDto;

public class SearchBookDtoMapper {

    static public SearchBookDto toDto(SearchBook searchBook){

        SearchBookDto dto = new SearchBookDto();
        dto.setAuthor(searchBook.getAuthor());
        dto.setCategory(searchBook.getCategory());
        dto.setQuantity(searchBook.getQuantity());
        dto.setQuantityLoan(searchBook.getQuantityLoan());
        dto.setRenewalLoan(searchBook.getRenewalLoan());
        dto.setTitle(searchBook.getTitle());
        dto.setYear(searchBook.getYear());
        return dto;
}

    static public SearchBook toEntity(SearchBookDto searchBookDto) {

        SearchBook entity = new SearchBook();
        entity.setAuthor(searchBookDto.getAuthor());
        entity.setCategory(searchBookDto.getCategory());
        entity.setQuantity(searchBookDto.getQuantity());
        entity.setQuantityLoan(searchBookDto.getQuantityLoan());
        entity.setRenewalLoan(searchBookDto.getRenewalLoan());
        entity.setTitle(searchBookDto.getTitle());
        entity.setYear(searchBookDto.getYear());
        return entity;
    }
}
