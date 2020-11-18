package com.aubrun.eric.projet7.business.service;

import com.aubrun.eric.projet7.business.dto.UserAccountDto;
import com.aubrun.eric.projet7.business.dto.UserRoleDto;
import com.aubrun.eric.projet7.business.mapper.UserAccountDtoMapper;
import com.aubrun.eric.projet7.consumer.repository.UserRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserAccountService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRoleService userRoleService;
    private final UserAccountService userAccountService;

    public UserAccountService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, UserRoleService userRoleService, @Lazy UserAccountService userAccountService) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRoleService = userRoleService;
        this.userAccountService = userAccountService;
    }

    public List<UserAccountDto> findAll() {

        return userRepository.findAll().stream().map(UserAccountDtoMapper::toDto).collect(Collectors.toList());
    }

    public int save(UserAccountDto newUser) {
        String hashPW = bCryptPasswordEncoder.encode(newUser.getMotDePasse());
        newUser.setMotDePasse(hashPW);
        return userRepository.save(UserAccountDtoMapper.toEntity(newUser)).getUserId();
    }

    public void addRoleToUser(String username, String roleName){
        UserRoleDto userRoleDto = userRoleService.obtainByNameRole(roleName);
        UserAccountDto userAccountDto = userAccountService.obtainByNameUser(username);
        userAccountDto.getUserRoleDtoList().add(userRoleDto);
    }

    public UserAccountDto update(UserAccountDto newUser) {

        return UserAccountDtoMapper.toDto(userRepository.save(UserAccountDtoMapper.toEntity(newUser)));
    }

    public UserAccountDto findById(Integer id) {

        return UserAccountDtoMapper.toDto(userRepository.findById(id).get());
    }

    public void delete(Integer id) {

        userRepository.deleteById(id);
    }

    public UserAccountDto obtainByNameUser(String username){

        return UserAccountDtoMapper.toDto(userRepository.findByNameUser(username));
    }
}
