package com.nalim.repository;

import com.nalim.model.Blog;
import com.nalim.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
