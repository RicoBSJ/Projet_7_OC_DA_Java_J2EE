package com.aubrun.eric.projet7.business.service;

import com.aubrun.eric.projet7.beans.Book;
import com.aubrun.eric.projet7.beans.Borrowing;
import com.aubrun.eric.projet7.beans.UserAccount;
import com.aubrun.eric.projet7.business.dto.BatchDto;
import com.aubrun.eric.projet7.business.dto.BorrowingDto;
import com.aubrun.eric.projet7.business.dto.MailObject;
import com.aubrun.eric.projet7.business.mapper.BorrowingDtoMapper;
import com.aubrun.eric.projet7.consumer.repository.BookRepository;
import com.aubrun.eric.projet7.consumer.repository.BorrowingRepository;
import com.aubrun.eric.projet7.consumer.repository.UserAccountRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

@Service
@Transactional
public class BorrowingService {

    private final BorrowingRepository borrowingRepository;
    private final BookRepository bookRepository;
    private final UserAccountRepository userAccountRepository;
    private final EmailService emailService;

    public BorrowingService(BorrowingRepository borrowingRepository, BookRepository bookRepository, UserAccountRepository userAccountRepository, EmailService emailService) {
        this.borrowingRepository = borrowingRepository;
        this.bookRepository = bookRepository;
        this.userAccountRepository = userAccountRepository;
        this.emailService = emailService;
    }


    public List<BorrowingDto> findAll(Principal principal) {
        UserAccount userAccount = userAccountRepository.findByUsername(principal.getName()).orElseThrow(RuntimeException::new);
        return borrowingRepository.findAllUserBorrowing(userAccount).stream().map(BorrowingDtoMapper::toDto).collect(toList());
    }

    public BorrowingDto findById(int borrowingId) {

        return BorrowingDtoMapper.toDto(borrowingRepository.findById(borrowingId).get());
    }

    public void save(int bookId, String userName) {
        UserAccount userAccount = userAccountRepository.findByUsername(userName).get();
        Book book = bookRepository.findBookByBookId(bookId).get();
        Borrowing borrowing = new Borrowing();
        borrowing.setUserAccountBorrowing(userAccount);
        borrowing.setBookBorrowing(book);
        borrowing.setBeginDate(LocalDate.now());
        borrowing.setEndDate(LocalDate.now().plusWeeks(4));
        borrowing.setRenewal(false);
        book.setQuantity(book.getQuantity() - 1);
        borrowingRepository.save(borrowing);
        bookRepository.save(book);
    }

    public void update(Integer borrowingId) {
        Borrowing borrowing = borrowingRepository.findById(borrowingId).orElseThrow(() -> new RuntimeException("La période de rallonge d'emprunt a déjà été effectuée"));
        borrowing.setEndDate(borrowing.getEndDate().plusWeeks(4));
        borrowing.setRenewal(true);
        borrowingRepository.save(borrowing);
    }

    public void delete(Integer borrowingId) {

        borrowingRepository.deleteById(borrowingId);
    }

    public List<BatchDto> findLateBorrowingDate() {
        List<Borrowing> list = borrowingRepository.findBorrowingByEndDateAndUserAccountBorrowing(LocalDate.now());
        HashMap<UserAccount, List<Borrowing>> map = list.stream().collect(groupingBy(Borrowing::getUserAccountBorrowing, HashMap::new, toList()));
        return map.entrySet().stream().map(this::mapBatchDto).collect(toList());
    }

    private BatchDto mapBatchDto(Map.Entry<UserAccount, List<Borrowing>> entry) {
        BatchDto batchDto = new BatchDto();
        batchDto.setUsername(entry.getKey().getUsername());
        batchDto.setEmail(entry.getKey().getEmail());
        batchDto.setBorrowings(entry.getValue().stream().map(BorrowingDtoMapper::toDto).collect(toList()));
        return batchDto;
    }

    public void sendMail(BatchDto batchDto) {
        String text = "Bonjour, \n" +
                "N'oubliez pas de rendre les emprunts suivants : \n" +
                batchDto.getBorrowings().stream().
                        map(b -> b.getBookBorrowing().getTitle() + " " + b.getBookBorrowing().getBookAuthor().getFirstName() + " " + b.getBookBorrowing().getBookAuthor().getLastName())
                        .reduce((a, b) -> a + "\n" + b).orElseGet(() -> "")+
                "\nCordialement";
        MailObject mailObject = new MailObject();
        mailObject.setTo(batchDto.getEmail());
        mailObject.setSubject("Your loan is late");
        mailObject.setText(text);
        emailService.sendSimpleMessage(mailObject);
    }
}
