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
        if (searchBook.getSearchBookTitle() != "" && searchBook.getSearchBookTitle() != null) {
            q += " AND b.title LIKE :title";
            parameters.put("title", "%" + searchBook.getSearchBookTitle() + "%");
        }
        if (searchBook.getSearchBookAuthorName() != "" && searchBook.getSearchBookAuthorName() != null) {
            q += " AND (b.bookAuthor.lastName LIKE :name or b.bookAuthor.firstName LIKE :name)";
            parameters.put("name", "%" + searchBook.getSearchBookAuthorName() + "%");
        }
        if (searchBook.getSearchBookPublishingHouse() != "" && searchBook.getSearchBookPublishingHouse() != null) {
            q += " AND b.bookEdition.nameEdition LIKE :edition";
            parameters.put("edition", "%" + searchBook.getSearchBookPublishingHouse() + "%");
        }
        if (searchBook.getSearchBookReleaseDate() != null) {
            q += " AND b.yearBook LIKE :year";
            parameters.put("year", "%" + searchBook.getSearchBookReleaseDate() + "%");
        }
        Query<Book> query = session.createQuery(q);
        query.setProperties(parameters);
        resultat = query.getResultList();
        return resultat;
    }
}
