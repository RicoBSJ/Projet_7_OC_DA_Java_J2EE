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

    @GetMapping("/book")
    public List<AuthorDto> getAllAuthors(){
        return this.authorService.findAll();
    }

    @GetMapping("/{id}")
    public AuthorDto getAuthorById(@PathVariable(value = "id") int authorId){
        return this.authorService.findById(authorId);
    }

    @PostMapping("/create")
    public void createAuthor(@RequestBody AuthorDto authorDto){
        authorService.saveOrUpdate(authorDto);
    }

    @PutMapping("/update/{id}")
    public AuthorDto updateAuthor(@RequestBody AuthorDto authorDto, @PathVariable("id") int authorId){
        AuthorDto existingAuthor = authorService.findById(authorId);
        existingAuthor.setFirstName(authorDto.getFirstName());
        existingAuthor.setName(authorDto.getName());
        existingAuthor.setBooks(authorDto.getBooks());
        return authorService.saveOrUpdate(existingAuthor);
    }

    @DeleteMapping("/delete/{id}")
    public AuthorDto deleteAuthor(@PathVariable("id") int authorId){
        AuthorDto existingAuthor = authorService.findById(authorId);
        return authorService.delete(existingAuthor);
    }
}
