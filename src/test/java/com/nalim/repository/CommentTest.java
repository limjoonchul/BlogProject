package com.nalim.repository;

import com.nalim.model.Comment;
import com.nalim.model.Member;
import com.nalim.model.Post;
import com.nalim.repository.CommentRepository;
import com.nalim.repository.MemberRepository;
import com.nalim.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class CommentTest {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PostRepository postRepository;

//    @Test
    public void insertTest(){

        Comment comment = new Comment();
        comment.setContent("가나다라마바사");

//        Member member = new Member();
//        member.setId("member1");
//        member.setPassword("member1");
//        member.setName("멤버");
//        member.setRole(Role.ROLE_MEMBER);

        Optional<Member> findMember = memberRepository.findById(1L);
        if (findMember.isPresent()){
            Member member = findMember.get();
            comment.setMember(member);
        }

//        Post post = new Post();
//        post.setTitle("포스트");
//        post.setContent("포스트 내용");

        Optional<Post> findPost = postRepository.findById(1L);

        if (findPost.isPresent()){
            Post post = findPost.get();
            comment.setPost(post);
        }
        commentRepository.save(comment);

    }

//    @Test
    public void selectTest(){
        Optional<Comment> findComment = commentRepository.findById(1L);
        if (findComment.isPresent()){
            Comment comment = findComment.get();
            System.out.println(comment.getContent());
            System.out.println(comment.getCreateDate());
            System.out.println(comment.getMember().getName());
            System.out.println(comment.getPost().getTitle());
        }
    }

    @Test
    public void updateTest(){
        Optional<Comment> findComment = commentRepository.findById(14L);
        if (findComment.isPresent()){
            Comment comment = findComment.get();
            comment.setContent("아야오요우유으이");
            Member member = comment.getMember();
            member.setName("멤버이름변경");
            comment.setMember(member);
            commentRepository.save(comment);
        }
    }

//    @Test
    public void deleteTest(){
        commentRepository.deleteById(11L);
    }
}
