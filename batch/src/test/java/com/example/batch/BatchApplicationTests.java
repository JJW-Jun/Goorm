package com.example.batch;

import com.example.batch.part3.SavePersonConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

@Configuration
@EnableBatchProcessing
@EnableAutoConfiguration
class BatchApplicationTests {

    @Test
    void contextLoads() {
    }

}
