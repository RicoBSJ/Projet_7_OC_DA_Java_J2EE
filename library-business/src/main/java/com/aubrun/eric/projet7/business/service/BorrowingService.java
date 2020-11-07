package com.aubrun.eric.projet7.business.service;

import com.aubrun.eric.projet7.business.dto.BorrowingDto;
import com.aubrun.eric.projet7.business.mapper.BorrowingDtoMapper;
import com.aubrun.eric.projet7.consumer.repository.BorrowingRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
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

    public void createBorrowing(BorrowingDto borrowingDto){

        Integer quantityBook = borrowingDto.getBookBorrowing().getQuantity();
        String noBorrowingMessage = "L'ouvrage que vous souhaitez emprunter n'est pas disponible";
        Integer idBook = borrowingDto.getBookBorrowing().getBookId();
        Integer idUserAccount = borrowingDto.getUserAccountBorrowing().getUserId();
        List<BorrowingDto> userAccountBookList = borrowingDto.getUserAccountBorrowing().getBorrowingDtoList();

        if(quantityBook < 1){
            borrowingRepository.deleteById(borrowingDto.getBorrowingId());
            System.out.println(noBorrowingMessage);
        }

        quantityBook--;
        /*userAccountBookList.add();*/

        createBorrowing(borrowingDto);
    }
}
