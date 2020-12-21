package com.nalim.repository;

import com.nalim.model.Member;
import com.nalim.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
    // title,
}
