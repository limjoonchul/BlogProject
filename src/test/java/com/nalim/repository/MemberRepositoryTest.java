package com.nalim.repository;

import com.nalim.model.Member;
import com.nalim.model.Role;
import org.junit.Test;
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

    }

}