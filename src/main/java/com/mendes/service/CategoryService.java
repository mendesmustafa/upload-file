package com.mendes.service;

import com.mendes.model.entity.Category;
import com.mendes.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by mendesmustafa on 13.03.2021.
 */

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

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

    public Category save(Category model) {
        categoryRepository.save(model);
        return model;
    }

    public List<Category> list() {
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }

    public void save(String name, String subCategoryName) {
        Category category = new Category();
        category.setName(name);
        category.setSubCategoryName(subCategoryName);
        categoryRepository.save(category);
    }
}
