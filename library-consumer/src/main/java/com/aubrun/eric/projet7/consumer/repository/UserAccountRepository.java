package com.aubrun.eric.projet7.consumer.repository;

import com.aubrun.eric.projet7.beans.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {

    Optional<UserAccount> findByNameUser(String username);
    boolean existsByNameUser(String username);
    boolean existsByEmail(String email);
}
