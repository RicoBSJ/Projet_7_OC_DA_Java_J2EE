package com.aubrun.eric.projet7.business.service;

import com.aubrun.eric.projet7.business.dto.UserAccountDto;
import com.aubrun.eric.projet7.business.dto.UserRoleDto;
import com.aubrun.eric.projet7.business.mapper.UserAccountDtoMapper;
import com.aubrun.eric.projet7.business.mapper.UserRoleDtoMapper;
import com.aubrun.eric.projet7.consumer.repository.UserRepository;
import com.aubrun.eric.projet7.consumer.repository.UserRoleRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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

    public UserRoleDto saveRole(UserRoleDto newUser) {
        return UserRoleDtoMapper.toDto(userRoleRepository.save(UserRoleDtoMapper.toEntity(newUser)));
    }

    public UserAccountDto saveUser(UserAccountDto newUser) {
        String hashPW = bCryptPasswordEncoder.encode(newUser.getMotDePasse());
        newUser.setMotDePasse(hashPW);
        return UserAccountDtoMapper.toDto(userRepository.save(UserAccountDtoMapper.toEntity(newUser)));
    }

    public void addRoleToUser(String username, String roleName){
        UserRoleDto userRoleDto = userRoleService.findByRoleName(roleName);
        UserAccountDto userAccountDto = userAccountService.findByUserName(username);
        userAccountDto.getUserRoleDtoList().add(userRoleDto);
    }

    public UserAccountDto findUserByUserName(String username){
        return userAccountService.findByUserName(username);
    }
}
