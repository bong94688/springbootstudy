package com.example.TT.member.service;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.example.TT.member.dto.MemberFormDto;
import com.example.TT.member.entity.Member;import lombok.val;

@SpringBootTest
@Transactional
//@Rollback(value = false)
class MemberServiceTest {

	    @Autowired
	    MemberService memberService;

	    @Autowired
	    PasswordEncoder passwordEncoder;
	    
	    
	    
	    
	        public Member createMember(){
	        MemberFormDto memberFormDto = new MemberFormDto();
	        memberFormDto.setEmail("test@email.com");
	        memberFormDto.setName("홍길동");
	        memberFormDto.setAddress("서울시 마포구 합정동");
	        memberFormDto.setPassword("1234");
	        return Member.createMember(memberFormDto, passwordEncoder);
	    }

	        @Test
	        @DisplayName("회원가입 테스트")
	        public void saveMemberTest(){
	        Member member = createMember();
	        Member savedMember = memberService.saveMember(member);
//		       org.junit.jupiter.api.Assertions.assertEquals(member.getEmail(), savedMember.getEmail());
	        
	       assertEquals(member.getEmail(), savedMember.getEmail());
	        assertEquals(member.getName(), savedMember.getName());
	        assertEquals(member.getAddress(), savedMember.getAddress());
	        assertEquals(member.getPassword(), savedMember.getPassword());
	        assertEquals(member.getRole(), savedMember.getRole());
	    }

}
