package com.aubrun.eric.projet7.business.service;

import com.aubrun.eric.projet7.beans.User;
import com.aubrun.eric.projet7.business.dto.UserDto;
import com.aubrun.eric.projet7.business.mapper.UserDtoMapper;
import com.aubrun.eric.projet7.consumer.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> findAll() {

        List<UserDto> dtos = new ArrayList<>();
        List<User> users = new ArrayList<>();
        for (User a : users) {
            UserDto dto = UserDtoMapper.toDto(a);
            dtos.add(dto);
        }
        return dtos;
        /*return userRepository.findAll().stream().map(UserDtoMapper::toDto).collect(Collectors.toList());*/
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
