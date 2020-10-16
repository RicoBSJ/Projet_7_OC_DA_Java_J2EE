package com.aubrun.eric.projet7.controllers;

import com.aubrun.eric.projet7.business.dto.CategoryDto;
import com.aubrun.eric.projet7.business.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/")
    public List<CategoryDto> getAllCategorys() {
        return this.categoryService.findAll();
    }

    @GetMapping("/{id}")
    public CategoryDto getCategoryById(@PathVariable(value = "id") int categoryId) {
        return this.categoryService.findById(categoryId);
    }

    @PostMapping("/")
    public int createCategory(@RequestBody CategoryDto categoryDto) {
        categoryService.save(categoryDto);
        return categoryDto.getCategoryId();
    }

    @PutMapping("/category")
    public CategoryDto updateCategory(@RequestBody CategoryDto categoryDto) {
        categoryService.update(categoryDto);
        return categoryDto;
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") int categoryId) {
        categoryService.delete(categoryId);
    }
}
