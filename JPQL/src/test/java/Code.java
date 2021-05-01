import jpql.Member;

import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class Code {
    @Test
    void primitive_type(){

        Member memberA = new Member();
        memberA.setUsername("MemberA");

        Member memberB = new Member();
        memberB.setUsername("MemberA");

        assertThat(memberA, is(equalTo(memberB)));
    }

    @Test
    void result(){
        optional_();
    }

    void optional_(){
        System.out.println("1");
        Optional<String> str = Optional.ofNullable("st");
        System.out.println(str.get());
        System.out.println("2");
    }

    void requireNonNull_(){
        System.out.println("1");
        String str = Objects.requireNonNull(null);
        System.out.println("2");
    }


}
