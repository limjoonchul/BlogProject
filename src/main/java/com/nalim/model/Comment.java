package com.nalim.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class Comment {
    @Id @GeneratedValue
    private Long seq;

    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @ManyToOne
    @JoinColumn(name = "Member_seq")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "Post_seq")
    private Post post;
}
