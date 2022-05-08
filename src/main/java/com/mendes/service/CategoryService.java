package com.mendes.service;

import com.mendes.model.dto.CategoryDto;
import com.mendes.model.entity.Category;
import com.mendes.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by mendesmustafa on 13.03.2021.
 */

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category findById(Long id) {
        Category category = null;
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            category = categoryOptional.get();
        }
        return category;
    }

    public CategoryDto getById(Long id) {
        Category category = findById(id);
        return fillCategoryDto(category);
    }

    public CategoryDto save(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setSubCategoryName(categoryDto.getSubCategoryName());
        categoryRepository.save(category);
        categoryDto.setId(category.getId());
        return categoryDto;
    }

    public List<CategoryDto> list() {
        return categoryRepository.findAll().stream().map(this::fillCategoryDto).collect(Collectors.toList());
    }

    private CategoryDto fillCategoryDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setSubCategoryName(category.getSubCategoryName());
        return categoryDto;
    }

    public void save(String name, String subCategoryName) {
        Category category = new Category();
        category.setName(name);
        category.setSubCategoryName(subCategoryName);
        categoryRepository.save(category);
    }
}
