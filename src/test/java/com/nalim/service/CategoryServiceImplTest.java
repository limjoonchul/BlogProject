package com.nalim.service;

import com.nalim.model.Category;
import com.nalim.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryServiceImplTest {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;


//    @BeforeEach
    public void beforeSetting(){
        for (int i = 1; i <= 100; i++) {
            Category category = new Category();
            category.setName("자바" + i);
            category.setShowType("타이틀" + i);
            category.setDescription("자바 is ..." + i);
            categoryService.createCategory(category);
        }

    }


//    @Test
    public void createTest(){
        Category category = new Category();
        category.setName("자바");
        category.setShowType("타이틀");
        category.setDescription("자바 is ...");

        categoryService.createCategory(category);
        Optional<Category> findCategory = categoryRepository.findById(category.getSeq());

        if (findCategory.isPresent()){
            assertThat(category.getName()).isEqualTo(findCategory.get().getName());
        }
    }

//    @Test
    public void updateTest(){
        Category category = new Category();
        category.setSeq(1L);
        category.setName("자바22");
        category.setShowType("타이틀22");
        category.setDescription("자바 is ...222");

        categoryService.updateCategory(category);

        Optional<Category> findCategory = categoryRepository.findById(category.getSeq());

        if (findCategory.isPresent()){
            assertThat(findCategory.get().getName()).isEqualTo("자바22");
        }
    }
//    @Test
    public void deleteTest(){
        Category category = new Category();
        category.setSeq(3L);

        categoryService.deleteCategory(category);

        Optional<Category> findCategory = categoryRepository.findById(category.getSeq());

        assertThat(findCategory.isPresent()).isFalse();
    }

    @Test
    public void getCategory(){
        List<Category> categoryList = categoryService.getCategoryList();
        assertThat(categoryList.size()).isGreaterThan(96);
    }

}