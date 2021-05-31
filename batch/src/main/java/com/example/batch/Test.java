package com.example.batch;

import com.example.batch.part3.Person;
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

//class Main extends Person {
//
//    public static void main(String[] args) throws Exception {
//        String test = "d";
//        Main main = new Main();
//
//
//        if (main instanceof Main) {
//            System.out.println("-----");
//        }
//
//        System.out.println("=============================");
//    }
//}
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String input = br.readLine();
//
//        boolean flag = false;
//        int len = input.length();
//        System.out.println(len);
//        for (int i=0; i<len/2; i++) {
//            if (input.charAt(i) != input.charAt(len-i-1)) {     //한글자라도 다르면 문자열 길이가 답
//                System.out.println(len);
//                return;
//            }
//
//            else if (input.charAt(i) != input.charAt(i+1))      //모든 글자가 같은 글자인지 판별
//                flag = true;
//        }
//
//        if(flag)            //회문인경우 한글자만 짧아지면 회문이 아니게 됨
//            System.out.println(len-1);
//
//        else                //회문인 경우 문자가 모두 같으면 부분문자열도 모두 회문
//            System.out.println(-1);
//    }
//}

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

@Getter
class Fruit {
    private String kind;
    private String grade;
    private int weight;

    public Fruit(String kind, String grade, int weight) {
        this.kind = kind;
        this.grade = grade;
        this.weight = weight;
    }

    public static boolean isApple(Fruit fruit) {
        return "Apple".equals(fruit.getKind());
    }
}

class Main2 {
    public static void main(String args[]) {
        List<Fruit> fruits = new ArrayList<>();
        Fruit apple = new Fruit("Apple", "A", 2);
        Fruit banana = new Fruit("Banana", "B", 1);
        Fruit coconut = new Fruit("Coconut", "C", 3);
        fruits.add(apple);
        fruits.add(banana);
        fruits.add(coconut);
        fruits.stream().filter(Fruit::isApple).forEach(System.out::println);
    }
}

