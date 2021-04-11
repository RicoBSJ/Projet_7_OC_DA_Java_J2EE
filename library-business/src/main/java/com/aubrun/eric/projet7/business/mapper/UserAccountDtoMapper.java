package com.aubrun.eric.projet7.business.mapper;

import com.aubrun.eric.projet7.beans.UserAccount;
import com.aubrun.eric.projet7.business.dto.UserAccountDto;

import java.util.stream.Collectors;

public class UserAccountDtoMapper {

    static public UserAccountDto toDto(UserAccount userAccount) {

        UserAccountDto dto = new UserAccountDto();
        dto.setUserId(userAccount.getUserId());
        dto.setUsername(userAccount.getUsername());
        dto.setEmail(userAccount.getEmail());
        dto.setPassword(userAccount.getPassword());
        /*dto.setBorrowingDtoList(userAccount.getBorrowingList().stream().map(BorrowingDtoMapper::toDto).collect(Collectors.toList()));
        dto.setRoleDtos(userAccount.getRoles().stream().map(RoleDtoMapper::toDto).collect(Collectors.toSet()));*/
        return dto;
    }

    static public UserAccount toEntity(UserAccountDto userAccountDto) {

        UserAccount entity = new UserAccount();
        entity.setUserId(userAccountDto.getUserId());
        entity.setUsername(userAccountDto.getUsername());
        entity.setEmail(userAccountDto.getEmail());
        entity.setPassword(userAccountDto.getPassword());
        /*entity.setBorrowingList(userAccountDto.getBorrowingDtoList().stream().map(BorrowingDtoMapper::toEntity).collect(Collectors.toList()));
        entity.setRoles(userAccountDto.getRoleDtos().stream().map(RoleDtoMapper::toEntity).collect(Collectors.toSet()));*/
        return entity;
    }
}
