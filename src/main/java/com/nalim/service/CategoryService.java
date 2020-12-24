package com.nalim.service;

import com.nalim.model.Category;

public interface CategoryService {

    void createCategory(Category category);

    void updateCategory(Category category);

    void deleteCategory(Category category);

    void getCategoryList();
}
