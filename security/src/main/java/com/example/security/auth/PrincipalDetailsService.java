package com.example.security.auth;

import com.example.security.domain.User;
import com.example.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

// Security 설정에서 loginProcessingUrl을 걸었다.
// login 요청이 오면 자동으로 UserDetailsService 타입으로 ioC 돼 있는 loadUserByUsername 함수가 실행된다.
@Service // 자동 등록
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    // Security session= Authentication=UserDetails
    // Security session= Authentication(내부 UserDetails)
    // Security session(Authentication(내부 UserDetails))
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userEntity = Optional.ofNullable(userRepository.findUserF("username"));
        System.out.println("=================================================");
        System.out.println(userEntity.get());
        System.out.println("=================================================");
        /* return userEntity.map(PrincipalDetails::new).orElseThrow(NullPointerException::new); */
        if (userEntity.isPresent()) {
            return new PrincipalDetails(userEntity.get());
        } else
        return null;
    }

//    @Secured("")
    @GetMapping("/info")
    public @ResponseBody String info(){
        return "개인정보";
    }

}
