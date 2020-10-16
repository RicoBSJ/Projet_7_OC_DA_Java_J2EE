package com.aubrun.eric.projet7.business.service;

import com.aubrun.eric.projet7.business.dto.BookDto;
import com.aubrun.eric.projet7.business.mapper.BookDtoMapper;
import com.aubrun.eric.projet7.consumer.repository.AuthorRepository;
import com.aubrun.eric.projet7.consumer.repository.BookRepository;
import com.aubrun.eric.projet7.consumer.repository.CategoryRepository;
import com.aubrun.eric.projet7.consumer.repository.LoanRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final LoanRepository loanRepository;
    private final CategoryRepository categoryRepository;

    public BookService(BookRepository bookRepository, AuthorService authorService, AuthorRepository authorRepository, LoanRepository loanRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.loanRepository = loanRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<BookDto> findAll() {

        return bookRepository.findAll().stream().map(BookDtoMapper::toDto).collect(Collectors.toList());
    }

    public void save(BookDto newBook) {

        BookDtoMapper.toDto(bookRepository.saveAndFlush(BookDtoMapper.toEntity(newBook)));
    }

    public void update(BookDto newBook) {

        BookDtoMapper.toDto(bookRepository.save(BookDtoMapper.toEntity(newBook)));
    }

    public BookDto findById(Integer id) {

        return BookDtoMapper.toDto(bookRepository.findById(id).get());
    }

    public void delete(int id) {

        categoryRepository.deleteById(id);
        loanRepository.deleteById(id);
        authorRepository.deleteById(id);
        bookRepository.deleteById(id);

    }

    public List<BookDto> findBooksByName(String name){

        return bookRepository.findBooksByTitleContains(name).stream().map(BookDtoMapper::toDto).collect(Collectors.toList());
    }
}