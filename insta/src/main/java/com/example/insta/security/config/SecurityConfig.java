package com.example.insta.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//@EnableWebSecurity // 해당 파일로 시큐리티를 활성화
@Configuration // IOC 등록
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http); -> 기존 Security가 가지고 있는 기능이 비활성화

        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/", "/user/**", "/image/**", "/subscribe/**", "/comment/**").authenticated()//여기로 요청하면
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/auth/signin") // 여기로 보내겠다  -> 요청하면 이걸 낚아챔(GET)
                .loginProcessingUrl("/auth/signin")  // POST로 요청이 오면 시큐리티가 진행
                .defaultSuccessUrl("/") // 정상작동하면 여기로
        ;
    }


}
