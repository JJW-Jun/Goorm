package com.example.jpawebapplication.service;

import static org.junit.jupiter.api.Assertions.*;
import com.example.jpawebapplication.JpaWebapplicationApplication;
import com.example.jpawebapplication.domain.Member;
import com.example.jpawebapplication.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaWebapplicationApplication.class)
@Transactional
//@Commit()
class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;


    //    @Rollback(value = false)
    @Test  // 기본적으로 Transactional이 붙으면 Rollback을 함
    // 테스트 시 와스를 띄울 때 메모리 DB를 두고 거기다가 테ㅐ스트하는게 좋다.
    //애플리케이션이 종료되면 메모리 db가 같이 내려간다.
    public void memberRegist() throws Exception {
        // given
        Member member = new Member();
        member.setName("Jung");

        // when
        Long saveId = memberService.join(member);
        member.getId();

        // then
        assertEquals(member, memberRepository.findOne(saveId));
    }


    @Test // 왜 못찾는지
    public void duplicateMember() throws Exception{
        // given

        Member member1 = new Member();
        member1.setName("Kim");

        Member member2 = new Member();
        member2.setName("Kim");

        // when
        memberService.join(member1);
        try {
        memberService.join(member2);
        } catch (IllegalStateException e){
            return;
        }
//         then
        fail("예외가 발생");

    }

    @Test
    void tt(){
        System.out.println("");
    }
}