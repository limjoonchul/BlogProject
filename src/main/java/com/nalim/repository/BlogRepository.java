package com.nalim.repository;

import com.nalim.model.Blog;
import lombok.extern.java.Log;
import org.springframework.data.repository.CrudRepository;

public interface BlogRepository extends CrudRepository<Blog, Long> {
}
