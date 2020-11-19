package com.aubrun.eric.projet7.business.service;

import com.aubrun.eric.projet7.beans.UserAccount;
import com.aubrun.eric.projet7.beans.UserRole;
import com.aubrun.eric.projet7.consumer.repository.UserAccountRepository;
import com.aubrun.eric.projet7.consumer.repository.UserRoleRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserAccountRepository userAccountRepository;
    private final UserRoleRepository userRoleRepository;

    public AccountServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder, UserAccountRepository userAccountRepository, UserRoleRepository userRoleRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userAccountRepository = userAccountRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserAccount saveUser(UserAccount userAccount) {
        String hashPW = bCryptPasswordEncoder.encode(userAccount.getMotDePasse());
        userAccount.setMotDePasse(hashPW);
        return userAccountRepository.save(userAccount);
    }

    @Override
    public UserRole saveRole(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        UserRole userRole = userRoleRepository.findByUserRoleName(roleName);
        UserAccount userAccount = userAccountRepository.findByNameUser(username);
        userAccount.getUserRoleList().add(userRole);
    }

    @Override
    public UserAccount findUserByUserName(String username) {
        return userAccountRepository.findByNameUser(username);
    }
}
