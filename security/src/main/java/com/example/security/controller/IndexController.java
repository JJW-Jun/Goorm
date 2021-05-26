package com.example.security.controller;

import com.example.security.domain.User;
import com.example.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping({"", "/"})
    public String index() {
        return "index";
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }

    @GetMapping("/manager")
    public String manager() {
        return "manager";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "loginForm";
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "joinForm";
    }

    @Transactional
    @GetMapping("/join")
    public String join(User user) {
        System.out.println("====================");
        user.setUsername("김또치");
        user.setRole("ROLE_USER");
        user.setEmail("ABC@naver.com");
        String rawPassword = user.getPassword();
        String encodedPassword = bCryptPasswordEncoder.encode("Hello");
        user.setPassword(encodedPassword);
        userRepository.save(user);
        System.out.println("User= " + user);
        userRepository.findAll().forEach(System.out::println);
        System.out.println("====================");
        return "loginForm";
//        return "redirect:/loginForm ";
    }

    //    @Secured()
    @PreAuthorize("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
    @GetMapping("/data")
    public @ResponseBody
    String data() {
        return "개인정보";
    }

//    @GetMapping("/data")
//    public @ResponseBody String data(){
//        return "개인정보";
}



