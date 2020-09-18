package com.aubrun.eric.projet7.business.service;

import com.aubrun.eric.projet7.beans.Book;
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

    public void addBook(Book newBook) {

        bookRepository.save(newBook);
    }

    public Book findById(Integer id) {

        return bookRepository.findById(id).get();
    }

    public void deleteBook(Integer id) {

        bookRepository.deleteById(id);
    }
}