package com.nalim.repository;

import com.nalim.model.Blog;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BlogRepository extends CrudRepository<Blog, Long> {

    List<Blog> findBlogByNameContaining(String name);

    List<Blog> findBlogByMember_Id(String member_id);

    Optional<Blog> findByName(String name);

    List<Blog> findBlogByTagContaining(String tag);

}
