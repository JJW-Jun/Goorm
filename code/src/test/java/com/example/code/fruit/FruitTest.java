package com.example.code.fruit;

import com.example.code.CodeApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

//@Commit
@Transactional
@SpringBootTest
@ContextConfiguration(classes = CodeApplication.class)
class FruitTest {
    @Autowired
    EntityManager entityManager;

    @Autowired
    FruitRepositoryImpl fruitRepository;

    //    @BeforeEach
    void makeFruit() throws Exception {
        entityManager.persist(new Fruit("Apple", "A", 3, 1000));
        entityManager.persist(new Fruit("Apple", "A", 3.1, 1200));
        entityManager.persist(new Fruit("Apple", "A", 3.3, 1500));
        entityManager.persist(new Fruit("Apple", "A", 3.5, 1500));
        entityManager.persist(new Fruit("Banana", "B", 1.9, 800));
        entityManager.persist(new Fruit("Banana", "B", 2, 900));
        entityManager.persist(new Fruit("Coconut", "A", 3, 3000));
        entityManager.persist(new Fruit("Coconut", "B", 3, 2500));
        entityManager.persist(new Fruit("Mango", "A", 3, 3000));
        entityManager.persist(new Fruit("Kiwi", "A", 1.5, 2800));
    }

    @Test
    void execute() throws Exception {
        System.out.println("Execution");
    }

    @Test
    void findFruit() throws Exception {
        List<Fruit> lambda = fruitRepository.findFruit().stream()
                                    .filter(x->x.getKind().equals("Apple"))
                                    .filter(x->x.getGrade().equals("A"))
                                    .filter(x->x.getWeight()>=3.0)
                                    .collect(Collectors.toList());

        List<Fruit> method_ref = fruitRepository.findFruit().stream()
                                                .filter(Fruit::isApple)
                                                .filter(Fruit::isGradeA)
                                                .filter(Fruit::over3Kg)
                                                .collect(Collectors.toList());

        assertThat(lambda.size(), is(method_ref.size()));
    }

    @Test
    void 메서드참조vs람다() throws Exception{
        // Given
        List<Fruit> lambda = fruitRepository.findFruit().stream()
                                                .filter(Fruit::isApple)
                                                .filter(Fruit::isGradeA)
                                                .filter(Fruit::over3Kg)
                                                .collect(Collectors.toList());

        // When
        List<Fruit> method_ref = fruitRepository.findFruit().stream()
                                                .filter(x->x.getKind().equals("Apple"))
                                                .filter(x->x.getGrade().equals("A"))
                                                .filter(x->x.getWeight()>=3.0)
                                                .collect(Collectors.toList());

        // Then
        assertThat(lambda.size(), is(method_ref.size()));
    }



    @Test
    void lambda() throws Exception{

        fruitRepository.findFruit().stream()
                .filter(x->x.getKind().equals("Apple"))
                .filter(x->x.getGrade().equals("A"))
                .filter(x->x.getWeight()>=3.0)
                .collect(Collectors.toList());
    }



    @Test
    void staticFruit() throws Exception{
        List<Fruit> fruit = fruitRepository.findFruit();
        int apples = fruit.size();
        int appleGradeA = (int)fruit.stream().filter(Fruit::isApple)
                                             .filter(Fruit::isGradeA)
                                             .count();

        double appleGradeARate = (double) appleGradeA/apples;



    }

}