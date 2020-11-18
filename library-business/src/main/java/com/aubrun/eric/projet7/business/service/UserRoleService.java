package com.aubrun.eric.projet7.business.service;

import com.aubrun.eric.projet7.business.dto.UserRoleDto;
import com.aubrun.eric.projet7.business.mapper.UserRoleDtoMapper;
import com.aubrun.eric.projet7.consumer.repository.UserRoleRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRoleService(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    public List<UserRoleDto> findAll() {

        return userRoleRepository.findAll().stream().map(UserRoleDtoMapper::toDto).collect(Collectors.toList());
    }

    public int save(UserRoleDto newUser) {

        return userRoleRepository.save(UserRoleDtoMapper.toEntity(newUser)).getUserRoleId();
    }

    public UserRoleDto update(UserRoleDto userRoleDto) {

        return UserRoleDtoMapper.toDto(userRoleRepository.save(UserRoleDtoMapper.toEntity(userRoleDto)));
    }

    public UserRoleDto findById(Integer id) {

        return UserRoleDtoMapper.toDto(userRoleRepository.findById(id).get());
    }

    public void delete(Integer id) {

        userRoleRepository.deleteById(id);
    }

    public UserRoleDto findByRoleName(String username){

        return UserRoleDtoMapper.toDto(userRoleRepository.findByUserRoleName(username));
    }
}
