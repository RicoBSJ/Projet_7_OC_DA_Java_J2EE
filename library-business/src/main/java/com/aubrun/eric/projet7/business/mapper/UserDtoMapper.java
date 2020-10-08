package com.aubrun.eric.projet7.business.mapper;

import com.aubrun.eric.projet7.beans.Loan;
import com.aubrun.eric.projet7.beans.User;
import com.aubrun.eric.projet7.business.dto.LoanDto;
import com.aubrun.eric.projet7.business.dto.UserDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserDtoMapper {

    static public UserDto toDto(User user) {

        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setMotDePasse(user.getMotDePasse());
        dto.setLoans(user.getLoans().stream().map(LoanDtoMapper::toDto).collect(Collectors.toList()));
        return dto;
    }

    static public User toEntity(UserDto userDto) {

        User entity = new User();
        entity.setId(userDto.getId());
        entity.setFirstName(userDto.getFirstName());
        entity.setName(entity.getName());
        entity.setEmail(userDto.getEmail());
        entity.setMotDePasse(userDto.getMotDePasse());
        entity.setLoans(userDto.getLoans().stream().map(LoanDtoMapper::toEntity).collect(Collectors.toList()));
        return entity;
    }
}
