package com.aubrun.eric.projet7.business.mapper;

import com.aubrun.eric.projet7.beans.Author;
import com.aubrun.eric.projet7.business.dto.AuthorDto;

import java.util.function.Function;
import java.util.stream.Collectors;

public class AuthorDtoMapper {

    static public AuthorDto toDto(Author author) {

        AuthorDto dto = new AuthorDto();
        dto.setId(author.getId());
        dto.setFirstName(author.getFirstName());
        dto.setName(author.getName());
        dto.setBooks(author.getBooks().stream().map(BookDtoMapper::toDto).collect(Collectors.toList()));
        /*Map<Long, Employee> employeesMap = employeeList.stream().collect( Collectors.toMap(Employee::getId,Function.identity()) );*/
        return dto;
    }

    static public Author toEntity(AuthorDto authorDto) {

        Author entity = new Author();
        entity.setId(authorDto.getId());
        entity.setFirstName(authorDto.getFirstName());
        entity.setName(authorDto.getName());
        /*entity.setBooks(authorDto.getBooks().stream().map(BookDtoMapper::toEntity).collect(Collectors.toList()));*/
        return entity;
    }
}
