package com.nalim.repository;

import com.nalim.model.Member;
import com.nalim.model.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends CrudRepository<Post, Long> {
    // title, content

    // 특정 타이틀
    List<Post> findByTitle(String title);

    // 특정 타이틀이 들어가 있는 리스트(containing)
    List<Post> findByTitleContaining(String title);

    // post를 작성한 멤버 이름 출력
    @Query("select p from Post as p inner join Member as m on p.member.seq = m.seq where p.seq = :seq")
    List<Post> findByMemberName(Long seq);

}
