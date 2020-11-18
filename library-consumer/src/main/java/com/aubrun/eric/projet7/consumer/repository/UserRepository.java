package com.aubrun.eric.projet7.consumer.repository;

import com.aubrun.eric.projet7.beans.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserAccount, Integer> {
    UserAccount findByNameUser(String username);
}
