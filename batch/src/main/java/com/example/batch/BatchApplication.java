package com.example.batch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;

import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;


@SpringBootApplication
@EnableBatchProcessing
public class BatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(BatchApplication.class, args);
    }

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;
//    @Autowired
//    private DataSource dataSource;
//    @Bean
//    @Primary
//    public BatchProperties batchProperties() {
//        final String SCHEMA_LOCATION = "classpath:custom_batch_schema-mysql.sql";
//        BatchProperties batchProperties = new BatchProperties();
//        batchProperties.setSchema(SCHEMA_LOCATION);
//
//        return batchProperties;
//    }


//    @Autowired
//    private EntityManagerFactory entityManagerFactory;
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//
//    @Bean
//    public JPAQueryFactory jpaQueryFactory() {
//        return new JPAQueryFactory(entityManager);
//    }

//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;

}