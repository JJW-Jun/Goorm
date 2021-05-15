package com.example.javareact.common;

import com.example.javareact.Fruit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class Main {
    public static <T, E> T catchException(Supplier<T> resolver) {
        try {
            T result = resolver.get();
            return result;
        } catch (Exception e) {
            System.out.println("Exception");
            return null;
        }
    }

    public static void main(String args[]) {

        List<Fruit> fruits = new ArrayList<>();

        Fruit apple = new Fruit("Apple", "A", 2);
        Fruit banana = new Fruit("Banana", "B", 1);
        Fruit coconut = new Fruit("Coconut", "C", 3);
        Main main = new Main();
        fruits.add(apple);
        fruits.add(banana);
        fruits.add(coconut);
        List<String> underlyers = null;
//        List<String> underlyers = null;
//        assert false;
        System.out.println("=====================");
        System.out.println(catchException(()->underlyers.size()));
        System.out.println("=====================");
//        System.out.println(underlyers.size());
//        System.out.println(catchException(underlyers::size));
//        int [] arr = {1,2,3,4};
//        Arrays.sort(arr);
//        int idex = Arrays.binarySearch(arr, -3);
//        System.out.println(idex);
//        System.out.println(Arrays.binarySearch(arr, 50));
//        fruits.stream().filter(Fruit -> Fruit.getKind().equals("Apple"))
//                .forEach(System.out::println);
//        fruits.stream().filter(Fruit::isApple)
//                .filter(Fruit::isGrade_A)
//                .forEach(System.out::println);
//
//        List<String> lst = new LinkedList<>();

    }
}
