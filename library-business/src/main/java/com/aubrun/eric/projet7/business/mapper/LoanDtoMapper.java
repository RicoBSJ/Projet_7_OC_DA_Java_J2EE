package com.aubrun.eric.projet7.business.mapper;

import com.aubrun.eric.projet7.beans.Loan;
import com.aubrun.eric.projet7.business.dto.LoanDto;

public class LoanDtoMapper {

    static public LoanDto toDto(Loan loan) {

        LoanDto dto = new LoanDto();
        dto.setId(loan.getId());
        dto.setBookDto(BookDtoMapper.toDto(loan.getBook()));
        return dto;
    }

    static public Loan toEntity(LoanDto loanDto) {

        Loan entity = new Loan();
        entity.setId(loanDto.getId());
        entity.setBook(BookDtoMapper.toEntity(loanDto.getBookDto()));
        return entity;
    }
}
