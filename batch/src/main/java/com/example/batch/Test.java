package com.example.batch;

import lombok.Getter;

import java.lang.management.OperatingSystemMXBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class Test {
    enum Operator {
        PLUS("+", (num1, num2) -> num1 + num2);

        private final String operator;
        private final BiFunction<Double, Double, Double> expression;

        Operator(String operator, BiFunction<Double, Double, Double> expression) {
            this.operator = operator;
            this.expression = expression;
        }

        public double calculate(double number1, double number2) {
            return this.expression.apply(number1, number2);
        }

        private static final Map<String, Operator> operators = new HashMap<>();

        static {
            for (Operator value : Operator.values())
                operators.put(value.operator, value);
        }


        public static double calc(String operator, double num1, double num2) {
            return operators.get(operator).calculate(num1, num2);
        }


    }
}



