package com.aubrun.eric.projet7.controllers;

import com.aubrun.eric.projet7.business.dto.CategoryDto;
import com.aubrun.eric.projet7.business.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorys")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/")
    public List<CategoryDto> getAllCategorys(){
        return this.categoryService.findAll();
    }

    @GetMapping("/{id}")
    public CategoryDto getCategoryById(@PathVariable(value = "id") int categoryId){
        return this.categoryService.findById(categoryId);
    }

    @PostMapping(name = "/", consumes = "application/json", produces = "application/json")
    public void createCategory(@RequestBody CategoryDto categoryDto){
        categoryService.saveOrUpdate(categoryDto);
    }

    @PutMapping("/{id}")
    public void updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable("id") int categoryId){
        CategoryDto existingCategory = categoryService.findById(categoryId);
        existingCategory.setName(categoryDto.getName());
        categoryService.saveOrUpdate(existingCategory);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") int categoryId){
        CategoryDto existingCategory = categoryService.findById(categoryId);
        categoryService.delete(existingCategory.getId());
    }
}
