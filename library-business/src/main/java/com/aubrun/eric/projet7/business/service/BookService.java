package com.aubrun.eric.projet7.business.service;

import com.aubrun.eric.projet7.beans.Book;
import com.aubrun.eric.projet7.business.dto.BookDto;
import com.aubrun.eric.projet7.business.mapper.BookDtoMapper;
import com.aubrun.eric.projet7.consumer.dao.BookDao;

import java.util.List;

public class BookService {

    private BookDao bookDao = new BookDao();

    public List<Book> findAll() {

        List<Book> book = bookDao.recupererBooks();
        for ( Book u : book ) {
            BookDto bookDto = BookDtoMapper.toDto( u );
            dto.add( bookDto );
        }
        return dto;
    }

    public Book findById( Integer id ) {

        return bookDao.afficherParId( id );
    }

    public Book deleteBook( Integer id ) {

        return bookDao.supprimerLivre( id );
    }

    public void registeredBook( Book registerBook ) {

        bookDao.ajouterLivre( registerBook );
    }
}