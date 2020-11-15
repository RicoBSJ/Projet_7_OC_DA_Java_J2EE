package com.aubrun.eric.projet7.business.mapper;

import com.aubrun.eric.projet7.beans.UserAccount;
import com.aubrun.eric.projet7.business.dto.UserAccountDto;

import java.util.stream.Collectors;

public class UserAccountDtoMapper {

    static public UserAccountDto toDto(UserAccount userAccount) {

        UserAccountDto dto = new UserAccountDto();
        dto.setUserId(userAccount.getUserId());
        dto.setFirstName(userAccount.getFirstName());
        dto.setNameUser(userAccount.getNameUser());
        dto.setEmail(userAccount.getEmail());
        dto.setMotDePasse(userAccount.getMotDePasse());
        dto.setBorrowingDtoList(userAccount.getBorrowingList().stream().map(BorrowingDtoMapper::toDto).collect(Collectors.toList()));
        /*dto.setRoleDtoList(userAccount.getRoleList().stream().map(RoleDtoMapper::toDto).collect(Collectors.toList()));*/
        return dto;
    }

    static public UserAccount toEntity(UserAccountDto userAccountDto) {

        UserAccount entity = new UserAccount();
        entity.setUserId(userAccountDto.getUserId());
        entity.setFirstName(userAccountDto.getFirstName());
        entity.setNameUser(userAccountDto.getNameUser());
        entity.setEmail(userAccountDto.getEmail());
        entity.setMotDePasse(userAccountDto.getMotDePasse());
        entity.setBorrowingList(userAccountDto.getBorrowingDtoList().stream().map(BorrowingDtoMapper::toEntity).collect(Collectors.toList()));
        /*entity.setRoleList(userAccountDto.getRoleDtoList().stream().map(RoleDtoMapper::toEntity).collect(Collectors.toList()));*/
        return entity;
    }
}
