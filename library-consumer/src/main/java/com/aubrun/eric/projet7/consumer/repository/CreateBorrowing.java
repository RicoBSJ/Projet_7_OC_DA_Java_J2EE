package com.aubrun.eric.projet7.consumer.repository;

import com.aubrun.eric.projet7.beans.Book;
import com.aubrun.eric.projet7.beans.Borrowing;
import com.aubrun.eric.projet7.beans.UserAccount;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CreateBorrowing {

    @PersistenceContext
    private EntityManager entityManager;
    private Borrowing borrowing;

    public Borrowing createBorrowing(UserAccount userAccount, Book book){

        Session session = entityManager.unwrap(Session.class);
        {
            session.getTransaction().begin();
            session.save(userAccount);
            session.save(book);
            borrowing = (Borrowing) session;
            session.getTransaction().commit();
        }
        return borrowing;
    }
}
