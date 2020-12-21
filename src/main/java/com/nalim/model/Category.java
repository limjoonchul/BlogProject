package com.nalim.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "Category_name"))
public class Category {
    @Id
    @GeneratedValue
    private Long seq;

    @Column(name = "Category_name", unique = true, nullable = false, columnDefinition = "varchar(20)")
    private String name;

    @Lob
    private byte[] logo;

//    @OneToMany(mappedBy = "category")
//    private List<Post> postList = new ArrayList<>();
}