package com.aubrun.eric.projet7.consumer.repository;

import com.aubrun.eric.projet7.beans.Book;
import com.aubrun.eric.projet7.beans.SearchBook;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SearchRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Book> findAllByTitleAndBookAuthorAndBookEdition(SearchBook searchBook) {
        Session session = entityManager.unwrap(Session.class);
        List<Book> resultat = null;
        Map<String, String> parameters = new HashMap<>();
        String q = "SELECT b FROM Book b WHERE 1=1";
        if (searchBook.getSearchBookTitle() == "") {
            q += " AND b.title LIKE :title";
            parameters.put("title", "%" + searchBook.getSearchBookTitle() + "%");
        }
        if (searchBook.getSearchBookAuthorFirstName() != "") {
            q += " AND b.bookAuthor.firstName LIKE :firstName";
            parameters.put("firstName", "%" + searchBook.getSearchBookAuthorFirstName() + "%");
        }
        if (searchBook.getSearchBookAuthorLastName() != "") {
            q += " AND b.bookAuthor.lastName LIKE :lastName";
            parameters.put("lastName", "%" + searchBook.getSearchBookAuthorLastName() + "%");
        }
        if (searchBook.getSearchBookPublishingHouse() != "") {
            q += " AND b.bookEdition.nameEdition LIKE :edition";
            parameters.put("edition", "%" + searchBook.getSearchBookPublishingHouse() + "%");
        }
        Query<Book> query = session.createQuery(q);
        query.setProperties(parameters);
        resultat = query.getResultList();
        return resultat;
    }
}
