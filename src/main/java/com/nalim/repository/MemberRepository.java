package com.nalim.repository;

import com.nalim.model.Comment;
import com.nalim.model.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MemberRepository extends CrudRepository<Member, Long> {

    public Optional<Member> findMemberById(String name);

    public Optional<Member> findMemberByName(String name);
}
