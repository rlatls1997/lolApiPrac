package com.lolapiprac.demo.Member.repository;

import com.lolapiprac.demo.Member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByGroupId(Long id);
}
