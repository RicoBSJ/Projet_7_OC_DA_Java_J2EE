package com.aubrun.eric.projet7.consumer.repository;

import com.aubrun.eric.projet7.beans.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
}
