package com.aubrun.eric.projet7.business.service;

import com.aubrun.eric.projet7.beans.Book;
import com.aubrun.eric.projet7.beans.Borrowing;
import com.aubrun.eric.projet7.business.dto.BorrowingDto;
import com.aubrun.eric.projet7.business.mapper.BorrowingDtoMapper;
import com.aubrun.eric.projet7.consumer.repository.BookRepository;
import com.aubrun.eric.projet7.consumer.repository.BorrowingRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BorrowingService {

    private final BorrowingRepository borrowingRepository;
    private final BookRepository bookRepository;

    public BorrowingService(BorrowingRepository borrowingRepository, BookRepository bookRepository) {
        this.borrowingRepository = borrowingRepository;
        this.bookRepository = bookRepository;
    }


    public List<BorrowingDto> findAll() {

        return borrowingRepository.findAll().stream().map(BorrowingDtoMapper::toDto).collect(Collectors.toList());
    }

    public BorrowingDto findById(int borrowingId) {

        return BorrowingDtoMapper.toDto(borrowingRepository.findById(borrowingId).get());
    }

    public int save(BorrowingDto newBorrowing) {
        Borrowing borrowing = BorrowingDtoMapper.toEntity(newBorrowing);
        Book book = bookRepository.findById(newBorrowing.getBookBorrowing().getBookId()).orElseThrow(() -> new RuntimeException("L'ouvrage que vous souhaitez emprunter n'est pas disponible"));
        borrowing.setBookBorrowing(book);
        borrowing.setBeginDate(LocalDate.now());
        borrowing.setEndDate(LocalDate.now().plusWeeks(4));
        borrowing.setRenewal(true);
        book.setQuantity(book.getQuantity() - 1);
        return borrowingRepository.save(borrowing).getBorrowingId();
    }

    public void update(Integer borrowingId) {
        Borrowing borrowing = borrowingRepository.findById(borrowingId).orElseThrow(()->new RuntimeException("La période de rallonge d'emprunt a déjà été effectuée"));
        borrowing.setEndDate(borrowing.getEndDate().plusWeeks(4));
        borrowingRepository.save(borrowing);
    }

    public void delete(Integer borrowingId) {

        borrowingRepository.deleteById(borrowingId);
    }
}
