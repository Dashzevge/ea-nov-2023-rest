package com.example.lab2.service;

import com.example.lab2.entity.Category;
import com.example.lab2.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> findAll(){
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList;
    }
    @Transactional
    public Optional<Category> findById(int id){
        return categoryRepository.findById(id);
    }
    public void addAndUpdateCategory(Category user){
        categoryRepository.save(user);
    }

    public void deleteCategoryById(int id){
        categoryRepository.deleteById(id);
    }
}
