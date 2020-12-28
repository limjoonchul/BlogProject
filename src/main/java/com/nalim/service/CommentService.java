package com.nalim.service;

import com.nalim.model.Comment;
import com.nalim.model.Member;
import com.nalim.model.Post;

public interface CommentService {

    Comment saveComment(Comment comment, Member member, Post post);
    Comment updateComment(Comment comment);
    void deleteComment(Comment comment);

}
