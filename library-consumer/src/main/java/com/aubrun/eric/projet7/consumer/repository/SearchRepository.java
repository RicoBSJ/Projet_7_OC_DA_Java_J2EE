package com.aubrun.eric.projet7.consumer.repository;

import com.aubrun.eric.projet7.beans.Book;
import com.aubrun.eric.projet7.business.dto.SearchBookDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
public class SearchRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Book> findAllByTitleAndBookAuthorAndBookEditionAndYearBook(SearchBookDto searchBookDto) {
        entityManager.createQuery("SELECT b FROM Book b WHERE 1=1 AND b.title LIKE :title AND b.bookAuthor.firstName LIKE :bookAuthor AND b.bookEdition LIKE :bookEdition AND b.yearBook LIKE :yearBook");
        return null;
    }
}
