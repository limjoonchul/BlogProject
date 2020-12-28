package com.nalim.service;

import com.nalim.model.Blog;

import java.util.List;

public interface BlogService {

    Blog createBlog(Blog blog);

    Blog updateBlog(Blog blog);

    void deleteBlog(Blog blog);

    Blog getBlog(Blog blog);

    List<Blog> getBlogList(String searchCondition, String searchKeyword);


}
