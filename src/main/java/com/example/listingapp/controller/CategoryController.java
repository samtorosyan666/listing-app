package com.example.listingapp.controller;

import com.example.listingapp.model.Category;
import com.example.listingapp.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> getAllCategories(){
       return categoryService.getAllCategories();
    }

    @GetMapping("/categories/{id}")
    public Category getCategoryById(@PathVariable("id") int id){
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/categories")
    public Category addCategory(@RequestBody Category category){
        return categoryService.addCategory(category);
    }

    @PutMapping("/categories/{id}")
    public Category putCategory(@PathVariable int id , @RequestBody String name) {
        return categoryService.putCategory(id, name);

    }

    @DeleteMapping("/categories/{id}")
    public void deleteCategory(@PathVariable int id) {
        categoryService.deleteCategoryById(id);
    }

}
