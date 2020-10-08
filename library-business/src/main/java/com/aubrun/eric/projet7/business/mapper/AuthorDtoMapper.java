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
        dto.setAuthorBooks(author.getAuthorBooks().stream().map(BookDtoMapper::toDto).collect(Collectors.toList()));
        return dto;
    }

    static public Author toEntity(AuthorDto authorDto) {

        Author entity = new Author();
        entity.setAuthorId(authorDto.getAuthorId());
        entity.setFirstName(authorDto.getFirstName());
        entity.setNameAuthor(authorDto.getNameAuthor());
        entity.setAuthorBooks(authorDto.getAuthorBooks().stream().map(BookDtoMapper::toEntity).collect(Collectors.toList()));
        return entity;
    }
}
