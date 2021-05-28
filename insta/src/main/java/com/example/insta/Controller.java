package com.example.insta;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    static Logger logger = LoggerFactory.getLogger(Controller.class);
    @GetMapping("/chicken")
    public String chickenQueryString(String type){
        return type+" 배달 갑니다.";
    }

    @GetMapping("/chicken/{type}")
    public String chickenPath(@PathVariable String type){
        return type+" 배달갑니다.";
    }

    @PostMapping("/body1")
    public String xwwwformurlencode(String username){
        System.out.println("============================");
        logger.info(username);
        System.out.println("============================");
        return "key=value 요청";
    }

    @PostMapping("/body2")
    public String plaintext(@RequestBody String data){
        // key가 없기 때문에
        System.out.println("============================");
        logger.info(data);
        System.out.println("============================");
        return "plain/text 전송";
    }

    @PostMapping("/body3")
    public String applicationJson(@RequestBody String data){
        System.out.println("============================");
        logger.info(data);
        System.out.println("============================");
        return "json전송";
    }

}
