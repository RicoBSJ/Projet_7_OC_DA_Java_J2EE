package com.aubrun.eric.projet7.consumer.repository;

import com.aubrun.eric.projet7.beans.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowingRepository extends JpaRepository<Borrowing, Integer> {

    default void streamBorrowingsByBeginDateAndEndDateAndRenewalAndUserAccountBorrowingAndBookBorrowing() {
    }
}
