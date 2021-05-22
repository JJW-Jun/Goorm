package com.example.code;

import java.util.Objects;

public class HashUser {
    private String name;
    private int age;
    private String address;

    public HashUser(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashUser hashUser = (HashUser) o;
        return age == hashUser.age
                && Objects.equals(name, hashUser.name)
                && Objects.equals(address, hashUser.address);
    }

}
