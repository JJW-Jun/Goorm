package com.example.insta;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HttpResController {
    @GetMapping("/txt")
    public String txt(){
        return "a.txt";
    }

    @GetMapping("/mus")
    public String mus(){
        return "b";
    }

    @GetMapping("/jsp")
    public String jsp(){
        // WEB/INF/views/c.jsp (ViewResolver클래스)
        return "c";
    }

}
