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
        List<Book> query = entityManager.createQuery("SELECT b FROM Book b WHERE 1=1 AND b.title LIKE :title AND b.bookAuthor.firstName LIKE :firstName AND b.bookAuthor.lastName LIKE :lastName AND b.bookEdition.nameEdition LIKE :edition")
                .setParameter("title", "%" + book.getTitle() + "%")
                .setParameter("firstName", "%" + book.getBookAuthor().getFirstName() + "%")
                .setParameter("lastName", "%" + book.getBookAuthor().getLastName() + "%")
                .setParameter("edition", "%" + book.getBookEdition().getNameEdition() + "%")
                .getResultList();
        return query;
    }
}
