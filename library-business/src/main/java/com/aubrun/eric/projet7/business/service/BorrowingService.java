package com.aubrun.eric.projet7.business.service;

import com.aubrun.eric.projet7.beans.Borrowing;
import com.aubrun.eric.projet7.business.dto.BorrowingDto;
import com.aubrun.eric.projet7.business.mapper.BorrowingDtoMapper;
import com.aubrun.eric.projet7.consumer.repository.BorrowingRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class BorrowingService {

    private final BorrowingRepository borrowingRepository;

    public BorrowingService(BorrowingRepository borrowingRepository) {
        this.borrowingRepository = borrowingRepository;
    }


    public List<BorrowingDto> findAll() {

        return borrowingRepository.findAll().stream().map(BorrowingDtoMapper::toDto).collect(Collectors.toList());
    }

    public BorrowingDto findById(int borrowingId) {

        return BorrowingDtoMapper.toDto(borrowingRepository.findById(borrowingId).get());
    }

    public int save(BorrowingDto newBorrowing) {

        return borrowingRepository.save(BorrowingDtoMapper.toEntity(newBorrowing)).getBorrowingId();
    }

    public BorrowingDto update(BorrowingDto borrowingDto) {

        return BorrowingDtoMapper.toDto(borrowingRepository.save(BorrowingDtoMapper.toEntity(borrowingDto)));
    }

    public void delete(Integer borrowingId) {

        borrowingRepository.deleteById(borrowingId);
    }
}
