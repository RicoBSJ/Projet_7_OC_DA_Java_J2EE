package com.aubrun.eric.projet7.business.mapper;

import com.aubrun.eric.projet7.beans.Loan;
import com.aubrun.eric.projet7.business.dto.LoanDto;

public class LoanDtoMapper {

    static public LoanDto toDto(Loan loan) {

        LoanDto dto = new LoanDto();
        dto.setLoanId(loan.getLoanId());
        dto.setLoanBook(BookDtoMapper.toDto(loan.getLoanBook()));
        return dto;
    }

    static public Loan toEntity(LoanDto loanDto) {

        Loan entity = new Loan();
        entity.setLoanId(loanDto.getLoanId());
        entity.setLoanBook(BookDtoMapper.toEntity(loanDto.getLoanBook()));
        return entity;
    }
}
