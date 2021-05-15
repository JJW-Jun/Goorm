package com.example.javareact.user.controller;

import com.example.javareact.user.domain.User;
import com.example.javareact.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usr")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/findall")
    public ResponseEntity<List<User>> findAll() {
        logger.info("Find all users");
        System.out.println("==========Controller==========");
        userService.findAll().stream().forEach(System.out::println);
        System.out.println("====================");
        return ResponseEntity.ok(userService.findAll());
    }

}
