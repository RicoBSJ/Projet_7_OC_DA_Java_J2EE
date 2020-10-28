package com.aubrun.eric.projet7.business.service;

import com.aubrun.eric.projet7.beans.Book;
import com.aubrun.eric.projet7.beans.SearchBook;
import com.aubrun.eric.projet7.business.dto.BookDto;
import com.aubrun.eric.projet7.business.mapper.BookDtoMapper;
import com.aubrun.eric.projet7.consumer.repository.BookRepository;
import com.aubrun.eric.projet7.consumer.repository.SearchRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookService {

    private final BookRepository bookRepository;
    private final SearchRepository searchRepository;

    public BookService(BookRepository bookRepository, SearchRepository searchRepository) {
        this.bookRepository = bookRepository;
        this.searchRepository = searchRepository;
    }

    public List<BookDto> findAll() {

        return bookRepository.findAll().stream().map(BookDtoMapper::toDto).collect(Collectors.toList());
    }

    public int save(BookDto newBook) {

        return bookRepository.save(BookDtoMapper.toEntity(newBook)).getBookId();
    }

    public BookDto update(BookDto newBook) {

        return BookDtoMapper.toDto(bookRepository.save(BookDtoMapper.toEntity(newBook)));
    }

    public BookDto findById(Integer id) {

        return BookDtoMapper.toDto(bookRepository.findById(id).get());
    }

    public void delete(int id) {

        bookRepository.deleteById(id);
    }

    public List<BookDto> searchBook(SearchBook searchBook) {

        return searchRepository.findAllByTitleAndBookAuthorAndBookEdition(searchBook).stream().map(BookDtoMapper::toDto).collect(Collectors.toList());
    }
}