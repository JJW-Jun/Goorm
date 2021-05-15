package com.example.javareact;

import org.springframework.lang.NonNull;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Dictionary {

    public static List<String> update_Official_Dictionary(@NonNull List<String> dictionary) {
        return Collections.unmodifiableList(dictionary);
    }

    public static void main(String args[]) {
        String [] strings = new String[10];
        strings[0] = "ABBC";
        strings[1] = "ABBCDD";
        strings[2] = "ABBCDF";

        String [] test = Arrays.copyOf(strings, strings.length);
        test[0] = "SS";

        System.out.println("string[0]= "+strings[0]);
        Arrays.asList("dd").getClass().getName();
        System.out.println(Arrays.asList("dd").getClass().getName());



        List<String> a= new ArrayList<>();
        a.add("A");
        a.add("B");
        a.add("C");

        List<String> b = Arrays.asList("A", "B", "C","D");
        a.add("D");
        a.clear();
        System.out.println("======================");
        b.stream().forEach(System.out::println);
        System.out.println("======================");


    }
}
//        {
//                try {
//
//                List<String> dictionary = new ArrayList<>();
//
//        dictionary.add("word_A");
//        dictionary.add("word_B");
//
//        System.out.println("Initial list: " + dictionary);
//
//        List<String> officialDictionary = update_Official_Dictionary(dictionary);
//
//        officialDictionary.add("Apple");
//
//
////                immutablelist = immutablelist.stream().map(x->x+"A").collect(Collectors.toList());
////                immutablelist.stream().forEach(System.out::println);
//        // printing the list
////                System.out.println("Unmodifiable list: " + immutablelist.toArray());
//
//
//        } catch (UnsupportedOperationException e) {
//        System.out.println("====================");
//        System.out.println("Exception thrown : " + e);
//        System.out.println("====================");
//        }
//        }