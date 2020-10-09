package com.aubrun.eric.projet7.business.mapper;

import com.aubrun.eric.projet7.beans.UserAccount;
import com.aubrun.eric.projet7.business.dto.UserDto;

import java.util.stream.Collectors;

public class UserDtoMapper {

    static public UserDto toDto(UserAccount userAccount) {

        UserDto dto = new UserDto();
        dto.setUserId(userAccount.getUserId());
        dto.setFirstName(userAccount.getFirstName());
        dto.setNameUser(userAccount.getNameUser());
        dto.setEmail(userAccount.getEmail());
        dto.setMotDePasse(userAccount.getMotDePasse());
        dto.setLoanList(userAccount.getLoanList().stream().map(LoanDtoMapper::toDto).collect(Collectors.toList()));
        return dto;
    }

    static public UserAccount toEntity(UserDto userDto) {

        UserAccount entity = new UserAccount();
        entity.setUserId(userDto.getUserId());
        entity.setFirstName(userDto.getFirstName());
        entity.setNameUser(entity.getNameUser());
        entity.setEmail(userDto.getEmail());
        entity.setMotDePasse(userDto.getMotDePasse());
        entity.setLoanList(userDto.getLoanList().stream().map(LoanDtoMapper::toEntity).collect(Collectors.toList()));
        return entity;
    }
}
