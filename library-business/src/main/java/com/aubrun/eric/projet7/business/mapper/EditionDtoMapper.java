package com.aubrun.eric.projet7.business.mapper;

import com.aubrun.eric.projet7.beans.Edition;
import com.aubrun.eric.projet7.business.dto.EditionDto;

public class EditionDtoMapper {

    static public EditionDto toDto(Edition edition) {

        EditionDto dto = new EditionDto();
        dto.setEditionId(edition.getEditionId());
        dto.setNameEdition(edition.getNameEdition());
        return dto;
    }

    static public Edition toEntity(EditionDto editionDto) {

        Edition entity = new Edition();
        entity.setEditionId(editionDto.getEditionId());
        entity.setNameEdition(editionDto.getNameEdition());
        return entity;
    }
}
