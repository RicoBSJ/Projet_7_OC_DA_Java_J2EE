package com.aubrun.eric.projet7.business.service;

import com.aubrun.eric.projet7.business.dto.EditionDto;
import com.aubrun.eric.projet7.business.mapper.EditionDtoMapper;
import com.aubrun.eric.projet7.consumer.repository.EditionRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EditionService {

    private final EditionRepository editionRepository;

    public EditionService(EditionRepository editionRepository) {
        this.editionRepository = editionRepository;
    }

    public List<EditionDto> findAll() {

        return editionRepository.findAll().stream().map(EditionDtoMapper::toDto).collect(Collectors.toList());
    }

    public void save(EditionDto newEdition) {

        editionRepository.save(EditionDtoMapper.toEntity(newEdition)).getEditionId();
    }

    public void update(EditionDto newEdition) {

        editionRepository.save(EditionDtoMapper.toEntity(newEdition));
    }

    public EditionDto findById(Integer id) {

        return EditionDtoMapper.toDto(editionRepository.findById(id).get());
    }

    public void delete(Integer id) {

        editionRepository.deleteById(id);
    }
}
