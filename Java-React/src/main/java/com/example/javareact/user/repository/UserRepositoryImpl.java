package com.example.javareact.user.repository;

import com.example.javareact.user.domain.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.javareact.user.domain.QUser.user;

@Repository
public class UserRepositoryImpl extends QuerydslRepositorySupport implements IUserRepository {
    private final JPAQueryFactory queryFactory;

    public UserRepositoryImpl(JPAQueryFactory queryFactory) {
        super(User.class);
        this.queryFactory = queryFactory;

    }


    @Override
    public List<User> findAll() {
        return queryFactory.selectFrom(user).fetch();
    }


}
