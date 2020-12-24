package com.nalim.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.DateType;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

@Setter
@Getter
@ToString
@Entity
@DynamicInsert
public class Blog {
    @Id
    @GeneratedValue(generator = "seq")
    private Long seq;

    @Column(unique = true, nullable = false, updatable = false, columnDefinition = "varchar(20)")
    private String name;

    @Column(nullable = false, columnDefinition = "varchar(50)")
    private String description;

    @Column(columnDefinition = "varchar(255) default '태그없음'")
    private String tag;

    @CreationTimestamp
    private LocalDateTime createDate;

    @OneToOne
    @JoinColumn(name = "Member_seq")
    private Member member;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
    private List<Post> postList = new ArrayList<>();

    @Lob
    private byte[] Logo;

}
