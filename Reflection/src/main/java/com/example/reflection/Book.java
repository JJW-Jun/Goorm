package com.example.reflection;

public class Book {
    // final이면 초기화해줘야 한다.
    private String a;
    private static String B = "BOOK";
    private static final String C = "BOOK";

    public String d = "d";

    protected String e = "e";

    public Book() {
    }

    public Book(String a, String d, String e) {
        this.a = a;
        this.d = d;
        this.e = e;
    }

    private void f() {
        System.out.println("F");
    }

    public int h() {
        return 100;
    }


}
