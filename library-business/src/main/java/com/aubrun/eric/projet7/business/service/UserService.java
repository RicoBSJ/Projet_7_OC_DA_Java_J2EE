package com.aubrun.eric.projet7.business.service;

import com.aubrun.eric.projet7.beans.User;
import com.aubrun.eric.projet7.business.dto.UserDto;
import com.aubrun.eric.projet7.business.mapper.UserDtoMapper;
import com.aubrun.eric.projet7.consumer.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> findAll() {

        return userRepository.findAll().stream().map(UserDtoMapper::toDto).collect(Collectors.toList());
    }

    public void saveOrUpdate(UserDto newUser) {

        userRepository.save(UserDtoMapper.toEntity(newUser));
    }

    public UserDto findById(Integer id) {

        return UserDtoMapper.toDto(userRepository.findById(id).get());
    }

    public void delete(Integer id) {

        User user = userRepository.findById(id).get();
        userRepository.delete(user);
    }
}
