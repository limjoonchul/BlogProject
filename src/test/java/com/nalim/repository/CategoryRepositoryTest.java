package com.nalim.repository;

import com.nalim.model.Category;
import com.nalim.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;


    @Test
    public void saveCategory() throws IOException {
        Category category = new Category();

        category.setName("test1");
        category.setDescription("가나다라마바사");
        category.setShowType("타이틀");

        categoryRepository.save(category);
        Optional<Category> findCategory =  categoryRepository.findById(category.getSeq());
        if (findCategory.isPresent()){
            assertThat(findCategory.get().getName()).isEqualTo("test1");
        }

    }


}
