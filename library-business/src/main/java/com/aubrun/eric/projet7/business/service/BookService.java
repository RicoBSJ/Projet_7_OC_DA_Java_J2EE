package com.aubrun.eric.projet7.business.service;

import com.aubrun.eric.projet7.beans.Book;
import com.aubrun.eric.projet7.business.dto.BookDto;
import com.aubrun.eric.projet7.business.mapper.BookDtoMapper;
import com.aubrun.eric.projet7.consumer.dao.BookDao;

import java.util.ArrayList;
import java.util.List;

public class BookService {

    private BookDao bookDao = new BookDao();

    public List<BookDto> findAll() {

        List<Book> book = bookDao.recupererLivres();
        List<BookDto> dto = new ArrayList<BookDto>();

        for (Book b : book) {
            BookDto bookDto = BookDtoMapper.toDto(b);
            dto.add(bookDto);
        }
        return dto;
    }

    public void addBook( Book newBook ) {

        bookDao.ajouterLivre( newBook );
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