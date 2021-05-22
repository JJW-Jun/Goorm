package com.example.batch;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.w3c.dom.css.Rect;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.management.OperatingSystemMXBean;
import java.util.*;
import java.util.function.BiFunction;

public class Test {


//    private final List<String> lst;

//
//    Test(List<String> lst) {
//        this.lst = new ArrayList<>(lst);
//    }

    Test() {
    }

    ;

    @Override
    public boolean equals(Object o) {
        throw new AssertionError(); // 호출금지
    }

    public List<String> testMethod(List<String> lst) {
        return Collections.unmodifiableList(lst);
    }

    public static void main(String args[]) {

    }
}
 class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        boolean flag = false;
        int len = input.length();
        System.out.println(len);
        for (int i=0; i<len/2; i++) {
            if (input.charAt(i) != input.charAt(len-i-1)) {     //한글자라도 다르면 문자열 길이가 답
                System.out.println(len);
                return;
            }

            else if (input.charAt(i) != input.charAt(i+1))      //모든 글자가 같은 글자인지 판별
                flag = true;
        }

        if(flag)            //회문인경우 한글자만 짧아지면 회문이 아니게 됨
            System.out.println(len-1);

        else                //회문인 경우 문자가 모두 같으면 부분문자열도 모두 회문
            System.out.println(-1);
    }
}

//enum Operator {
//        PLUS("+", (num1, num2) -> num1 + num2);
//
//        private final String operator;
//        private final BiFunction<Double, Double, Double> expression;
//
//        Operator(String operator, BiFunction<Double, Double, Double> expression) {
//            this.operator = operator;
//            this.expression = expression;
//        }
//
//        public double calculate(double number1, double number2) {
//            return this.expression.apply(number1, number2);
//        }
//
//        private static final Map<String, Operator> operators = new HashMap<>();
//
//        static {
//            for (Operator value : Operator.values())
//                operators.put(value.operator, value);
//        }
//
//
//        public static double calc(String operator, double num1, double num2) {
//            return operators.get(operator).calculate(num1, num2);
//        }
//
//
//    }