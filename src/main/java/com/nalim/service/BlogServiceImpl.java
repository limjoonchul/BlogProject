package com.nalim.service;

import com.nalim.model.Blog;
import com.nalim.repository.BlogRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepo;

    @Override
    public Blog createBlog(Blog blog) {
        if(blog.getName() != null){
            if (!isBlogNameExist(blog.getName())) {
                blogRepo.save(blog);
                return blog;
            }
        }
        return null;

    }

    private boolean isBlogNameExist(String name){
        return blogRepo.findByName(name).isPresent();
    }

    @Override
    public Blog updateBlog(Blog blog) {
        if(blog.getName() != null){
            Optional<Blog> findBlog = blogRepo.findById(blog.getSeq());
            if(findBlog.isPresent()) {
                Blog updateBlog = findBlog.get();
                updateBlog.setName(blog.getName());
                updateBlog.setTag(blog.getTag());
                updateBlog.setLogo(blog.getLogo());
                updateBlog.setCntPost(blog.getCntPost());
                return blogRepo.save(updateBlog);
            }
        }
        return null;
    }

    @Override
    public void deleteBlog(Blog blog) {

        blogRepo.delete(blog);

    }

    @Override
    public Blog getBlog(Blog blog) {
        Optional<Blog> findBlog = blogRepo.findById(blog.getSeq());
        return findBlog.orElse(null);
    }

    @Override
    public List<Blog> getBlogList(String searchCondition, String searchKeyword) {
        if (searchCondition.equals("블로그 제목")) {
            return blogRepo.findBlogByNameContaining(searchKeyword);
        } else if (searchCondition.equals("태그")) {
            return blogRepo.findBlogByTagContaining(searchCondition);
        } else {
            return blogRepo.findBlogByMember_Id(searchKeyword);
        }
    }
}
