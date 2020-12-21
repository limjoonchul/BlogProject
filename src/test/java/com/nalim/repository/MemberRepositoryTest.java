package com.nalim.repository;

import com.nalim.model.Member;
import com.nalim.model.Role;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

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

        Assertions.assertEquals("user", memberRepo.findMemberById("user").get().getId() );
        

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

        Assertions.assertEquals("이름찾기", result );

    }

}