package hello.aws_practice.controller;

import hello.aws_practice.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
