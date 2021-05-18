package com.example.batch;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.lang.management.OperatingSystemMXBean;
import java.util.*;
import java.util.function.BiFunction;
public class Test {


//    private final List<String> lst;

//
//    Test(List<String> lst) {
//        this.lst = new ArrayList<>(lst);
//    }

    Test(){};

    public List<String> testMethod(List<String> lst) {
        return Collections.unmodifiableList(lst);
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