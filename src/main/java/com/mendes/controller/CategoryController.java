package com.mendes.controller;

import com.mendes.model.dto.CategoryDto;
import com.mendes.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by mendesmustafa on 13.03.2021.
 */

@Controller
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("categories", categoryService.list());
        return "category-list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("category", categoryService.getById(id));
        return "category-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("category") CategoryDto categoryDto) {
        categoryService.save(categoryDto);
        return "redirect:/category/list";
    }
}
