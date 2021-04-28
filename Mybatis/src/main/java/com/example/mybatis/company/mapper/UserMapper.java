package com.example.mybatis.company.mapper;

import com.example.mybatis.company.domain.Company;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO company(company_name, company_address) VALUES(#{company.name}, #{company.address})")
    int insert(@Param("company") Company company);
//    @Insert("INSERT INTO users(user_name, user_address) VALUES(#{user.name}, #{user.address})")
////    int insert(@Param("user") UserDto userDto);
//
//    @Select("SELECT * FROM users where user_id = #{userid}")
//    boolean duplicateIdCheck(@Param("user") String id);
    @Select("SELECT * FROM company")
    @Results({
            @Result(property = "name", column = "company_name"),
            @Result(property = "address", column = "company_address")
    })
    List<Company> getAll();
}