package com.aubrun.eric.projet7.consumer.repository;

import com.aubrun.eric.projet7.beans.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
