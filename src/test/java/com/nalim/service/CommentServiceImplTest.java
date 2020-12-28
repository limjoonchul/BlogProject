package com.nalim.service;

import com.nalim.model.Comment;
import com.nalim.model.Member;
import com.nalim.model.Post;
import com.nalim.repository.CommentRepository;
import com.nalim.repository.MemberRepository;
import com.nalim.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentServiceImplTest {

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PostRepository postRepository;

//    @BeforeEach
    public void beforeSetting(){
        Member member = new Member();
        member.setSeq(1L);
        member.setId("member");
        member.setPassword("member");
        member.setName("멤버");
        memberRepository.save(member);

        Post post = new Post();
        post.setSeq(1L);
        post.setTitle("포스트");
        post.setContent("포스트내용");
        postRepository.save(post);
    }


//    @Test
    public void saveTest(){
        Comment comment = new Comment();
        comment.setContent("comment 테스트");

        Member member = new Member();
        member.setSeq(1L);

        Post post = new Post();
        post.setSeq(2L);

        Comment testComment = commentService.saveComment(comment, member, post);

        assertThat(testComment.getContent()).isEqualTo("comment 테스트");

    }

//    @Test
    public void updateTest(){
        Comment comment = new Comment();
        comment.setSeq(3L);
        comment.setContent("업데이트커멘드");
        Comment updateComment = commentService.updateComment(comment);
        if (updateComment != null){
            assertThat(updateComment.getContent()).isEqualTo("업데이트커멘드");
        } else {
            assertThatNullPointerException();
        }
    }

    @Test
    public void deleteTest(){
        Comment comment = new Comment();
        comment.setSeq(4L);
        commentService.deleteComment(comment);

        Optional<Comment> findComment = commentRepository.findById(comment.getSeq());
        assertThat(findComment.isPresent()).isFalse();
    }

}