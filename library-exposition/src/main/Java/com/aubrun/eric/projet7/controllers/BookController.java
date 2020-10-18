package com.aubrun.eric.projet7.controllers;

import com.aubrun.eric.projet7.beans.Book;
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
    public List<BookDto> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable(value = "id") int bookId) {
        return bookService.findById(bookId);
    }

    @PostMapping("/")
    private void createBook(@RequestBody BookDto bookDto) {
        bookService.save(bookDto);
    }

    @PutMapping("/book")
    private void updateBook(@RequestBody BookDto bookDto) {
        bookService.update(bookDto);
    }

    @DeleteMapping("/{id}")
    private void deleteBook(@PathVariable("id") int bookId) {
        bookService.delete(bookId);
    }

    /*@GetMapping("/test/{name}")
    public List<BookDto> testSearch(@PathVariable("name") String name) {
        return bookService.findBooksByName(name);
    }*/

    /*@PostMapping("/searchBook")
    private void List<BookDto> recherche(SearchBookDto searchBookDto ) {
        bookService.searchBook();
    }*/
}