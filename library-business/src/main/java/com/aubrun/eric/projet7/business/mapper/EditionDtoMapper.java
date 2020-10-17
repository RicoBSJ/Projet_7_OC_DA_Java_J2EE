package com.aubrun.eric.projet7.business.mapper;

import com.aubrun.eric.projet7.beans.Edition;
import com.aubrun.eric.projet7.business.dto.EditionDto;

import java.util.stream.Collectors;

public class EditionDtoMapper {

    static public EditionDto toDto(Edition edition) {

        EditionDto dto = new EditionDto();
        dto.setEditionId(edition.getEditionId());
        dto.setNameEdition(edition.getNameEdition());
        dto.setBookList(edition.getBookList().stream().map(BookDtoMapper::toDto).collect(Collectors.toList()));
        return dto;
    }

    static public Edition toEntity(EditionDto editionDto) {

        Edition entity = new Edition();
        entity.setEditionId(editionDto.getEditionId());
        entity.setNameEdition(editionDto.getNameEdition());
        entity.setBookList(editionDto.getBookList().stream().map(BookDtoMapper::toEntity).collect(Collectors.toList()));
        return entity;
    }
}
