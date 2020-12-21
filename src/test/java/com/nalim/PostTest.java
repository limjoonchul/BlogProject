package com.nalim;

import com.nalim.model.Blog;
import com.nalim.model.Category;
import com.nalim.model.Member;
import com.nalim.model.Post;
import com.nalim.repository.BlogRepository;
import com.nalim.repository.CategoryRepository;
import com.nalim.repository.MemberRepository;
import com.nalim.repository.PostRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostTest {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BlogRepository blogRepository;

//    @Test
    public void insertTest(){
        Post post = new Post();
        post.setTitle("포스트테스트");
        post.setContent("포스트내용테스트");

//        Blog blog = new Blog();
//        blog.setName("블로그테스트");
//        blog.setDescription("블로그설명테스트");

        Optional<Blog> findBlog = blogRepository.findById(2L);
        if (findBlog.isPresent()){
            Blog blog = findBlog.get();
            post.setBlog(blog);
        }

        Optional<Category> findCategory = categoryRepository.findById(1L);
        if (findCategory.isPresent()){
            Category category = findCategory.get();
            post.setCategory(category);
        }

        Optional<Member> findMember =  memberRepository.findById(1L);
        if (findCategory.isPresent()){
            Member member = findMember.get();
            post.setMember(member);
        }
        postRepository.save(post);
    }

//    @Test
    public void updateTest(){
        Optional<Post> findPost = postRepository.findById(13L);

        if (findPost.isPresent()){
            Post post = findPost.get();
            post.setTitle("테스트224455");

            // caseCade를 해야지 가능하지?
//            Member member = post.getMember();
//            member.setName("테스트테스트");
//            post.setMember(member);
//
//            Category category = post.getCategory();
//            category.setName("테스트테스트");
//            post.setCategory(category);
//
//            Blog blog = post.getBlog();
//            blog.setName("테스트테스트");
//            post.setBlog(blog);

            postRepository.save(post);
        }

    }

    @Test
    public void selectTest(){
        Optional<Post> findPost = postRepository.findById(1L);
        if (findPost.isPresent()){
            System.out.println(findPost.get().getTitle());
            System.out.println(findPost.get().getContent());
        }
    }

//    @Test
    public void deleteTest(){
        postRepository.deleteById(13L);
    }
}
