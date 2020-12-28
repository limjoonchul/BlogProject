package com.nalim.service;

import com.nalim.model.Comment;
import com.nalim.model.Member;
import com.nalim.model.Post;
import com.nalim.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;

    @Override
    public Comment saveComment(Comment comment, Member member, Post post) {
        comment.setMember(member);
        comment.setPost(post);

        commentRepository.save(comment);
        return comment;
    }

    @Override
    public Comment updateComment(Comment comment) {
        Optional<Comment> findComment = commentRepository.findById(comment.getSeq());
        if (findComment.isPresent()){
            Comment updateComment = findComment.get();
            updateComment.setContent(comment.getContent());
            commentRepository.save(updateComment);
            return updateComment;
        }
        return null;
    }

    @Override
    public void deleteComment(Comment comment) {
        commentRepository.deleteById(comment.getSeq());
    }
}
