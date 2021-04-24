package com.example.jpawebapplication;

import com.example.jpawebapplication.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {
    // componentscan 대상
    // EntityManagert생성이 Spring Data-JPA
    @PersistenceContext
    private EntityManager em;

    public Long save(Member member) {
        // Command랑 Query를 분리해라. SideEffect를 일으킬 수 있다.
        em.persist(member);
        System.out.println(member.getId());
        return member.getId();
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }

}
