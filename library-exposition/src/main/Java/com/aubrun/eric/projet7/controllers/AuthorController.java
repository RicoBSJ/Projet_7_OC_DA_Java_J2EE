package com.aubrun.eric.projet7.controllers;

import com.aubrun.eric.projet7.beans.Author;
import com.aubrun.eric.projet7.consumer.repository.AuthorRepository;
import com.aubrun.eric.projet7.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping
    public List<Author> getAllAuthors(){
        return this.authorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable(value = "id") int authorId){
        return this.authorRepository.findById(authorId)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id : "+authorId));
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author author){
        return this.authorRepository.save(author);
    }

    @PutMapping("/{id}")
    public Author updateAuthor(@RequestBody Author author, @PathVariable("id") int authorId){
        Author existingAuthor = this.authorRepository.findById(authorId)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id : "+authorId));
        existingAuthor.setFirstName(author.getFirstName());
        existingAuthor.setName(author.getName());
        existingAuthor.setBooks(author.getBooks());
        existingAuthor.setLoan(author.getLoan());
        return this.authorRepository.save(existingAuthor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Author> deleteAuthor(@PathVariable("id") int authorId){
        Author existingAuthor = this.authorRepository.findById(authorId)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id : "+authorId));
        this.authorRepository.delete(existingAuthor);
        return ResponseEntity.ok().build();
    }
}
