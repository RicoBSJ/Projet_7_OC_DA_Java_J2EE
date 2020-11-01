package com.aubrun.eric.projet7.consumer.repository;

import com.aubrun.eric.projet7.beans.Book;
import com.aubrun.eric.projet7.beans.Borrowing;
import com.aubrun.eric.projet7.beans.UserAccount;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CreateBorrowing {

    @PersistenceContext
    private EntityManager entityManager;

    public Borrowing createBorrowing(UserAccount userAccount, Book book){
        Borrowing borrowing = new Borrowing();
        borrowing.getBorrowingId();
        book = borrowing.getBookBorrowing();
        userAccount = borrowing.getUserAccountBorrowing();
        borrowing.setBookBorrowing(book);
        borrowing.setUserAccountBorrowing(userAccount);
        return null;
    }
}
