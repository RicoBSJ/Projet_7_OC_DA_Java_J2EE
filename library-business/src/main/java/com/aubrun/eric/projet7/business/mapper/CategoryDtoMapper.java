package com.aubrun.eric.projet7.business.mapper;

import com.aubrun.eric.projet7.beans.Category;
import com.aubrun.eric.projet7.business.dto.CategoryDto;

public class CategoryDtoMapper {

    static public CategoryDto toDto(Category category) {

        CategoryDto dto = new CategoryDto();
        dto.setId(category.getId());
        dto.setName(category.getName());
        return dto;
    }

    static public Category toEntity(CategoryDto categoryDto) {

        Category entity = new Category();
        entity.setId(categoryDto.getId());
        entity.setName(categoryDto.getName());
        return entity;
    }
}
