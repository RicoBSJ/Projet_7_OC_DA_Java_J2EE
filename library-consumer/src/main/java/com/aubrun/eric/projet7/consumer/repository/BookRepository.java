package com.aubrun.eric.projet7.consumer.repository;

import com.aubrun.eric.projet7.beans.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    /*List<Book> findBooksByTitleContains(String name);*/

    /*@Query(value = "SELECT b FROM Book b WHERE 1=1 AND b.title LIKE :title")*/
    List<Book> findAllByTitle(String title);
}
