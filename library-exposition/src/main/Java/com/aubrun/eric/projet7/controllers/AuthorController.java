package com.aubrun.eric.projet7.controllers;

import com.aubrun.eric.projet7.business.dto.AuthorDto;
import com.aubrun.eric.projet7.business.dto.BookDto;
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

    //creating post mapping that post the author detail in the database
    @PostMapping("/")
    private int createAuthor(@RequestBody AuthorDto authorDto) {
        authorService.save(authorDto);
        return authorDto.getAuthorId();
    }

    /*@PostMapping("/")
    public void createAuthor(@RequestBody AuthorDto authorDto) {
        AuthorDto newAuthor = new AuthorDto();
        newAuthor.setAuthorId(authorDto.getAuthorId());
        newAuthor.setFirstName(authorDto.getFirstName());
        newAuthor.setNameAuthor(authorDto.getNameAuthor());
        authorService.save(newAuthor);
    }*/

    //creating put mapping that updates the author detail
    @PutMapping("/{id}")
    private AuthorDto updateAuthor(@RequestBody AuthorDto authorDto, @PathVariable("id") int authorId) {
        authorService.update(authorDto);
        return authorDto;
    }

    /*@PutMapping("/{id}")
    public void updateAuthor(@RequestBody AuthorDto authorDto, @PathVariable("id") int authorId) {
        AuthorDto existingAuthor = authorService.findById(authorId);
        existingAuthor.setAuthorId(authorDto.getAuthorId());
        existingAuthor.setFirstName(authorDto.getFirstName());
        existingAuthor.setNameAuthor(authorDto.getNameAuthor());
        authorService.update(existingAuthor);
    }*/

    //creating a delete mapping that deletes a specified book
    @DeleteMapping("/{id}")
    private void deleteAuthor(@PathVariable("id") int id) {
        authorService.delete(id);
    }

    /*@DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable("id") int id) {
        AuthorDto existingAuthor = authorService.findById(id);
        authorService.delete(existingAuthor.getAuthorId());
    }*/
}