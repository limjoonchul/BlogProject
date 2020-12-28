package com.nalim.service;

import com.nalim.model.Category;

import java.util.List;

public interface CategoryService {

    void createCategory(Category category);

    void updateCategory(Category category);

    void deleteCategory(Category category);

    List<Category> getCategoryList();
}
