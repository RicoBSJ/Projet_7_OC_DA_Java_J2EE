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
    private final BookService bookService;

    public AuthorController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @GetMapping("/")
    public List<AuthorDto> getAllAuthors() {
        return this.authorService.findAll();
    }

    @GetMapping("/{id}")
    public AuthorDto getAuthorById(@PathVariable(value = "id") int authorId) {
        return this.authorService.findById(authorId);
    }

    //creating post mapping that post the author detail in the database
    @PostMapping("/")
    private int createAuthor(@RequestBody AuthorDto authorDto) {
        authorService.save(authorDto);
        return authorDto.getAuthorId();
    }

    @PutMapping("/{id}")
    private AuthorDto updateAuthor(@RequestBody AuthorDto authorDto, @PathVariable("id") int authorId) {
        authorService.update(authorDto);
        return authorDto;
    }

    @DeleteMapping("/{id}")
    private void deleteAuthor(@PathVariable("id") int id) {
        authorService.delete(id);
    }
}