package com.aubrun.eric.projet7.controllers;

import com.aubrun.eric.projet7.business.dto.BookDto;
import com.aubrun.eric.projet7.business.dto.BorrowingDto;
import com.aubrun.eric.projet7.business.dto.UserAccountDto;
import com.aubrun.eric.projet7.business.service.BookService;
import com.aubrun.eric.projet7.business.service.BorrowingService;
import com.aubrun.eric.projet7.business.service.UserAccountService;
import org.joda.time.DateTime;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/borrowings")
public class BorrowingController {

    public static final String DATE_FORMAT_NOW = "yyyy-MM-dd";

    private final BorrowingService borrowingService;
    private final BookService bookService;
    private final UserAccountService userAccountService;

    public BorrowingController(BorrowingService borrowingService, BookService bookService, UserAccountService userAccountService) {
        this.borrowingService = borrowingService;
        this.bookService = bookService;
        this.userAccountService = userAccountService;
    }

    @GetMapping("/")
    public List<BorrowingDto> getAllBorrowings() {
        return this.borrowingService.findAll();
    }

    @GetMapping("/{id}")
    public BorrowingDto getBorrowingById(@PathVariable(value = "id") int borrowingId) {
        return this.borrowingService.findById(borrowingId);
    }

    @PostMapping("/")
    public void createBorrowing(@RequestBody BorrowingDto borrowingDto) throws ParseException {

        BookDto idBookDto = bookService.findById(borrowingDto.getBookBorrowing().getBookId());
        UserAccountDto idUserAccountDto = userAccountService.findById(borrowingDto.getUserAccountBorrowing().getUserId());
        Integer quantityBook = borrowingDto.getBookBorrowing().getQuantity();
        String noBorrowingMessage = "L'ouvrage que vous souhaitez emprunter n'est pas disponible";

        if (quantityBook < 1) {
            borrowingService.delete(borrowingDto.getBorrowingId());
            System.out.println(noBorrowingMessage);
        } else {
            quantityBook--;
            borrowingDto.setBookBorrowing(idBookDto);
            borrowingDto.setUserAccountBorrowing(idUserAccountDto);
            borrowingDto.setBeginDate(stringToDate((now())));
            borrowingDto.setEndDate(addFourWeeks());
            borrowingDto.setRenewal(false);
            borrowingService.save(borrowingDto);
        }
    }

    @PutMapping("/borrowing")
    public void updateBorrowing(@RequestBody BorrowingDto borrowingDto) {
        borrowingService.update(borrowingDto);
    }

    @DeleteMapping("/{id}")
    public void deleteBorrowing(@PathVariable("id") int borrowingId) {
        borrowingService.delete(borrowingId);
    }

    public static String now() {
        LocalDate today = LocalDate.now();
        return today.toString();
    }

    public static Date addFourWeeks() {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate fourWeeksLater = LocalDate.now().plusDays(28);
        Date date = Date.from(fourWeeksLater.atStartOfDay(defaultZoneId).toInstant());
        return date;
    }

    public static Date stringToDate(String stringDate) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(stringDate);
        return date;
    }
}
