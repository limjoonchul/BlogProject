package com.nalim.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Member {
    @Id
    @GeneratedValue
    private Long seq;

    @Column(unique = true, nullable = false, columnDefinition = "varchar(20)")
    private String id;

    @Column(nullable = false, columnDefinition = "varchar(20)")
    private String password;

    @Transient
    private String passwordCheck;

    @Column(nullable = false, columnDefinition = "varchar(20)")
    private String name;

    @Enumerated(EnumType.STRING)
    private Role role;
}
