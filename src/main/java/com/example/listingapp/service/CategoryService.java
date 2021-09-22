package com.example.listingapp.service;

import com.example.listingapp.model.Category;
import com.example.listingapp.model.User;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    Category getCategoryById(int id);

    Category addCategory(Category category);

    Category putCategory(int id, String name);

    void deleteCategoryById(int id);
}
