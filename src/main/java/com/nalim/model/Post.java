package com.nalim.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    private LocalDateTime createDate;

    @ManyToOne
    @JoinColumn(name = "Member_seq")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "Category_seq")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "Blog_seq")
    private Blog blog;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)  // comment에서 post를 참조하는 필드명
    List<Comment> commentList = new ArrayList<>();

}
