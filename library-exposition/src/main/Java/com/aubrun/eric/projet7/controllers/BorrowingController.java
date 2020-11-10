package com.aubrun.eric.projet7.controllers;

import com.aubrun.eric.projet7.business.dto.BookDto;
import com.aubrun.eric.projet7.business.dto.BorrowingDto;
import com.aubrun.eric.projet7.business.dto.UserAccountDto;
import com.aubrun.eric.projet7.business.service.BookService;
import com.aubrun.eric.projet7.business.service.BorrowingService;
import com.aubrun.eric.projet7.business.service.UserAccountService;
import org.joda.time.DateTime;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/borrowings")
public class BorrowingController {

    public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";

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
    public void createBorrowing(@RequestBody BorrowingDto borrowingDto) {
        borrowingService.save(borrowingDto);
    }

    @PutMapping("/loan")
    public void updateBorrowing(@RequestBody BorrowingDto borrowingDto) {
        borrowingService.update(borrowingDto);
    }

    @DeleteMapping("/{id}")
    public void deleteBorrowing(@PathVariable("id") int borrowingId) {
        borrowingService.delete(borrowingId);
    }

    @PostMapping("/createBorrowing")
    public void createUserBorrowing(@RequestBody BorrowingDto borrowingDto) throws ParseException {

        BookDto idBookDto = bookService.findById(borrowingDto.getBookBorrowing().getBookId());
        UserAccountDto idUserAccountDto = userAccountService.findById(borrowingDto.getUserAccountBorrowing().getUserId());
        Integer quantityBook = borrowingDto.getBookBorrowing().getQuantity();
        String noBorrowingMessage = "L'ouvrage que vous souhaitez emprunter n'est pas disponible";

        borrowingDto.setBookBorrowing(idBookDto);
        borrowingDto.setUserAccountBorrowing(idUserAccountDto);
        borrowingDto.setBeginDate(stringToDate((now())));
        borrowingDto.setEndDate(addFourWeeksJodaTime(now()));
        borrowingDto.setRenewal(false);
        if (quantityBook < 1) {
            borrowingService.delete(borrowingDto.getBorrowingId());
            System.out.println(noBorrowingMessage);
        } else {
            quantityBook--;
            borrowingService.save(borrowingDto);
        }
    }

    public static String now() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        return sdf.format(cal.getTime());
    }

    public static Date addFourWeeksJodaTime(String currentDate) {
        DateTime dateTime = new DateTime(currentDate);
        dateTime.plusDays(28).toString("yyyy-MM-dd");
        return dateTime.toDate();
    }

    public static Date stringToDate(String stringDate) throws ParseException {
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate);
        return date;
    }
}
