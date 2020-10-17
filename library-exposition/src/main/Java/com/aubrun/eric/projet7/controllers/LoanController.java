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
    public List<LoanDto> getAllLoans() {
        return this.loanService.findAll();
    }

    @GetMapping("/{id}")
    public LoanDto getLoanById(@PathVariable(value = "id") int loanId) {
        return this.loanService.findById(loanId);
    }

    @PostMapping("/")
    public void createLoan(@RequestBody LoanDto loanDto) {
        loanService.save(loanDto);
    }

    @PutMapping("/loan")
    public void updateLoan(@RequestBody LoanDto loanDto) {
        loanService.update(loanDto);
    }

    @DeleteMapping("/{id}")
    public void deleteLoan(@PathVariable("id") int loanId) {
        loanService.delete(loanId);
    }
}
