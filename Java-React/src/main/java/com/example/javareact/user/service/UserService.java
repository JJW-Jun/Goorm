package com.example.javareact.user.service;

import com.example.javareact.user.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
}
