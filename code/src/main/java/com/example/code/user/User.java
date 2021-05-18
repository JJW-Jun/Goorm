package com.example.code.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private int age;
    private String phoneNumber;
    private String gender;


    public boolean liveSeoul() {
        return "Seoul".equals(getAddress());
    }

    public boolean is20s() {
        if (getAge() <= 0) {
            throw new IllegalStateException("유효하지 않은 나이입니다.");
        }
        return getAge() >= 20 && getAge() < 30;
    }

    public boolean isMan() {
        return "Man".equals(getGender());
    }

    User(){};

    User(String name, String address, int age, String gender) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.gender = gender;
    }

    public static void main(String args[]) {

    }

}

