package com.aubrun.eric.projet7.consumer.repository;

import com.aubrun.eric.projet7.beans.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class SearchRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Book> findAllByTitleAndBookAuthorAndBookEdition(Book book) {
        String query = ("SELECT b FROM Book b WHERE 1=1");
        if (book.getTitle() != "") {
            query += (" AND b.title LIKE :title" );
            entityManager.setProperty("title", "%" + book.getTitle() + "%");
        }
        if (book.getBookAuthor().getFirstName() != "") {
            query += (" AND b.bookAuthor.firstName LIKE :firstName" );
            entityManager.setProperty("firstName", "%" + book.getBookAuthor().getFirstName() + "%");
        }
        if (book.getBookAuthor().getLastName() != "") {
            query += (" AND b.bookAuthor.lastName LIKE :lastName" );
            entityManager.setProperty("lastName", "%" + book.getBookAuthor().getLastName() + "%");
        }
        if (book.getBookEdition().getNameEdition() != "") {
            query += (" AND b.bookEdition.nameEdition LIKE :edition" );
            entityManager.setProperty("edition", "%" + book.getBookEdition().getNameEdition() + "%");
        }
        entityManager.getProperties();
        entityManager.createQuery(query);
        return (List<Book>) entityManager;
    }
}
