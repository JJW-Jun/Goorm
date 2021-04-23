package com.example;

import com.example.reflection.BookService;
import com.example.reflection.ReflectionApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = ReflectionApplication.class)
@RunWith(SpringRunner.class)
class BookServiceTest {

    @Autowired
    BookService bookService;

    @Test
    public void di() {
        Assertions.assertNotNull(bookService);
    }


}