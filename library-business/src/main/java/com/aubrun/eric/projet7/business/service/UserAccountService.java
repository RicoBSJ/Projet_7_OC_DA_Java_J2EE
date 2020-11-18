package com.aubrun.eric.projet7.business.service;

import com.aubrun.eric.projet7.business.dto.UserAccountDto;
import com.aubrun.eric.projet7.business.mapper.UserAccountDtoMapper;
import com.aubrun.eric.projet7.consumer.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserAccountService {

    private final UserRepository userRepository;

    public UserAccountService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserAccountDto> findAll() {

        return userRepository.findAll().stream().map(UserAccountDtoMapper::toDto).collect(Collectors.toList());
    }

    public int save(UserAccountDto newUser) {

        return userRepository.save(UserAccountDtoMapper.toEntity(newUser)).getUserId();
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

    public UserAccountDto findByUserName(String username){

        return UserAccountDtoMapper.toDto(userRepository.findByNameUser(username));
    }
}
