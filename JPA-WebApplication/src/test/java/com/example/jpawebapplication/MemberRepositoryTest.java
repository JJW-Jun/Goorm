package com.example.jpawebapplication;

import com.example.jpawebapplication.repository.MemberRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

@Commit
@SpringBootTest(classes = JpaWebapplicationApplication.class)
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

//    @Test
////    @Rollback(value = false)
//    @Transactional // 끝나고 DB를 롤백해버린다.  // .JpaTransactionManager@4291b30f]; rollback [false]
//    void testMember() {
//        //given
//        Member member = new Member();
//        member.setUsername("memberB");
//
//        //when
//        Long saveId = memberRepository.save(member);
//        Member findMember = memberRepository.find(saveId);
//
//        //then
//        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
//        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
//
//        // 하나의 트랜젝션 속에서 일어나는 영속성은 값이 같다.
//        Assertions.assertThat(findMember).isEqualTo(member);
//    }

    @Test
    void test(){

    }

}