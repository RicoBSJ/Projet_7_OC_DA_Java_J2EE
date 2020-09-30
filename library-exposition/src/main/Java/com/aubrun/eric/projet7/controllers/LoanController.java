package com.aubrun.eric.projet7.controllers;

import com.aubrun.eric.projet7.business.dto.LoanDto;
import com.aubrun.eric.projet7.business.service.LoanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping("/")
    public List<LoanDto> getAllLoans(){
        return this.loanService.findAll();
    }

    @GetMapping("/{id}")
    public LoanDto getLoanById(@PathVariable(value = "id") int loanId){
        return this.loanService.findById(loanId);
    }

    @PostMapping("/")
    public void createLoan(@RequestBody LoanDto loanDto){
        loanService.saveOrUpdate(loanDto);
    }

    @PutMapping("/{id}")
    public void updateLoan(@RequestBody LoanDto loanDto, @PathVariable("id") int loanId){
        LoanDto existingLoan = loanService.findById(loanId);
        existingLoan.setBookDto(loanDto.getBookDto());
        loanService.saveOrUpdate(existingLoan);
    }

    @DeleteMapping("/{id}")
    public void deleteLoan(@PathVariable("id") int loanId){
        LoanDto existingLoan = loanService.findById(loanId);
        loanService.delete(existingLoan.getId());
    }
}
