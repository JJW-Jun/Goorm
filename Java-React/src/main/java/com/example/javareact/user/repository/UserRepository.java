package com.example.javareact.user.repository;

import com.example.javareact.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

interface IUserRepository { }

public interface UserRepository extends JpaRepository<User, Long> {
}
