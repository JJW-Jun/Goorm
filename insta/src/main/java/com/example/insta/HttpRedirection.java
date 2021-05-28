package com.example.insta;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HttpRedirection {
    @GetMapping("/away")
    public String away(){
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }
}
