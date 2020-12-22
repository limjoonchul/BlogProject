package com.nalim.repository;

import com.nalim.model.Member;
import com.nalim.model.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepo;

    @Test
    public void testSave() {
        Member member = new Member();

        member.setId("user");
        member.setRole(Role.ROLE_MEMBER);
        member.setPassword("user");
        member.setName("유저");

        memberRepo.save(member);

        assertThat(memberRepo.findMemberById("user").get().getId()).isEqualTo("user");

    }

    @Test
    public void findByName() {
        Member member = new Member();

        member.setId("user1");
        member.setRole(Role.ROLE_MEMBER);
        member.setPassword("user1");
        member.setName("이름찾기");

        memberRepo.save(member);

        String result = memberRepo.findMemberByName("이름찾기").get().getName();

        assertThat(result).isEqualTo("이름찾기");

    }



}