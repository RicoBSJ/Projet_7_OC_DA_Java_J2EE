package com.aubrun.eric.projet7.business.mapper;

import com.aubrun.eric.projet7.beans.UserAccount;
import com.aubrun.eric.projet7.business.dto.UserAccountDto;

public class UserAccountDtoMapper {

    static public UserAccountDto toDto(UserAccount userAccount) {

        UserAccountDto dto = new UserAccountDto();
        dto.setUserId(userAccount.getUserId());
        dto.setFirstName(userAccount.getFirstName());
        dto.setNameUser(userAccount.getNameUser());
        dto.setEmail(userAccount.getEmail());
        dto.setMotDePasse(userAccount.getMotDePasse());
        return dto;
    }

    static public UserAccount toEntity(UserAccountDto userAccountDto) {

        UserAccount entity = new UserAccount();
        entity.setUserId(userAccountDto.getUserId());
        entity.setFirstName(userAccountDto.getFirstName());
        entity.setNameUser(userAccountDto.getNameUser());
        entity.setEmail(userAccountDto.getEmail());
        entity.setMotDePasse(userAccountDto.getMotDePasse());
        return entity;
    }
}
