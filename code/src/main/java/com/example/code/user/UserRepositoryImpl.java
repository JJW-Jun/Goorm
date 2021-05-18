package com.example.code.user;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.code.user.QUser.user;

@Repository
public class UserRepositoryImpl {

    private final JPAQueryFactory queryFactory;

    UserRepositoryImpl(JPAQueryFactory queryFactory) {
//        super(User.class);
        this.queryFactory = queryFactory;
    }

    public List<User> findUsers() {
        return queryFactory.selectFrom(user).fetch();
    }

}
