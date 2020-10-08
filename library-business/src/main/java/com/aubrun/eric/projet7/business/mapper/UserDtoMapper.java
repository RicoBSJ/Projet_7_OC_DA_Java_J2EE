package com.aubrun.eric.projet7.business.mapper;

import com.aubrun.eric.projet7.beans.User;
import com.aubrun.eric.projet7.business.dto.UserDto;

import java.util.stream.Collectors;

public class UserDtoMapper {

    static public UserDto toDto(User user) {

        UserDto dto = new UserDto();
        dto.setUserId(user.getUserId());
        dto.setFirstName(user.getFirstName());
        dto.setNameUser(user.getNameUser());
        dto.setEmail(user.getEmail());
        dto.setMotDePasse(user.getMotDePasse());
        dto.setLoanList(user.getLoanList().stream().map(LoanDtoMapper::toDto).collect(Collectors.toList()));
        return dto;
    }

    static public User toEntity(UserDto userDto) {

        User entity = new User();
        entity.setUserId(userDto.getUserId());
        entity.setFirstName(userDto.getFirstName());
        entity.setNameUser(entity.getNameUser());
        entity.setEmail(userDto.getEmail());
        entity.setMotDePasse(userDto.getMotDePasse());
        entity.setLoanList(userDto.getLoanList().stream().map(LoanDtoMapper::toEntity).collect(Collectors.toList()));
        return entity;
    }
}
