package com.aubrun.eric.projet7.business.service;

import com.aubrun.eric.projet7.business.dto.BookDto;
import com.aubrun.eric.projet7.business.dto.SearchBookDto;
import com.aubrun.eric.projet7.business.mapper.BookDtoMapper;
import com.aubrun.eric.projet7.consumer.repository.BookRepository;
import org.hibernate.query.Query;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDto> findAll() {

        return bookRepository.findAll().stream().map(BookDtoMapper::toDto).collect(Collectors.toList());
    }

    public int save(BookDto newBook) {

        return bookRepository.save(BookDtoMapper.toEntity(newBook)).getBookId();
    }

    public BookDto update(BookDto newBook) {

        return BookDtoMapper.toDto(bookRepository.save(BookDtoMapper.toEntity(newBook)));
    }

    public BookDto findById(Integer id) {

        return BookDtoMapper.toDto(bookRepository.findById(id).get());
    }

    public void delete(int id) {

        bookRepository.deleteById(id);

    }

    /*public List<BookDto> findBooksByName(String name){

        return bookRepository.findBooksByTitleContains(name).stream().map(BookDtoMapper::toDto).collect(Collectors.toList());
    }*/

    /*public List<BookDto> searchBook(SearchBookDto searchBookDto) {
        Session session = factory.openSession();
        List<BookDto> resultat = null;

        try {
            Map<String, String> parameters = new HashMap();
            String q = "SELECT b FROM Book b WHERE 1=1 ";
            if ( searchBookDto.getTitleSearchDto() != "" ) {
                q += "AND b.titleSearchDto LIKE :titleSearchDto ";
                parameters.put( "titleSearchDto", "%" + searchBookDto.getTitleSearchDto() + "%" );
            }
            if ( searchBookDto.getNameAuthor() != "" ) {
                q += "AND b.nameAuthor LIKE :nameAuthor ";
                parameters.put( "nameAuthor", "%" + searchBookDto.getNameAuthor() + "%" );
            }
            if ( searchBookDto.getPublishingHouse() != "" ) {
                q += "AND b.publishingHouse LIKE :publishingHouse ";
                parameters.put( "publishingHouse", "%" + searchBookDto.getPublishingHouse() + "%" );
            }
            Query<BookDto> query = session.createQuery( q );
            query.setProperties( parameters );
            resultat = query.getResultList();

        } catch ( Exception e ) {
            e.printStackTrace();
        }
        return resultat;
    }*/

    public List<BookDto> searchBook(SearchBookDto searchBookDto) {

        return null;
    }
}