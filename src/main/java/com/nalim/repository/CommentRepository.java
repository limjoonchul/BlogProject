package com.nalim.repository;

import com.nalim.model.Blog;
import com.nalim.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
