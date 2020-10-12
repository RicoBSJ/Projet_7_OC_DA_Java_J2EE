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
    public List<AuthorDto> getAllAuthors(){
        return this.authorService.findAll();
    }

    @GetMapping("/{id}")
    public AuthorDto getAuthorById(@PathVariable(value = "id") int authorId){
        return this.authorService.findById(authorId);
    }

    @PostMapping("/")
    public void createAuthor(@RequestBody AuthorDto authorDto){
        authorService.saveOrUpdate(authorDto);
    }

    @PutMapping("/{id}")
    public void updateAuthor(@RequestBody AuthorDto authorDto, @PathVariable("id") int authorId){
        AuthorDto existingAuthor = authorService.findById(authorId);
        existingAuthor.setAuthorId(authorDto.getAuthorId());
        existingAuthor.setFirstName(authorDto.getFirstName());
        existingAuthor.setNameAuthor(authorDto.getNameAuthor());
        authorService.saveOrUpdate(existingAuthor);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable("id") int id){
        AuthorDto existingAuthor = authorService.findById(id);
        authorService.delete(existingAuthor.getAuthorId());
    }
}