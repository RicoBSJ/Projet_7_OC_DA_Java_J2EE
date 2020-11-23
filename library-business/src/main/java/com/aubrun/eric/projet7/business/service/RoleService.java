package com.aubrun.eric.projet7.business.service;

import com.aubrun.eric.projet7.business.dto.RoleDto;
import com.aubrun.eric.projet7.business.mapper.RoleDtoMapper;
import com.aubrun.eric.projet7.consumer.repository.RoleRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<RoleDto> findAll() {

        return roleRepository.findAll().stream().map(RoleDtoMapper::toDto).collect(Collectors.toList());
    }

    public int save(RoleDto newUser) {

        return roleRepository.save(RoleDtoMapper.toEntity(newUser)).getRoleId();
    }

    public RoleDto update(RoleDto roleDto) {

        return RoleDtoMapper.toDto(roleRepository.save(RoleDtoMapper.toEntity(roleDto)));
    }

    public RoleDto findById(Integer id) {

        return RoleDtoMapper.toDto(roleRepository.findById(id).get());
    }

    public void deleteById(Integer id) {

        roleRepository.deleteById(id);
    }
}
