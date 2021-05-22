package com.example.code.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class UserRequestrDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;
    private String address;
    private int age;
    private String phoneNumber;
    private String gender;

    UserRequestrDto() { }
    UserRequestrDto(String name, String address, int age, String gender) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.gender = gender;
    }

}

