package com.example.jpawebapplication.service;

import com.example.jpawebapplication.HelloController;
import com.example.jpawebapplication.domain.Member;
import com.example.jpawebapplication.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional // public 은 다 들어가게 된다. 스프링을 쓰는게 더 낫다.
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    // 회원 가입
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        // 아이디라도 돌려줘야 뭔가를 알 수 있다.
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            // Membercount를 세서 하는게 더 최적화 된 로직이다. 한 번 만들어 보자.
            // memer가 두명이 같은 이름이 동시에 회원가입하면 동시섯ㅇ 문제가 발생할 수 있기 때문에
            // 최후의 방어로 이름을 데이터베이스에서 멤버 네임을 유니크 제약조건으로 걸어준다.
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }

    }

    // 회원 전체 조회
    @Transactional(readOnly = true)
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    @Transactional(readOnly = true) // true하면 변경사항이 변경안된다.기본이 false;
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }

}
