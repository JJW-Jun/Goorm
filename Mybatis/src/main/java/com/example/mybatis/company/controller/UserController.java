package com.example.mybatis.company.controller;

import com.example.mybatis.company.domain.Company;
import com.example.mybatis.company.domain.UserDto;
import com.example.mybatis.company.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper companyMapper;

    @GetMapping("")
    public String test(){
        System.out.println("========== Start Page ==========");
        return "return";
    }
    @PostMapping("")
    public int post(@RequestBody Company company){
        logger.info("========== User Insert ==========");
        return companyMapper.insert(company);
    }

//    @GetMapping("/getAll")
//    public List<Company> getAll(){
//        System.out.println("==========Company==========");
//        companyMapper.getAll().stream().forEach(System.out::println);
//        return companyMapper.getAll();
//    }
}
