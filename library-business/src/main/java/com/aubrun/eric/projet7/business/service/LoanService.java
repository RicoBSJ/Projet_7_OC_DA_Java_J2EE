package com.aubrun.eric.projet7.business.service;

import com.aubrun.eric.projet7.beans.Loan;
import com.aubrun.eric.projet7.business.dto.LoanDto;
import com.aubrun.eric.projet7.business.mapper.LoanDtoMapper;
import com.aubrun.eric.projet7.consumer.repository.LoanRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LoanService {

    private final LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public List<LoanDto> findAll() {

        List<LoanDto> dtos = new ArrayList<>();
        List<Loan> loans = new ArrayList<>();
        for (Loan a : loans) {
            LoanDto dto = LoanDtoMapper.toDto(a);
            dtos.add(dto);
        }
        return dtos;
        /*return loanRepository.findAll().stream().map(LoanDtoMapper::toDto).collect(Collectors.toList());*/
    }

    public void saveOrUpdate(LoanDto newLoan) {

        loanRepository.save(LoanDtoMapper.toEntity(newLoan));
    }

    public LoanDto findById(Integer id) {

        return LoanDtoMapper.toDto(loanRepository.findById(id).get());
    }

    public void delete(Integer id) {

        Loan loan = loanRepository.findById(id).get();
        loanRepository.delete(loan);
    }
}
