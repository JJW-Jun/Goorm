package com.example.insta.usr.repository;

import com.example.insta.usr.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

interface IUserRepository{
    User findByUsername(String username);

}

// 애노테이션이 없어도 Jpa 레퍼지를 상속하면 자동 등록된다.
public interface UserRepository extends JpaRepository<User, Long> {
}
