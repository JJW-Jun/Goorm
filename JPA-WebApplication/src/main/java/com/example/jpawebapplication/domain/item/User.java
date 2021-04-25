package com.example.jpawebapplication.domain.item;

import lombok.Getter;

import java.util.Objects;

@Getter
public class User {

    private final String userName;
    public User(String userName) {
        this.userName = Objects.requireNonNullElseGet(userName, ()->"");
    }

    public String getDefaultValue() {
        System.out.println("====================");
        return "";
    }

    public static void main(String args []){
        User user = new User(null);
        System.out.println("====================");
        System.out.println(user.getUserName());
        System.out.println("====================");


    }
}