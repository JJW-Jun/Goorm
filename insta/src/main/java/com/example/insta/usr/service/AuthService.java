package com.example.insta.usr.service;

import com.example.insta.usr.domain.User;
import com.example.insta.usr.repository.UserRepository;
import com.example.insta.usr.domain.dto.auth.SignupRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service
public class AuthService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @Transactional // Write(INser, Update, Delete)
    public void signup(@Valid SignupRequestDto user) {
        String rawPassword = user.getPassword();
        String encodedPassword = bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(encodedPassword);
        user.setRole("USER");
        User userEntity = user.toEntity();
        userRepository.save(userEntity);

    }
}