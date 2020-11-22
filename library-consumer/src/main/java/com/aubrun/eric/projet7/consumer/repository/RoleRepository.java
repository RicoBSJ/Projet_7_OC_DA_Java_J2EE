package com.aubrun.eric.projet7.consumer.repository;

import com.aubrun.eric.projet7.beans.ERole;
import com.aubrun.eric.projet7.beans.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByRoleName(ERole roleName);
    Optional<Role> findByRoleId(ERole roleId);
}
