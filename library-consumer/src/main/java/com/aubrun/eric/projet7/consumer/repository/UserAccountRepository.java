package com.aubrun.eric.projet7.consumer.repository;

import com.aubrun.eric.projet7.beans.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {

    UserAccount findByNameUser(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
