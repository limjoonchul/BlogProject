package com.nalim.repository;

import com.nalim.model.Category;
import com.nalim.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;

@SpringBootTest
public class CategoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

//    @Test
    public void insertTest() throws IOException {
        Category category = new Category();

        category.setName("test1");

        File file = new File("C:\\Users\\dlawn\\OneDrive\\바탕 화면\\cat.jpg");

        byte[] picture = new byte[(int) file.length()];

        FileInputStream fileInputStream = new FileInputStream(file);

        fileInputStream.read(picture);
        fileInputStream.close();


        categoryRepository.save(category);
        // assert로 테스트해보기, 전체적으로 테스트해보기

    }

    @Test
    public void selectTest(Category category) throws FileNotFoundException {

//        Optional<Category> findCategory = categoryRepository.findById(category.getSeq());
//        if (findCategory.isPresent()){
//            Category category1 = findCategory.get();
//            category1.getName();
//            byte[] getPicture = category.getLogo();
//
//            FileOutputStream fileOutputStream = new FileOutputStream("cat.png");
//
//
//        }

    }
}
