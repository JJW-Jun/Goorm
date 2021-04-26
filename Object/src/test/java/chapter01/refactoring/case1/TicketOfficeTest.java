package chapter01.refactoring.case1;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TicketOfficeTest {
    @Test
    void addAll_(){
        // given
        List<String> lst = new ArrayList<>();

        // when
        lst.addAll(Arrays.asList("Apple", "Bana"));

        // then
        assertEquals(lst.size(), 2);
    }

    @Test
    void addAll_2(){
        // given
        List<String> lst = new ArrayList<>();
        List<String> lst2 = new ArrayList<>();

        // when
        lst.addAll(Arrays.asList("Apple", "Bana"));
        lst2.addAll(lst);

        // then
        assertEquals(lst.size(), 2);
    }

}