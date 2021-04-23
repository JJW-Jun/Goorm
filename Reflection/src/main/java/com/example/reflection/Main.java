package com.example.reflection;

import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) throws ClassNotFoundException, NoSuchFieldException {
        //클래스 로딩이 끝나면 클래스 타입의 인스턴스를 만들어서 힙에 넣는다. 클래스를 로딩만해도 인스턴스 쓸 수 있따.
        // 클래스로딩만해도 인스턴스가 ㅁ나들어진다.
        Class<Book> bookClass = Book.class;
        bookClass.getName();


//        Book book = new Book();
//        Class<? extends Book> aClass = book.getClass();
//
//        Class<?> aclass = Class.forName("com.example.reflection.Book");
//        System.out.println(aclass);

        // public 한 것만 리턴한다. 모든것을 가져오고 싶다면
        Arrays.asList(bookClass.getFields()).forEach(System.out::println);
        System.out.println("====================");
        Arrays.asList(bookClass.getDeclaredFields()).forEach(System.out::println);
        System.out.println("====================");
        Arrays.asList(bookClass.getField("d")).forEach(System.out::println);
        System.out.println("====================");
        Book book = new Book();
        Arrays.asList(bookClass.getDeclaredFields()).forEach(f -> {
            try {
                f.setAccessible(true);
                System.out.printf("%s %s\n", f, f.get(book));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        System.out.println("====================");
        Arrays.stream(bookClass.getMethods()).forEach(System.out::println);
        System.out.println("====================");
        Arrays.stream(book.getClass().getDeclaredConstructors()).forEach(System.out::println);
        System.out.println("====================");
        System.out.println(MyBook.class.getSuperclass());
        System.out.println("====================");
        Arrays.stream(MyBook.class.getInterfaces()).forEach(System.out::println);
        System.out.println("====================");
        Arrays.stream(Book.class.getDeclaredFields()).forEach(f -> {
            int modifiers = bookClass.getModifiers();
            int modifier2 = f.getModifiers();
            System.out.println(f);
            System.out.println(Modifier.isPrivate(modifiers));
            System.out.println(Modifier.isStatic(modifiers));
            System.out.println(Modifier.isPublic(modifier2));
        });
    }
}
