package com.aubrun.eric.projet7.controllers;

import com.aubrun.eric.projet7.business.dto.BookDto;
import com.aubrun.eric.projet7.business.service.BookService;
import com.aubrun.eric.projet7.business.service.LoanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService, LoanService loanService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public List<BookDto> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable(value = "id") int bookId) {
        return bookService.findById(bookId);
    }

    //creating post mapping that post the book detail in the database
    @PostMapping("/")
    private int createBook(@RequestBody BookDto bookDto) {
        bookService.save(bookDto);
        return bookDto.getBookId();
    }

    @PutMapping("/books")
    private BookDto updateBook(@RequestBody BookDto bookDto) {
        bookService.update(bookDto);
        return bookDto;
    }

    @DeleteMapping("/{id}")
    private void deleteBook(@PathVariable("id") int bookId) {
        bookService.delete(bookId);
    }

    /*@GetMapping("/test/{name}")
    public List<BookDto> testSearch(@PathVariable("name") String name){

        return bookService.findBooksByName(name);
    }*/
}