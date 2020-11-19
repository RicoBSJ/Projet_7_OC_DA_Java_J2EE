package com.aubrun.eric.projet7.business.service;

import com.aubrun.eric.projet7.beans.UserAccount;
import com.aubrun.eric.projet7.beans.UserRole;
import com.aubrun.eric.projet7.business.dto.UserAccountDto;
import com.aubrun.eric.projet7.business.dto.UserRoleDto;
import com.aubrun.eric.projet7.business.mapper.UserAccountDtoMapper;
import com.aubrun.eric.projet7.business.mapper.UserRoleDtoMapper;
import com.aubrun.eric.projet7.consumer.repository.UserRepository;
import com.aubrun.eric.projet7.consumer.repository.UserRoleRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AccountService {

    private final UserRoleService userRoleService;
    private final UserAccountService userAccountService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    public AccountService(UserRoleService userRoleService, UserAccountService userAccountService, BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.userRoleService = userRoleService;
        this.userAccountService = userAccountService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    public UserRole saveRole(UserRole newUser) {
        return userRoleRepository.save(newUser);
    }

    public UserAccount saveUser(UserAccount newUser) {
        String hashPW = bCryptPasswordEncoder.encode(newUser.getMotDePasse());
        newUser.setMotDePasse(hashPW);
        return userRepository.save(newUser);
    }

    public void addRoleToUser(String username, String roleName){
        UserRole userRole = userRoleService.findByRoleName(roleName);
        UserAccount userAccount = userAccountService.findByUserName(username);
        userAccount.getUserRoleList().add(userRole);
    }

    public UserAccount findUserByUserName(String username){
        return userAccountService.findByUserName(username);
    }
}
