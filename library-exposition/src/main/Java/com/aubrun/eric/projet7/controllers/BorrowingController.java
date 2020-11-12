package com.aubrun.eric.projet7.controllers;

import com.aubrun.eric.projet7.business.dto.BookDto;
import com.aubrun.eric.projet7.business.dto.BorrowingDto;
import com.aubrun.eric.projet7.business.dto.UserAccountDto;
import com.aubrun.eric.projet7.business.service.BookService;
import com.aubrun.eric.projet7.business.service.BorrowingService;
import com.aubrun.eric.projet7.business.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/borrowings")
public class BorrowingController {

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

        if (borrowingDto.getBookBorrowing().getQuantity() < 1) {
            System.out.println("L'ouvrage que vous souhaitez emprunter n'est pas disponible");
        } else {
            borrowingDto.setBookBorrowing(idBookDto);
            borrowingDto.setUserAccountBorrowing(idUserAccountDto);
            borrowingDto.setBeginDate(stringToDate((now())));
            borrowingDto.setEndDate(addFourWeeks());
            borrowingDto.setRenewal(false);
            borrowingService.save(borrowingDto);
        }
    }

    @PutMapping("/")
    public void updateBorrowing(@RequestBody BorrowingDto borrowingDto) {

        BookDto idBookDto = bookService.findById(borrowingDto.getBookBorrowing().getBookId());
        UserAccountDto idUserAccountDto = userAccountService.findById(borrowingDto.getUserAccountBorrowing().getUserId());
        borrowingDto.setBookBorrowing(idBookDto);
        borrowingDto.setUserAccountBorrowing(idUserAccountDto);
        borrowingDto.getEndDate().setTime(+28);
        borrowingDto.setRenewal(true);
        System.out.println("Votre période de prêt est prolongée de 4 semaines");
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
