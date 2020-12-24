package com.nalim.service;

import com.nalim.model.Category;
import com.nalim.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void updateCategory(Category category) {
        Optional<Category> findCategory = categoryRepository.findById(category.getSeq());
        if (findCategory.isPresent()){
            Category category1 = findCategory.get();
            category1.setName(category.getName());
            category1.setDescription(category.getDescription());
            category1.setShowType(category.getShowType());
            categoryRepository.save(category1);
        }
    }

    @Override
    public void deleteCategory(Category category) {
        categoryRepository.deleteById(category.getSeq());
    }

    @Override
    public List<Category> getCategoryList() {
        return categoryRepository.findAll();
    }
}
