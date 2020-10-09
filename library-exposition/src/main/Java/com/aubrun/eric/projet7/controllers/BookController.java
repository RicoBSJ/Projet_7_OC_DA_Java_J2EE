package com.aubrun.eric.projet7.controllers;

import com.aubrun.eric.projet7.business.dto.BookDto;
import com.aubrun.eric.projet7.business.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
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
        existingBook.setBookId(bookDto.getBookId());
        existingBook.setTitle(bookDto.getTitle());
        existingBook.setQuantity(bookDto.getQuantity());
        existingBook.setQuantityLoan(bookDto.getQuantityLoan());
        existingBook.setRenewalLoan(bookDto.getRenewalLoan());
        existingBook.setYearBook(bookDto.getYearBook());
        existingBook.setBookAuthor(bookDto.getBookAuthor());
        existingBook.setBookCategory(bookDto.getBookCategory());
        bookService.saveOrUpdate(existingBook);
    }

    /*@GetMapping("/test/{name}")
    public List<BookDto> testSearch(@PathVariable("name") String name){

        return bookService.findBooksByName(name);
    }*/

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") int bookId){
        BookDto existingBook = bookService.findById(bookId);
        bookService.delete(existingBook.getBookId());
    }

}