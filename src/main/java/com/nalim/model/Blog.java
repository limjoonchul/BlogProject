package com.nalim.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.DateType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

@Setter
@Getter
@ToString
@Entity
public class Blog {
    @Id @GeneratedValue
    private Long seq;

    @Column(unique = true, nullable = false, updatable = false, columnDefinition = "varchar(20)")
    private String name;

    @Column(nullable = false, columnDefinition = "varchar(50)")
    private String description;

    @Column(columnDefinition = "varchar(250) default '태그없음'")
//    @ColumnDefault("태그 없음")
    private String tag;

    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    private Date createDate;

//    @Temporal(TemporalType.DATE)
//    @UpdateTimestamp
//    private Date updateDate;

    @OneToOne
    @JoinColumn(name = "Member_seq")
    private Member member;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
    private List<Post> postList = new ArrayList<>();

}
