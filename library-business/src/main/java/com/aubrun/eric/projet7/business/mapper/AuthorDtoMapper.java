package com.aubrun.eric.projet7.business.mapper;

import com.aubrun.eric.projet7.beans.Author;
import com.aubrun.eric.projet7.business.dto.AuthorDto;

public class AuthorDtoMapper {

    static public AuthorDto toDto(Author author) {

        AuthorDto dto = new AuthorDto();
        dto.setAuthorId(author.getAuthorId());
        dto.setFirstName(author.getFirstName());
        dto.setLastName(author.getLastName());
        return dto;
    }

    static public Author toEntity(AuthorDto authorDto) {

        Author entity = new Author();
        entity.setAuthorId(authorDto.getAuthorId());
        entity.setFirstName(authorDto.getFirstName());
        entity.setLastName(authorDto.getLastName());
        return entity;
    }
}
