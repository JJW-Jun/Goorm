package com.example.security.auth;

import com.example.security.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

// Security가 login주소 요청이 오면 낚아채서 로그인을 진행시킨다.
// 로그인을 진행이완료가 되면 session을 만들어 준다. 같은 세션 공간인데 시큐리티 자신만의 공간.
// 즉, Security ContextHolder에다가 Session 정보를 저장한다.
// 즉, Object=> Authentication 객체만 가능
// 이 안에는 User 정보가 있어야 한다.
// 이것도 클래스가 정해져 있다. User Object의 타입은 UserDetails 타입의 객체여야 한다.
// Security Session => Authentication => UserDetails 객체(PrincipalDetails)
public class PrincipalDetails implements UserDetails {

    private User user;

    public PrincipalDetails(User user) {
        this.user = user;
    }


    @Override  // 해당 유저의 권한을 반환한다.
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return user.getRole();
            }
        });
        return collect;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // 너무 오래 사용한거 아니니
        return true;
    }

    @Override
    public boolean isEnabled() {
        // 1년 동안 로그인을 안 하면 휴면 계정으로 하기로 했다고 했을 경우
//        Timestamp current = Timestamp.valueOf(LocalDate.now().toString());
//        Timestamp lastLogin = user.getLoginDate();
        return true;
    }
}
