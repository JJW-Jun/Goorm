package com.example.javareact.angular;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Main {

    public static void main(String[] args) throws IOException {
        try {

            List<String> dictionary = new ArrayList<>();

            dictionary.add("");
            dictionary.add("Y");

            System.out.println("Initial list: " + dictionary);

            List<String> immutablelist = Collections
                    .unmodifiableList(dictionary);

            immutablelist.add("Apple");
//                immutablelist = immutablelist.stream().map(x->x+"A").collect(Collectors.toList());
//                immutablelist.stream().forEach(System.out::println);
            // printing the list
//                System.out.println("Unmodifiable list: " + immutablelist.toArray());


        } catch (UnsupportedOperationException e) {
            System.out.println("====================");
            System.out.println("Exception thrown : " + e);
            System.out.println("====================");
        }
    }
}
