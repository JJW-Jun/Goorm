package com.example.insta.security.config.auth;

import com.example.insta.usr.domain.User;
import com.example.insta.usr.repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service // IOC
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
    UserRepositoryImpl userRepository;
    // 패스워드는 알아서, 리턴이 잘 되면 자동으로 세션을 만든다.


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            return new PrincipalDetails(user);
        }
        throw new NullPointerException("Null");
    }
}
