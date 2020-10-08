package com.aubrun.eric.projet7.business.mapper;

import com.aubrun.eric.projet7.beans.Category;
import com.aubrun.eric.projet7.business.dto.CategoryDto;

public class CategoryDtoMapper {

    static public CategoryDto toDto(Category category) {

        CategoryDto dto = new CategoryDto();
        dto.setCategoryId(category.getCategoryId());
        dto.setNameCategory(category.getNameCategory());
        return dto;
    }

    static public Category toEntity(CategoryDto categoryDto) {

        Category entity = new Category();
        entity.setCategoryId(categoryDto.getCategoryId());
        entity.setNameCategory(categoryDto.getNameCategory());
        return entity;
    }
}
