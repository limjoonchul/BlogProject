package com.nalim.repository;

import com.nalim.model.Blog;
import com.nalim.model.Member;
import com.nalim.model.Role;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BlogRepositoryTest {

    @Autowired
    BlogRepository blogRepo;

    @Autowired
    MemberRepository memberRepo;

    @Test
    public void saveBlog() {
        Member member = new Member();
        member.setId("saveUser");
        member.setRole(Role.ROLE_MEMBER);
        member.setPassword("saveUser");
        member.setName("saveUser");
        memberRepo.save(member);

        Blog blog = new Blog();
        blog.setMember(memberRepo.findMemberByName("saveUser").get());
        blog.setName("블로그입력");

        blogRepo.save(blog);

        assertThat(blogRepo.findByName("블로그입력").get().getTag()).isEqualTo("태그없음");

    }

    @Test
    public void deleteBlog() {
        Member member = new Member();
        member.setId("deleteUser");
        member.setRole(Role.ROLE_MEMBER);
        member.setPassword("user");
        member.setName("deleteUser");
        memberRepo.save(member);

        Blog blog = new Blog();
        blog.setMember(memberRepo.findMemberByName("deleteUser").get());
        blog.setName("블로그삭제");

        blogRepo.save(blog);

        blogRepo.delete(blog);

        assertThat(blogRepo.findByName("블로그삭제").isEmpty()).isEqualTo(true);

    }

    @Test
    public void findByNameContaining() {

        for (long i = 0; i < 5; i++) {

            Member member = new Member();
            member.setId("findByName" + i);
            member.setRole(Role.ROLE_MEMBER);
            member.setPassword("user");
            member.setName("findByName" + i);
            memberRepo.save(member);

            Blog blog = new Blog();
            blog.setMember(memberRepo.findMemberByName("findByName" + i).get());
            blog.setName("findByName" + i);
            blogRepo.save(blog);
        }

        List<Blog> findList = blogRepo.findBlogByNameContaining("findByName");

        assertThat(findList.size()).isEqualTo(5);

    }

    @Test
    public void findBlogByMember_id() {

        Member member = new Member();
        member.setId("user");
        member.setRole(Role.ROLE_MEMBER);
        member.setPassword("user");
        member.setName("findMemberName");
        memberRepo.save(member);

        Blog blog = new Blog();
        blog.setMember(memberRepo.findMemberByName("findMemberName").get());
        blog.setName("블로그");
        blogRepo.save(blog);

        List<Blog> findBlog = blogRepo.findBlogByMember_Id("user");

        assertThat(findBlog.size()).isEqualTo(1);

    }

    @Test
    public void findBlogByName() {

        Blog blog = new Blog();
        blog.setName("찾을블로그");
        blogRepo.save(blog);

        Blog findBlog = blogRepo.findByName("찾을블로그").get();

        assertThat(findBlog.getName()).isEqualTo("찾을블로그");


    }

    @Test
    public void findByTagContaining() {

        for (long i = 0; i < 5; i++) {

            Member member = new Member();
            member.setId("findByTag" + i);
            member.setRole(Role.ROLE_MEMBER);
            member.setPassword("user");
            member.setName("userName" + i);
            memberRepo.save(member);

            Blog blog = new Blog();
            blog.setMember(memberRepo.findMemberByName("userName" + i).get());
            blog.setName("blogName" + i);
            blog.setTag("findByTag" + i);
            blogRepo.save(blog);
        }

        List<Blog> findList = blogRepo.findBlogByTagContaining("tag");

        assertThat(findList.size()).isEqualTo(5);

    }

}














