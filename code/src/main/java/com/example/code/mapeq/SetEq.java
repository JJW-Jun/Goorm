package com.example.code.mapeq;

import java.util.HashSet;
import java.util.Set;

public class SetEq {
    private static final Set<?> set1 = new HashSet<>();
    private static final Set<?> set2 = new HashSet<>();

    public static void main(String args []){

        boolean result = set1.equals(set2);

        System.out.println(result);

    }
}
