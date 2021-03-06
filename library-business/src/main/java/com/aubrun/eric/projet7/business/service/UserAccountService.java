package com.aubrun.eric.projet7.business.service;

import com.aubrun.eric.projet7.beans.UserAccount;
import com.aubrun.eric.projet7.business.dto.UserAccountDto;
import com.aubrun.eric.projet7.business.mapper.CategoryDtoMapper;
import com.aubrun.eric.projet7.business.mapper.UserAccountDtoMapper;
import com.aubrun.eric.projet7.consumer.repository.UserAccountRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserAccountService {

    private final UserAccountRepository userAccountRepository;

    public UserAccountService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    public List<UserAccountDto> findAll() {

        return userAccountRepository.findAll().stream().map(UserAccountDtoMapper::toDto).collect(Collectors.toList());
    }

    public void save(UserAccountDto newUser) {

        userAccountRepository.save(UserAccountDtoMapper.toEntity(newUser)).getUserId();
    }

    public UserAccountDto update(UserAccountDto newUser) {

        return UserAccountDtoMapper.toDto(userAccountRepository.save(UserAccountDtoMapper.toEntity(newUser)));
    }

    public UserAccountDto findById(Integer id) {

        return UserAccountDtoMapper.toDto(userAccountRepository.findById(id).get());
    }

    public void delete(Integer id) {

        userAccountRepository.deleteById(id);
    }
}
