package com.aubrun.eric.projet7.controllers;

import com.aubrun.eric.projet7.business.dto.BookDto;
import com.aubrun.eric.projet7.business.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/allBooks")
    public List<BookDto> getAllBooks(){
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable(value = "id") int bookId){
        return bookService.findById(bookId);
    }

    @PostMapping("/create")
    public void createBook(@RequestBody BookDto bookDto){
        bookService.saveOrUpdate(bookDto);
    }

    @PutMapping("/update/{id}")
    public void updateBook(@RequestBody BookDto bookDto, @PathVariable("id") int bookId){
        BookDto existingBook = bookService.findById(bookId);
        existingBook.setAuthor(bookDto.getAuthor());
        existingBook.setTitle(bookDto.getTitle());
        existingBook.setQuantity(bookDto.getQuantity());
        existingBook.setQuantityLoan(bookDto.getQuantityLoan());
        existingBook.setRenewalLoan(bookDto.getRenewalLoan());
        existingBook.setYear(bookDto.getYear());
        existingBook.setCategory(bookDto.getCategory());
        bookService.saveOrUpdate(existingBook);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable("id") int bookId){
        BookDto existingBook = bookService.findById(bookId);
        bookService.delete(existingBook.getId());
    }
}
