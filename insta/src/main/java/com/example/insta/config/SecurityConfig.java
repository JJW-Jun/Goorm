package com.example.insta.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity // 해당 파일로 시큐리티를 활성화
@Configuration // IOC 등록
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http); -> 기존 Security가 가지고 있는 기능이 비활성화
        http.authorizeRequests()
                .antMatchers("/", "/user/**", "/image/**", "/subscribe/**", "/comment/**").authenticated()
        .anyRequest()

        ;


    }
}
