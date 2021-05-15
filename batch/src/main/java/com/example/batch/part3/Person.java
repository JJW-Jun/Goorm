package com.example.batch.part3;

import lombok.Getter;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Getter
public class Person {
    private Long id;
    private String name;
    private int age;
    private String address;

    public Person(Long id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }
}
