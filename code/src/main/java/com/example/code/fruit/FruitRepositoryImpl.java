package com.example.code.fruit;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.List;

import static com.example.code.fruit.QFruit.fruit;

@Repository
public class FruitRepositoryImpl {
    private final JPAQueryFactory queryFactory;

    FruitRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }


    public List<Fruit> findFruit() {
        return queryFactory.selectFrom(fruit).fetch();
    }

    public List<Fruit> findApple() {
        return queryFactory.selectFrom(fruit)
                .where(fruit.kind.eq("Apple"))
                .fetch();
    }

    public List<Fruit> findOver3Kg() {
        return queryFactory.selectFrom(fruit)
                .where(fruit.weight.goe(3.0))
                .fetch();
    }

    public List<Fruit> findGradeA() {
        return queryFactory.selectFrom(fruit)
                .where(fruit.grade.eq("A"))
                .fetch();
    }
}
