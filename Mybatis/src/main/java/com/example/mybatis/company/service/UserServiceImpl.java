package com.example.mybatis.company.service;

import com.example.mybatis.company.domain.Company;
import com.example.mybatis.company.domain.UserDto;
import com.example.mybatis.company.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired private UserMapper userMapper;

    @Override
    public int insert(Company company) {

        return userMapper.insert(company);
    }

//    public boolean duplicateIdCheck(String id){
//        if(id != null){
//            return
//        }
//    }
}
