import jpql.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static java.util.function.Predicate.isEqual;
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
    void notNull(String str){
        System.out.println(str);
    }
}
