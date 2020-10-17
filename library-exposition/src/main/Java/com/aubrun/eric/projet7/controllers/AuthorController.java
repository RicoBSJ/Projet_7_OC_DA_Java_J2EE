package com.aubrun.eric.projet7.controllers;

import com.aubrun.eric.projet7.business.dto.AuthorDto;
import com.aubrun.eric.projet7.business.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
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
    private void createAuthor(@RequestBody AuthorDto authorDto) {
        authorService.save(authorDto);
    }

    @PutMapping("/author")
    private void updateAuthor(@RequestBody AuthorDto authorDto) {
        authorService.update(authorDto);
    }

    @DeleteMapping("/{id}")
    private void deleteAuthor(@PathVariable("id") int id) {
        authorService.delete(id);
    }
}