package com.example.javareact.user;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class Person {
    private String name;
    private int age;
    private String address;

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public boolean isKorea() {
        return "Korea".equals(getName());
    }

    public static void main(String args[]) {
        List<Person> people = new ArrayList<>();
        Person personA = new Person("John", 30, "America");
        Person personB = new Person("Amy", 22, "Canada");
        Person personC = new Person("Kim", 31, "Korea");
        people.add(personA);
        people.add(personB);
        people.add(personC);
        List<Person> result2 =
                people.stream().filter(Person::isKorea)
                        .collect(Collectors.toList());
    }
}

