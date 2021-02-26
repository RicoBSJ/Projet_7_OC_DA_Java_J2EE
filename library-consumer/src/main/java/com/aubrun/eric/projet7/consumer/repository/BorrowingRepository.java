package com.aubrun.eric.projet7.consumer.repository;

import com.aubrun.eric.projet7.beans.Borrowing;
import com.aubrun.eric.projet7.beans.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BorrowingRepository extends JpaRepository<Borrowing, Integer> {
    @Query("SELECT b FROM Borrowing b WHERE b.userAccountBorrowing = :userAccount")
    List<Borrowing> findAllUserBorrowing(UserAccount userAccount);

    @Query("SELECT b FROM Borrowing b WHERE b.endDate <= :date")
    List<Borrowing> findBorrowingByEndDateAndUserAccountBorrowing(LocalDate date);

}
