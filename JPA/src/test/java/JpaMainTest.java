import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class JpaMainTest {
    @Test
    void stream() {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);
        integers.stream()
                .filter(i -> {
                    System.out.println("i= " + i + ", 조건= 짝수");
                    return i % 2 == 0;
                })
                .filter(i -> {
                    System.out.println("중간다리");
                    return i % 2 == 0;
                })
                .filter(i -> {
                    System.out.println("i=" + i + ", 조건= 4이하");
                    return i <= 4;
                }).collect(Collectors.toList());
    }

}