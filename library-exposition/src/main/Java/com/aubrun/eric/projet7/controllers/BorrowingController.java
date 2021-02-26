package com.aubrun.eric.projet7.controllers;

import com.aubrun.eric.projet7.business.dto.BatchDto;
import com.aubrun.eric.projet7.business.dto.BookDto;
import com.aubrun.eric.projet7.business.dto.BorrowingDto;
import com.aubrun.eric.projet7.business.service.BorrowingService;
import com.aubrun.eric.projet7.business.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/borrowings")
public class BorrowingController {

    private final BorrowingService borrowingService;

    public BorrowingController(BorrowingService borrowingService, UserAccountService userAccountService) {
        this.borrowingService = borrowingService;
    }

    @GetMapping("/")
    public List<BorrowingDto> getAllBorrowings(Principal principal) {
        return this.borrowingService.findAll(principal);
    }

    @GetMapping("/{id}")
    public BorrowingDto getBorrowingById(@PathVariable(value = "id") int borrowingId) {
        return this.borrowingService.findById(borrowingId);
    }

    @PostMapping("/")
    public void createBorrowing(Principal principal, @RequestBody BookDto bookDto) {

        borrowingService.save(bookDto.getBookId(), principal.getName());
    }

    @PutMapping("/{id}")
    public void updateBorrowing(@PathVariable(value = "id") int borrowingId) {

        borrowingService.update(borrowingId);
    }

    @DeleteMapping("/{id}")
    public void deleteBorrowing(@PathVariable("id") int borrowingId) {
        borrowingService.delete(borrowingId);
    }

    @GetMapping("/lateDate")
    public List<BatchDto> lateBorrowingDate(){
        return this.borrowingService.findLateBorrowingDate();
    }
}
