package com.aubrun.eric.projet7.business.mapper;

import com.aubrun.eric.projet7.beans.Author;
import com.aubrun.eric.projet7.beans.Book;
import com.aubrun.eric.projet7.business.dto.AuthorDto;
import com.aubrun.eric.projet7.business.dto.BookDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AuthorDtoMapper {

    static public AuthorDto toDto(Author author) {

        AuthorDto dto = new AuthorDto();
        dto.setId(author.getId());
        dto.setFirstName(author.getFirstName());
        dto.setName(author.getName());
        List<BookDto> list = new ArrayList<>();
        for (Book book : author.getBooks()) {
            BookDto bookDto = BookDtoMapper.toDto(book);
            list.add(bookDto);
        }
        dto.setBookDtos(list);
        /*dto.setBookDtos(author.getBooks().stream().map(BookDtoMapper::toDto).collect(Collectors.toList()));*/
        return dto;
    }

    static public Author toEntity(AuthorDto authorDto) {

        Author entity = new Author();
        entity.setId(authorDto.getId());
        entity.setFirstName(authorDto.getFirstName());
        entity.setName(authorDto.getName());
        List<Book> list = new ArrayList<>();
        for (BookDto bookDto : authorDto.getBookDtos()) {
            Book book = BookDtoMapper.toEntity(bookDto);
            list.add(book);
        }
        entity.setBooks(list);
        /*entity.setBooks(authorDto.getBookDtos().stream().map(BookDtoMapper::toEntity).collect(Collectors.toList()));*/
        return entity;
    }
}
