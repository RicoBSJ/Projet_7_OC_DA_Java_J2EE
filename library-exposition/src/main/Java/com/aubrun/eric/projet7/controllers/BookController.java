package com.aubrun.eric.projet7.controllers;

import com.aubrun.eric.projet7.beans.Book;
import com.aubrun.eric.projet7.beans.SearchBook;
import com.aubrun.eric.projet7.business.dto.BookDto;
import com.aubrun.eric.projet7.business.dto.SearchBookDto;
import com.aubrun.eric.projet7.business.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public List<BookDto> getAllBooks(){
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable(value = "id") int bookId){
        return bookService.findById(bookId);
    }

    @PostMapping("/")
    public void createBook(@RequestBody BookDto bookDto){
        bookService.saveOrUpdate(bookDto);
    }

    @PutMapping("/{id}")
    public void updateBook(@RequestBody BookDto bookDto, @PathVariable("id") int bookId){
        BookDto existingBook = bookService.findById(bookId);
        existingBook.setAuthorDto(bookDto.getAuthorDto());
        existingBook.setTitle(bookDto.getTitle());
        existingBook.setQuantity(bookDto.getQuantity());
        existingBook.setQuantityLoan(bookDto.getQuantityLoan());
        existingBook.setRenewalLoan(bookDto.getRenewalLoan());
        existingBook.setYear(bookDto.getYear());
        existingBook.setCategoryDto(bookDto.getCategoryDto());
        bookService.saveOrUpdate(existingBook);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") int bookId){
        BookDto existingBook = bookService.findById(bookId);
        bookService.delete(existingBook.getId());
    }

    @GetMapping("/search")
    public List<BookDto> searchBook(SearchBookDto searchBookDto){

        searchBookDto.setAuthor(searchBookDto.getAuthor());
        searchBookDto.setTitle(searchBookDto.getTitle());
        searchBookDto.setCategory(searchBookDto.getCategory());
        searchBookDto.setQuantity(searchBookDto.getQuantity());
        searchBookDto.setQuantityLoan(searchBookDto.getQuantityLoan());
        searchBookDto.setRenewalLoan(searchBookDto.getRenewalLoan());
        searchBookDto.setYear(searchBookDto.getYear());

        /*List<BookDto> books = bookService.searchBook(searchBookDto);

        return books;*/

        return null;
    }
}