package com.nalim.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Member {
    @Id
    private Long seq;

    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String password;

    @Transient
    private String passwordCheck;

    private String name;

    @Enumerated(EnumType.STRING)
    private Role role;
}
