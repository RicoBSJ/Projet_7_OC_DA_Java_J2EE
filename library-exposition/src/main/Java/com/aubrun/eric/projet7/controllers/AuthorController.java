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

    @GetMapping("/allAuthors")
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
    public void updateAuthor(@RequestBody AuthorDto authorDto, @PathVariable("id") int authorId){
        AuthorDto existingAuthor = authorService.findById(authorId);
        existingAuthor.setFirstName(authorDto.getFirstName());
        existingAuthor.setName(authorDto.getName());
        existingAuthor.setBooks(authorDto.getBooks());
        authorService.saveOrUpdate(existingAuthor);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAuthor(@PathVariable("id") int authorId){
        AuthorDto existingAuthor = authorService.findById(authorId);
        authorService.delete(existingAuthor.getId());
    }
}
