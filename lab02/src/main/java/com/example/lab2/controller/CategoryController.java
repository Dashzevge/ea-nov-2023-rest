package com.example.lab2.controller;

import com.example.lab2.entity.Category;
import com.example.lab2.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<Category> findAll() {
        return this.categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Category> findById(@PathVariable int id) {
        return this.categoryService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Category category) {
        this.categoryService.addAndUpdateCategory(category);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        this.categoryService.deleteCategoryById(id);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Category category) {
        this.categoryService.addAndUpdateCategory(category);
    }

}
