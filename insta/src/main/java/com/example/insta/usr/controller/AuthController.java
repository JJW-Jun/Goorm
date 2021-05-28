package com.example.insta.usr.controller;


import com.example.insta.security.handler.ex.CustomValidationException;
import com.example.insta.usr.service.AuthService;
import com.example.insta.usr.domain.dto.auth.SignupRequestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

//@RequiredArgsConstructor // final이 붙은 모든 것들에 생성자를 만들어 준다.
@Controller // Ioc등록, File을 반환,
public class AuthController {

    private final AuthService authService;

    AuthController(AuthService authService) {
        this.authService = authService;
    }


    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/auth/signin")
    public String signinForm() {
        return "auth/signin";
    }

    @GetMapping("/auth/signup")
    public String signupForm() {
        return "auth/signup";
    }

    @PostMapping("/auth/signup") // ResponseBody가 붙어있으면 데이터를 반환한다.
    public String signup(@Valid SignupRequestDto signupRequestDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
                System.out.println("==============================");
                System.out.println(error.getDefaultMessage());
                System.out.println("==============================");
            }
            throw new CustomValidationException("유효성검사 실패함", errorMap);
        } else {
            logger.info("==========================================");
            logger.info(signupRequestDto.toString());
            logger.info("==========================================");
            authService.signup(signupRequestDto);
            return "auth/signin";
        }
    }
}