package com.aubrun.eric.projet7.controllers;

import com.aubrun.eric.projet7.beans.Author;
import com.aubrun.eric.projet7.business.dto.AuthorDto;
import com.aubrun.eric.projet7.business.service.AuthorService;
import com.aubrun.eric.projet7.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<AuthorDto> getAllAuthors(){
        return this.authorService.findAll();
    }

/*    @GetMapping("/{id}")
    public AuthorDto getAuthorById(@PathVariable(value = "id") int authorId){
        return this.authorService.findById(authorId)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id : "+authorId));
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author author){
        return this.authorService.save(author);
    }

    @PutMapping("/{id}")
    public Author updateAuthor(@RequestBody Author author, @PathVariable("id") int authorId){
        Author existingAuthor = this.authorRepository.findById(authorId)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id : "+authorId));
        existingAuthor.setFirstName(author.getFirstName());
        existingAuthor.setName(author.getName());
        existingAuthor.setBooks(author.getBooks());
        return this.authorRepository.save(existingAuthor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Author> deleteAuthor(@PathVariable("id") int authorId){
        Author existingAuthor = this.authorRepository.findById(authorId)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id : "+authorId));
        this.authorRepository.delete(existingAuthor);
        return ResponseEntity.ok().build();
    }*/
}
