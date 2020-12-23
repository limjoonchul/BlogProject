package com.nalim;

import com.nalim.model.Blog;
import com.nalim.model.Category;
import com.nalim.model.Member;
import com.nalim.model.Post;
import com.nalim.repository.BlogRepository;
import com.nalim.repository.CategoryRepository;
import com.nalim.repository.MemberRepository;
import com.nalim.repository.PostRepository;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


//@RunWith(SpringRunner.class)
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
    public void insertTest() {
//        Post post = new Post();
//        post.setTitle("포스트테스트");
//        post.setContent("포스트내용테스트");

//        Blog blog = new Blog();
//        blog.setName("블로그테스트");
//        blog.setDescription("블로그설명테스트");

//        Optional<Blog> findBlog = blogRepository.findById(2L);
//        if (findBlog.isPresent()) {
//            Blog blog = findBlog.get();
//            post.setBlog(blog);
//        }
//
//        Optional<Category> findCategory = categoryRepository.findById(1L);
//        if (findCategory.isPresent()) {
//            Category category = findCategory.get();
//            post.setCategory(category);
//        }
//
//        Optional<Member> findMember = memberRepository.findById(1L);
//        if (findCategory.isPresent()) {
//            Member member = findMember.get();
//            post.setMember(member);
//        }
//        postRepository.save(post);


        Post post = new Post();
        post.setTitle("포스트 테스트");
        post.setContent("포스트 내용 테스트");
        postRepository.save(post);

        Post findPost = postRepository.findById(post.getSeq()).get();

        assertThat(post.getTitle()).isEqualTo(findPost.getTitle());
    }

    //    @Test
    public void updateTest() {
//        Optional<Post> findPost = postRepository.findById(13L);
//
//        if (findPost.isPresent()) {
//            Post post = findPost.get();
//            post.setTitle("테스트224455");

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

//            postRepository.save(post);
//        }

        Post post = new Post();
        post.setTitle("포스트 22");
        post.setContent("포스트 내용 22");
        postRepository.save(post);

        Post findPost = postRepository.findById(post.getSeq()).get();
        findPost.setTitle("포스트 33");
        findPost.setContent("포스트 내용 33");
        postRepository.save(findPost);

        Post findPost2 = postRepository.findById(findPost.getSeq()).get();
        assertThat(findPost.getTitle()).isEqualTo(findPost2.getTitle());

    }

    //    @Test
    public void selectTest() {
        Optional<Post> findPost = postRepository.findById(1L);
        if (findPost.isPresent()) {
            System.out.println(findPost.get().getTitle());
            System.out.println(findPost.get().getContent());
        }
    }

    //    @Test
    public void deleteTest() {
        postRepository.deleteById(13L);
    }


    // 테스트 연습
//    @BeforeEach
    public void beforeSetting() {

        for (int i = 0; i < 100; i++) {
            Post post = new Post(); // 새로운 객체를 생성해서 넣어줘야지 update가 아닌 insert 가 발생하겠지?

            post.setTitle("포스트 " + i);
            post.setContent("포스트 내용" + i);
            postRepository.save(post);
        }
    }

//    @Test
    public void findByTitle() {
        Optional<Post> findPost = postRepository.findById(300L);

        if (findPost.isPresent()) {
            List<Post> postList = postRepository.findByTitle(findPost.get().getTitle());
            for (Post post1 : postList) {
                System.out.println(post1.getTitle());
            }
        }
    }

    //    @Test
    public void findByTitleContaining() {
        List<Post> postList = postRepository.findByTitleContaining("0");
        for (Post post : postList) {
            System.out.println(post.getTitle());
            assertThat(post.getTitle()).contains("0");
        }
    }

    @Test
    public void findByMemberName(){
        Post post = postRepository.findById(1L).get();

        List<Post> findUserName = postRepository.findByMemberName(post.getSeq());
        for (Post post1: findUserName) {
            System.out.println(post1.getMember().getName());
            assertThat(post1.getMember().getName()).isEqualTo("멤버");
        }
    }


}
