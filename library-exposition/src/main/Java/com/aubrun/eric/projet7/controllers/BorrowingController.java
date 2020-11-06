package com.aubrun.eric.projet7.controllers;

import com.aubrun.eric.projet7.business.dto.BookDto;
import com.aubrun.eric.projet7.business.dto.BorrowingDto;
import com.aubrun.eric.projet7.business.dto.UserAccountDto;
import com.aubrun.eric.projet7.business.service.BookService;
import com.aubrun.eric.projet7.business.service.BorrowingService;
import com.aubrun.eric.projet7.business.service.UserAccountService;
import org.joda.time.DateTime;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/borrowings")
public class BorrowingController {

    public static final String ATT_SESSION_USER = "sessionUser";

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
    public void createUserBorrowing(@RequestBody BorrowingDto borrowingDto, HttpServletRequest request, HttpServletResponse response) throws ParseException {

        HttpSession session = request.getSession();
        UserAccountDto connectedUserAccountDto = (UserAccountDto) session.getAttribute(ATT_SESSION_USER);

        if(connectedUserAccountDto == null){
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            throw new RuntimeException();
        }

        Integer idBook = Integer.parseInt("bookId");
        Integer idUser = Integer.parseInt("userId");
        BookDto bookDto = bookService.findById(idBook);
        connectedUserAccountDto = userAccountService.findById(idUser);
        borrowingDto = new BorrowingDto();
        borrowingDto.setBookBorrowing(bookDto);
        borrowingDto.setUserAccountBorrowing(connectedUserAccountDto);
        borrowingDto.setBeginDate(currentDate());
        /*borrowingDto.setEndDate(stringToDate(addFourWeeksJodaTime(dateToString(currentDate()))));*/
        borrowingDto.setRenewal(false);
    }

    public static DateFormat currentDate(){
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        return dateFormat;
    }

    public static String dateToString(DateFormat dateFormat){
        return dateFormat.format(dateFormat);
    }

    public static String addFourWeeksJodaTime(String date) {
        DateTime dateTime = new DateTime(date);
        return dateTime
                .plusDays(28)
                .toString("yyyy-MM-dd");
    }

    public static Date stringToDate(String stringDate) throws ParseException {
        Date date=new SimpleDateFormat("dd/MM/yyyy").parse(stringDate);
        return date;
    }
}
