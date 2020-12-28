package com.nalim.repository;

import com.nalim.model.Blog;
import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BlogRepository extends CrudRepository<Blog, Long> {

    public List<Blog> findBlogByNameContaining(String name);

    public Optional<Blog> findBlogByMember_Id(String member_id);

    public Optional<Blog> findByName(String name);

    public List<Blog> findBlogByTagContaining(String tag);


}
