package com.nalim.repository;

import com.nalim.model.Comment;
import com.nalim.model.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {
}
