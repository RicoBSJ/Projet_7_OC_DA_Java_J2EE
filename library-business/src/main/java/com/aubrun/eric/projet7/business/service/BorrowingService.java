package com.aubrun.eric.projet7.business.service;

import com.aubrun.eric.projet7.beans.Book;
import com.aubrun.eric.projet7.beans.Borrowing;
import com.aubrun.eric.projet7.beans.UserAccount;
import com.aubrun.eric.projet7.business.dto.BookDto;
import com.aubrun.eric.projet7.business.dto.BorrowingDto;
import com.aubrun.eric.projet7.business.dto.UserAccountDto;
import com.aubrun.eric.projet7.business.mapper.BorrowingDtoMapper;
import com.aubrun.eric.projet7.consumer.repository.BookRepository;
import com.aubrun.eric.projet7.consumer.repository.BorrowingRepository;
import com.aubrun.eric.projet7.consumer.repository.UserAccountRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class BorrowingService {

    private final BorrowingRepository borrowingRepository;
    private final BookRepository bookRepository;
    private final UserAccountRepository userAccountRepository;

    public BorrowingService(BorrowingRepository borrowingRepository, BookRepository bookRepository, UserAccountRepository userAccountRepository) {
        this.borrowingRepository = borrowingRepository;
        this.bookRepository = bookRepository;
        this.userAccountRepository = userAccountRepository;
    }


    public List<BorrowingDto> findAll(Principal principal) {
        UserAccount userAccount = userAccountRepository.findByUsername(principal.getName()).orElseThrow(RuntimeException::new);
        return borrowingRepository.findAllUserBorrowing(userAccount).stream().map(BorrowingDtoMapper::toDto).collect(Collectors.toList());
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
        Borrowing borrowing = borrowingRepository.findById(borrowingId).orElseThrow(()->new RuntimeException("La période de rallonge d'emprunt a déjà été effectuée"));
        borrowing.setEndDate(borrowing.getEndDate().plusWeeks(4));
        borrowing.setRenewal(true);
        borrowingRepository.save(borrowing);
    }

    public void delete(Integer borrowingId) {

        borrowingRepository.deleteById(borrowingId);
    }

    public List<BorrowingDto> findLateBorrowingDate(Principal principal){
        UserAccount userAccount = userAccountRepository.findByUsername(principal.getName()).orElseThrow(RuntimeException::new);
        return borrowingRepository.findBorrowingByEndDateAndUserAccountBorrowing(userAccount).stream().map(BorrowingDtoMapper::toDto).collect(Collectors.toList());
    }
}
