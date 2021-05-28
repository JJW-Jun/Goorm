package com.example.insta.security.handler;


import com.example.insta.security.handler.ex.CustomValidationException;
import com.example.insta.usr.domain.dto.auth.CMResponseDto;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class ControlExceptionHandler {

    @ExceptionHandler(CustomValidationException.class)
    public CMResponseDto<?> validationException(CustomValidationException e) {
        return new CMResponseDto(-1, e.getMessage(), e.getErrorMap());
    }

//    @ExceptionHandler(CustomValidationException.class)
//    public String validationException(CustomValidationException e) {
//        return Script.back(e.getErrorMap().toString());
//    }

//    @ExceptionHandler(CustomValidationException.class)
//    public Map<String, String> validationException(CustomValidationException e) {
//        return e.getErrorMap();
//    }


}
