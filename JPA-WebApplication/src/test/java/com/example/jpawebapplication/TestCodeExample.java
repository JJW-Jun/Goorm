package com.example.jpawebapplication;

import org.junit.jupiter.api.Test;

public class TestCodeExample {

    @Test
    void testCode() throws Exception{
        int number = 7;
        for(int i=2; i<number; i++){
            if(number%i ==0){
                throw new Exception("소수가 아니니다.");
            }
        }

    }
}
