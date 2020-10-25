package com.aubrun.eric.projet7.consumer.repository;

import com.aubrun.eric.projet7.beans.Book;
import com.aubrun.eric.projet7.beans.SearchBook;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class SearchRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Book> findAllByTitleAndBookAuthorAndBookEdition(SearchBook searchBook) {
        List<Book> query = entityManager.createQuery("SELECT b FROM Book b WHERE 1=1 AND b.title LIKE :title AND b.bookAuthor.firstName LIKE :firstName AND b.bookAuthor.nameAuthor LIKE :lastName AND b.bookEdition.nameEdition LIKE :edition")
                .setParameter("title", "%" + searchBook.getSearchBookTitle() + "%")
                .setParameter("firstName", "%" + searchBook.getSearchBookAuthorFirstName() + "%")
                .setParameter("lastName", "%" + searchBook.getSearchBookAuthorLastName() + "%")
                .setParameter("edition", "%" + searchBook.getSearchBookPublishingHouse() + "%")
                .getResultList();
        return query;
    }
}
