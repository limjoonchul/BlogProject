package com.nalim.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Post {

    @Id @GeneratedValue
    private Long seq;

    @Column(nullable = false, columnDefinition = "varchar(50)")
    private String title;

    @Column(nullable = false, columnDefinition = "text")
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date creaDate;

    @ManyToOne
    @JoinColumn(name = "Member_seq")
    private Member member;

    @OneToMany
    private List<Category> categoryList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "Blog_seq")
    private Blog blog;

    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER)  // comment에서 post를 참조하는 필드명
    List<Comment> commentList = new ArrayList<>();

}
