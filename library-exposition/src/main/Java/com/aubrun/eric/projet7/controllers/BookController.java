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
    private final LoanService loanService;

    public BookController(BookService bookService, LoanService loanService) {
        this.bookService = bookService;
        this.loanService = loanService;
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

    /*@PostMapping("/")
    public void createBook(@RequestBody BookDto bookDto){
        BookDto newBook = new BookDto();
        newBook.setBookId(bookDto.getBookId());
        newBook.setTitle(bookDto.getTitle());
        newBook.setQuantity(bookDto.getQuantity());
        newBook.setQuantityLoan(bookDto.getQuantityLoan());
        newBook.setRenewalLoan(bookDto.getRenewalLoan());
        newBook.setYearBook(bookDto.getYearBook());
        newBook.setBookAuthor(bookDto.getBookAuthor());
        newBook.setBookCategory(bookDto.getBookCategory());
        bookService.save(newBook);
    }*/

    //creating put mapping that updates the book detail
    @PutMapping("/books")
    private BookDto updateBook(@RequestBody BookDto bookDto) {
        bookService.update(bookDto);
        return bookDto;
    }

    /*@PutMapping("/{id}")
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
        bookService.update(existingBook);
    }*/

    //creating a delete mapping that deletes a specified book
    @DeleteMapping("/{id}")
    private void deleteBook(@PathVariable("id") int bookId) {
        loanService.delete(bookId);
        bookService.delete(bookId);
    }

    /*@DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") int bookId){
        BookDto existingBook = bookService.findById(bookId);
        bookService.delete(existingBook.getBookId());
    }*/

    /*@GetMapping("/test/{name}")
    public List<BookDto> testSearch(@PathVariable("name") String name){

        return bookService.findBooksByName(name);
    }*/
}