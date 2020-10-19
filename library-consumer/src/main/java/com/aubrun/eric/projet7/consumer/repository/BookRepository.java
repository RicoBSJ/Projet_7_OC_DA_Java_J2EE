package com.aubrun.eric.projet7.consumer.repository;

import com.aubrun.eric.projet7.beans.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    /*List<Book> findBooksByTitleContains(String name);*/

    List<Book> findByBookAuthor(String author);

    List<Book> findByYearBook(Date year);

    List<Book> findByTitle(String title);
}
