package com.nalim.service;

import com.nalim.model.Category;
import com.nalim.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryServiceImplTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void createTest(){
        Category category = new Category();
        category.setName("자바");
        category.setShowType("타이틀");
        category.setDescription("자바 is ...");

        categoryService.createCategory(category);
    }

}