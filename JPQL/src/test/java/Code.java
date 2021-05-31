import jpql.Member;

import lombok.EqualsAndHashCode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
@EqualsAndHashCode(of="")
public class Code {
    @Test
    void primitive_type() {


    }

    @Test
    void result() {
        optional_();
    }

    void optional_() {
        System.out.println("1");
        Optional<String> str = Optional.ofNullable("st");
        System.out.println(str.get());
        System.out.println("2");
    }

    void requireNonNull_() {
        System.out.println("1");
        String str = Objects.requireNonNull(null);
        System.out.println("2");

    }



    @Test
    void equals_() {
        String str = new String("A");
        String str2 = new String("A");

        String str3 = "a";
        String str4 = "a";
        str.equals(str2);
        System.out.println(str.equals(str2));
        System.out.println(str.hashCode());
        System.out.println(str2==str);
        System.out.println(str3==str4);

    }

//    @Test
//    void 동등성_비교() throws Exception{
//        Member member= new Member();
//        member.setCoupon(3L);
//
//    }


}
