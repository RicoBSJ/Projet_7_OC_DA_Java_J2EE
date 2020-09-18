package com.aubrun.eric.projet7.business.service;

import com.aubrun.eric.projet7.beans.Book;
import com.aubrun.eric.projet7.business.dto.BookDto;
import com.aubrun.eric.projet7.consumer.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDto> findAll() {

        return null;
    }

    public void addBook(Book newBook) {

    }

    public Book findById(Integer id) {

        return null;
    }

    public Book deleteBook(Integer id) {

        return null;
    }
}