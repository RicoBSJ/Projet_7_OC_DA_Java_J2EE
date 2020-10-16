package com.aubrun.eric.projet7.controllers;

import com.aubrun.eric.projet7.business.dto.AuthorDto;
import com.aubrun.eric.projet7.business.service.AuthorService;
import com.aubrun.eric.projet7.business.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
    }

    @GetMapping("/")
    public List<AuthorDto> getAllAuthors() {
        return this.authorService.findAll();
    }

    @GetMapping("/{id}")
    public AuthorDto getAuthorById(@PathVariable(value = "id") int authorId) {
        return this.authorService.findById(authorId);
    }

    @PostMapping("/")
    private int createAuthor(@RequestBody AuthorDto authorDto) {
        authorService.save(authorDto);
        return authorDto.getAuthorId();
    }

    @PutMapping("/author")
    private AuthorDto updateAuthor(@RequestBody AuthorDto authorDto) {
        authorService.update(authorDto);
        return authorDto;
    }

    @DeleteMapping("/{id}")
    private void deleteAuthor(@PathVariable("id") int id) {
        authorService.delete(id);
    }
}