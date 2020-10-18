package com.aubrun.eric.projet7.business.service;

import com.aubrun.eric.projet7.beans.Author;
import com.aubrun.eric.projet7.business.dto.AuthorDto;
import com.aubrun.eric.projet7.business.mapper.AuthorDtoMapper;
import com.aubrun.eric.projet7.consumer.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

        return authorRepository.findAll().stream().map(AuthorDtoMapper::toDto).collect(Collectors.toList());
    }

    public int save(AuthorDto newAuthor) {

        return authorRepository.save(AuthorDtoMapper.toEntity(newAuthor)).getAuthorId();
    }

    public AuthorDto update(AuthorDto newAuthor) {

        return AuthorDtoMapper.toDto(authorRepository.save(AuthorDtoMapper.toEntity(newAuthor)));
    }

    public AuthorDto findById(Integer id) {

        return AuthorDtoMapper.toDto(authorRepository.findById(id).get());
    }

    public void delete(int id) {

        authorRepository.deleteById(id);

    }
}
