package com.example.reflection;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ReflectionApplicationTests {


    static boolean checkNumber(String number) {
        for (int i = 0; i < number.length() - 1; i++) {
            if (number.charAt(i) <= number.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    static List<Integer> lst = new ArrayList<>();



    static void addNumber(String number) {
        int start = 0;
        int object = Integer.parseInt(number);
        while (lst.size() <= object) {
            if (checkNumber(String.valueOf(start))) {
                lst.add(start);
            }
            start++;
        }
        System.out.println(lst.get(object));
    }


    @Test
    void contextLoads() {
        System.out.println("=====================================================");
        addNumber("1");
        System.out.println("=====================================================");
    }

}
