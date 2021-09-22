package com.example.listingapp.service.impl;

import com.example.listingapp.model.Category;
import com.example.listingapp.repository.CategoryRepository;
import com.example.listingapp.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;


    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(int id) {
        return categoryRepository.getById(id);
    }

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category putCategory(int id, String name) {
        Category byId = getCategoryById(id);
        byId.setName(name);
        return categoryRepository.save(byId);
    }

    @Override
    public void deleteCategoryById(int id) {
     categoryRepository.deleteById(id);
    }
}
