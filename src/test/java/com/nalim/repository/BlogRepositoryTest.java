package com.nalim.repository;

import com.nalim.model.Blog;
import com.nalim.model.Member;
import com.nalim.model.Role;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Commit
@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogRepositoryTest {

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
        member.setName("유저");

        memberRepo.save(member);

        Blog blog = new Blog();
        blog.setMember(memberRepo.findById(1L).get());
        blog.setDescription("블로그의 블로그입니다");
        blog.setName("태그도 입력되라");

        blogRepo.save(blog);


    }



}