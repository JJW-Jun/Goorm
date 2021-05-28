package com.example.insta.usr.repository;

import com.example.insta.usr.domain.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import static com.example.insta.usr.domain.QUser.user;
import javax.persistence.EntityManager;

@RequiredArgsConstructor
@Repository
public class UserRepositoryImpl implements IUserRepository {

    private final JPAQueryFactory queryFactory;
    private final EntityManager entityManager;

    @Override
    public User findByUsername(String username) {
        return queryFactory.selectFrom(user).fetchOne();
    }
}
