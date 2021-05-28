package com.example.insta;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JavaToJspController {
    @GetMapping("/jsp/java")
    public String jspToJava() {
        return "d";
    }


    @GetMapping("/jsp/java/model")
    public String jspToJavaToModel(Model model){
        User user = new User();
        user.setName("John");
        model.addAttribute("username", user.getName());
        return "e";
    }
}
