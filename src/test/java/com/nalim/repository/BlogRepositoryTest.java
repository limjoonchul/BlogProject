package com.nalim.repository;

import com.nalim.model.Blog;
import com.nalim.model.Member;
import com.nalim.model.Role;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BlogRepositoryTest {

    @Autowired
    BlogRepository blogRepo;

    @Autowired
    MemberRepository memberRepo;

    @Test
    public void saveBlog() {
        Member member = new Member();
        member.setId("user");
        member.setRole(Role.ROLE_MEMBER);
        member.setPassword("user");
        member.setName("유저네임");
        memberRepo.save(member);

        Blog blog = new Blog();
        blog.setMember(memberRepo.findById(1L).get());
        blog.setDescription("블로그의 블로그입니다");
        blog.setName("태그도 입력되라");


        blogRepo.save(blog);

        assertThat(blogRepo.findById(2L).get().getTag()).isEqualTo("태그없음");

    }


    @Test
    public void findByName() {

        Member member = new Member();
        member.setId("findName");
        member.setRole(Role.ROLE_MEMBER);
        member.setPassword("user");
        member.setName("유저네임");
        memberRepo.save(member);

        for (int i = 0; i < 10 ; i++) {
            Blog blog = new Blog();
//            blog.setMember(memberRepo.findById(1L).get());
            blog.setDescription("블로그입니다");
            blog.setName("findByName"+i);
            blogRepo.save(blog);
        }

        List<Blog> findList = blogRepo.findBlogByNameContaining("findByName");


        assertThat(findList.size()).isEqualTo(10);

    }
}