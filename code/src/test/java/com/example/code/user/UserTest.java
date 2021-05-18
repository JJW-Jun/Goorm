package com.example.code.user;

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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


//@Commit
@Transactional
@SpringBootTest
@ContextConfiguration(classes = CodeApplication.class)
class UserTest {
    @Autowired
    UserRepositoryImpl userRepository;
    @Autowired
    EntityManager em;



    @BeforeEach
    void makeEntity() throws Exception {
        User user1 = new User("김태영", "Seoul", 25, "Man");
        User user2 = new User("나경은", "Seoul", 32, "Woman");
        User user3 = new User("나태양", "Busan", 22, "Man");
        User user4 = new User("라지원", "Daegu", 42, "Woman");
        User user5 = new User("문정호", "Seoul", 29, "Man");
        User user6 = new User("변희연", "Busan", 17, "Woman");
        User user7 = new User("성유리", "Seoul", 34, "Woman");
        User user8 = new User("우지원", "Seoul", 25, "Man");
        User user9 = new User("정진우", "Seoul", 33, "Man");
        User user10 = new User("천성주", "Jeju", 22, "Man");
        List<User> users = new ArrayList<>();
        em.persist(user1);
        em.persist(user2);
        em.persist(user3);
        em.persist(user4);
        em.persist(user5);
        em.persist(user6);
        em.persist(user7);
        em.persist(user8);
        em.persist(user9);
        em.persist(user10);
    }

    @Test
    void execute() throws Exception{
        System.out.println("Execution");
    }


    @Test
    void findUser() throws Exception{
        List<User> lambda = userRepository.findUsers().stream()
                                             .filter(User->User.getGender().equals("Man"))
                                             .filter(User->User.getAge()>=20 && User.getAge()<30)
                                             .filter(User->User.getAddress().equals("Seoul"))
                                             .collect(Collectors.toList());


        List<User> method_ref = userRepository.findUsers().stream()
                                              .filter(User::isMan)
                                              .filter(User::is20s)
                                              .filter(User::liveSeoul)
                                              .collect(Collectors.toList());

        assertThat(lambda.size(), is(method_ref.size()));
    }
}