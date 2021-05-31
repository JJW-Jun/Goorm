package com.example.code.vo;

import com.example.code.user.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class MemberRepositoryImpl {

    private final JPAQueryFactory queryFactory;

    MemberRepositoryImpl(JPAQueryFactory queryFactory) {
//        super(User.class);
        this.queryFactory = queryFactory;
    }

//    public List<User> findUsers() {
//        return queryFactory.selectFrom(user).fetch();
//    }

}
