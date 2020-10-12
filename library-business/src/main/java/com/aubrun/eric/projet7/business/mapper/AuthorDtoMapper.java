package com.aubrun.eric.projet7.business.mapper;

import com.aubrun.eric.projet7.beans.Author;
import com.aubrun.eric.projet7.business.dto.AuthorDto;

import java.util.stream.Collectors;

public class AuthorDtoMapper {

    static public AuthorDto toDto(Author author) {

        AuthorDto dto = new AuthorDto();
        dto.setAuthorId(author.getAuthorId());
        dto.setFirstName(author.getFirstName());
        dto.setNameAuthor(author.getNameAuthor());
        return dto;
    }

    static public Author toEntity(AuthorDto authorDto) {

        Author entity = new Author();
        entity.setAuthorId(authorDto.getAuthorId());
        entity.setFirstName(authorDto.getFirstName());
        entity.setNameAuthor(authorDto.getNameAuthor());
        return entity;
    }
}
