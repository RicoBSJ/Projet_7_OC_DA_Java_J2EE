package com.aubrun.eric.projet7.business.service;

import com.aubrun.eric.projet7.beans.Category;
import com.aubrun.eric.projet7.business.dto.CategoryDto;
import com.aubrun.eric.projet7.business.mapper.CategoryDtoMapper;
import com.aubrun.eric.projet7.consumer.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDto> findAll() {

        List<CategoryDto> dtos = new ArrayList<>();
        List<Category> categorys = new ArrayList<>();
        for(Category a : categorys){
            CategoryDto dto = CategoryDtoMapper.toDto(a);
            dtos.add(dto);
        }
        return dtos;
        /*return categoryRepository.findAll().stream().map(CategoryDtoMapper::toDto).collect(Collectors.toList());*/
    }

    public void saveOrUpdate(CategoryDto newCategory) {

        categoryRepository.save(CategoryDtoMapper.toEntity(newCategory));
    }

    public CategoryDto findById(Integer id) {

        return CategoryDtoMapper.toDto(categoryRepository.findById(id).get());
    }

    public void delete(Integer id) {

        Category category = categoryRepository.findById(id).get();
        categoryRepository.delete(category);
    }
}
