package com.aubrun.eric.projet7.controllers;

import com.aubrun.eric.projet7.beans.Book;
import com.aubrun.eric.projet7.consumer.repository.BookRepository;
import com.aubrun.eric.projet7.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/api/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Book> getAllBooks(){
        return this.bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable(value = "id") int bookId){
        return this.bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book not found with id : "+bookId));
    }

    @PostMapping
    public Book createBook(@RequestBody Book book){
        return this.bookRepository.save(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable("id") int bookId){
        Book existingBook = this.bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id : "+bookId));
        existingBook.setAuthor(book.getAuthor());
        existingBook.setTitle(book.getTitle());
        existingBook.setCategory(book.getCategory());
        existingBook.setQuantity(book.getQuantity());
        existingBook.setQuantityLoan(book.getQuantityLoan());
        existingBook.setRenewalLoan(book.getRenewalLoan());
        existingBook.setYear(book.getYear());
        return this.bookRepository.save(existingBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable("id") int bookId){
        Book existingBook = this.bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id : "+bookId));
        this.bookRepository.delete(existingBook);
        return ResponseEntity.ok().build();
    }
}
