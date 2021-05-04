package com.example.javareact.user.repository;

import com.example.javareact.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface IUserRepository {
    List<User> findAll();
}

public interface UserRepository extends JpaRepository<User, Long> {
}
