package com.example.TT.member.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TT.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member,Long>{
	
	Member findByEmail(String email);

}
