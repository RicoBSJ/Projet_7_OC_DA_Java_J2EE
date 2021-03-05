package com.aubrun.eric.projet7.controllers;

import com.aubrun.eric.projet7.business.dto.BatchDto;
import com.aubrun.eric.projet7.business.service.BorrowingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    private final BorrowingService borrowingService;

    public MailController(BorrowingService borrowingService) {
        this.borrowingService = borrowingService;
    }

    @PostMapping("/sendMail")
    public void mailLate(@RequestBody BatchDto batchDto) {
        borrowingService.sendMail(batchDto);
    }
}
