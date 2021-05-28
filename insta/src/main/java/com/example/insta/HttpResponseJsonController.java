package com.example.insta;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpResponseJsonController {
    @GetMapping("/resp/json")
    public String respJson(){
        return "{"+'"'+"username"+'"'+':'+'"'+"jun"+'"'+"}";
    }

    @GetMapping("/resp/json/object")
    public User respJsonObject(){
        User user = new User();
        user.setName("kim");
        //MessageConverter가 자동으로 JavaObject를 JSON으로 변경해서 통신을 통해 응답해준다.
        // @RestController일때만 MessageConverter가 작동한다.
        return user;
    }
}
