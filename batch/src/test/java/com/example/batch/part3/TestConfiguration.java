package com.example.batch.part3;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration @EnableBatchProcessing
@EnableAutoConfiguration
public class TestConfiguration {

    @Autowired(required = true)
    JobBuilderFactory jobBuilderFactory;

    @Bean(autowireCandidate = true)
    public JobLauncherTestUtils jobLauncherUtils() {
        return new JobLauncherTestUtils();
    }

}