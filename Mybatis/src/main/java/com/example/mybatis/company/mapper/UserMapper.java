package com.example.mybatis.company.mapper;

import com.example.mybatis.company.domain.Company;
import com.example.mybatis.company.domain.UserDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO users(user_name, user_address) VALUES(#{user.name}, #{user.address})")
//    @Options(useGeneratedKeys = true, keyProperty = "company")
    int insert(@Param("user") UserDto userDto);

    @Select("SELECT * FROM users where user_id = #{userid}")
    boolean duplicateIdCheck(@Param("user") String id);

    @Select("SELECT * FROM company")
    @Results({
            @Result(property = "name", column = "company_name"),
            @Result(property = "address", column = "company_address")
    })
    List<Company> getAll();
}