package com.aubrun.eric.projet7.business.service;

import com.aubrun.eric.projet7.beans.Author;
import com.aubrun.eric.projet7.business.dto.AuthorDto;
import com.aubrun.eric.projet7.business.mapper.AuthorDtoMapper;
import com.aubrun.eric.projet7.consumer.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<AuthorDto> findAll() {

        /*List<AuthorDto> dtos = new ArrayList<>();
        for(Author a : authors){
            AuthorDto dto = AuthorDtoMapper.toDto(a);
            dtos.add(dto);
        }
        return dtos;*/

        return authorRepository.findAll().stream().map(AuthorDtoMapper::toDto).collect(Collectors.toList());
    }

    public void addAuthor(Author newAuthor) {

    }

    public Author findById(Integer id) {

        return null;
    }

    public Author deleteAuthor(Integer id) {

        return null;
    }
}
