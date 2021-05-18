package com.example.code.mapeq;

import java.util.HashMap;

public class MapEq {
    private static final HashMap<String, Object> map1 = new HashMap<>();
    private static final HashMap<String, Object> map2 = new HashMap<>();

    public static void main(String args[]) {

        boolean result = map2.equals(map1);
        System.out.println(result);


    }
}