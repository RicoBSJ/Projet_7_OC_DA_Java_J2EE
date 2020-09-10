package com.aubrun.eric.projet7.business.service;

import com.aubrun.eric.projet7.beans.Author;
import com.aubrun.eric.projet7.beans.Book;
import com.aubrun.eric.projet7.business.dto.AuthorDto;
import com.aubrun.eric.projet7.business.mapper.AuthorDtoMapper;
import com.aubrun.eric.projet7.consumer.dao.AuthorDao;

import java.util.ArrayList;
import java.util.List;

public class AuthorService {

    private AuthorDao authorDao = new AuthorDao();

    public List<AuthorDto> findAll() {

        List<Author> author = authorDao.recupererAuteurs();
        List<AuthorDto> dto = new ArrayList<AuthorDto>();

        for (Author b : author) {
            AuthorDto authorDto = AuthorDtoMapper.toDto(b);
            dto.add(authorDto);
        }
        return dto;
    }

    public void addAuthor( Author newAuthor ) {

        authorDao.ajouterAuteur( newAuthor );
    }

    public Author findById( Integer id ) {

        return authorDao.afficherParId( id );
    }

    public Author deleteAuthor( Integer id ) {

        return authorDao.supprimerAuteur( id );
    }

    public void registeredAuthor( Author registerAuthor ) {

        authorDao.ajouterAuteur( registerAuthor );
    }
}
