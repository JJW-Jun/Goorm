package com.example.code;

import java.util.stream.Stream;

public class StreamReturn {
    public static void main(String args[]) {
        Stream.of("Banana", "Apple", "Apricot", "Coconut", "Mango")
                .sorted((s1, s2) -> {
                    System.out.printf("1.sort: %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .filter(s -> {
                    System.out.println("2.StartsWith: " + s);
                    return s.startsWith("A");
                })
                .filter(s -> {
                    System.out.println("3.EndsWith");
                    return s.endsWith("e");
                })
                .map(s -> {
                    System.out.println("4.map: " + s);
                    System.out.println("====================");
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));
//        Stream.of("Apple", "Banana", "Coconut", "Grape", "Mango")
//                .filter(s -> {
//                    System.out.println("filter: " + s);
//                    return s.startsWith("a");
//                })
//                .sorted((s1, s2) -> {
//                    System.out.printf("sort: %s; %s\n", s1, s2);
//                    return s1.compareTo(s2);
//                })
//                .map(s -> {
//                    System.out.println("map: " + s);
//                    return s.toUpperCase();
//                })
//                .forEach(s -> System.out.println("forEach: " + s));
//        System.out.println("=================================");
//        Stream.of("Apple", "Banana", "Coconut", "Grape", "Mango")
//                .filter(s -> {
//                    System.out.println("filter: " + s);
//                    return s.startsWith("a");
//                })
//                .map(s -> {
//                    System.out.println("map: " + s);
//                    return s.toUpperCase();
//                })
//                .sorted((s1, s2) -> {
//                    System.out.printf("sort: %s; %s\n", s1, s2);
//                    return s1.compareTo(s2);
//                })
//                .forEach(s -> System.out.println("forEach: " + s));
//
//    }
    }
}
