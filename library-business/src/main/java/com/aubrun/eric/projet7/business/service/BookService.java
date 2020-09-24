package com.aubrun.eric.projet7.business.service;

import com.aubrun.eric.projet7.business.dto.BookDto;
import com.aubrun.eric.projet7.business.mapper.BookDtoMapper;
import com.aubrun.eric.projet7.consumer.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDto> findAll() {

        return bookRepository.findAll().stream().map(BookDtoMapper::toDto).collect(Collectors.toList());
    }

    public void saveOrUpdate(BookDto newBook) {

        BookDtoMapper.toDto(bookRepository.save(BookDtoMapper.toEntity(newBook)));
    }

    public BookDto findById(Integer id) {

        return BookDtoMapper.toDto(bookRepository.findById(id).get());
    }

    public void delete(Integer id) {

        BookDto bookDto = BookDtoMapper.toDto(bookRepository.findById(id).get());
        bookRepository.delete(BookDtoMapper.toEntity(bookDto));
    }
}