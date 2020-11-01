package com.aubrun.eric.projet7.business.mapper;

import com.aubrun.eric.projet7.beans.Borrowing;
import com.aubrun.eric.projet7.business.dto.BorrowingDto;

public class BorrowingDtoMapper {

    static public BorrowingDto toDto(Borrowing borrowing) {

        BorrowingDto dto = new BorrowingDto();
        dto.setBorrowingId(borrowing.getBorrowingId());
        dto.setBookBorrowing(BookDtoMapper.toDto(borrowing.getBookBorrowing()));
        dto.setUserAccountBorrowing(UserAccountDtoMapper.toDto(borrowing.getUserAccountBorrowing()));
        dto.setBeginDate(borrowing.getBeginDate());
        dto.setEndDate(borrowing.getEndDate());
        dto.setRenewal(borrowing.getRenewal());
        return dto;
    }

    static public Borrowing toEntity(BorrowingDto borrowingDto) {

        Borrowing entity = new Borrowing();
        entity.setBorrowingId(borrowingDto.getBorrowingId());
        entity.setBookBorrowing(BookDtoMapper.toEntity(borrowingDto.getBookBorrowing()));
        entity.setUserAccountBorrowing(UserAccountDtoMapper.toEntity(borrowingDto.getUserAccountBorrowing()));
        entity.setBeginDate(borrowingDto.getBeginDate());
        entity.setEndDate(borrowingDto.getEndDate());
        entity.setRenewal(borrowingDto.getRenewal());
        return entity;
    }
}
