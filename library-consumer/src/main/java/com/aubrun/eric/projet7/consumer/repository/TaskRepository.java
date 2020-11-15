package com.aubrun.eric.projet7.consumer.repository;

import com.aubrun.eric.projet7.beans.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

}
