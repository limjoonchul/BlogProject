package com.nalim.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.type.DateType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

@Setter
@Getter
@Entity
public class Blog {
    @Id @GeneratedValue
    private Long seq;

    @Column(unique = true)
    private String name;

    private String description;

    @Convert(converter = ListToStringConverter.class)
    private List<String> tag;

    @Temporal(TemporalType.DATE)
    private Date createDate;

    @OneToOne
    @JoinColumn(name = "Member_seq")
    private Member member;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
//    @JoinColumn(name = "Post_seq") => OneToMany에서는 JoinColumn을 안해줘도됨
    private List<Post> postList = new ArrayList<>();

}
