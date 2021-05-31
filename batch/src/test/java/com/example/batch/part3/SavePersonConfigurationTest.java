package com.example.batch.part3;

import com.example.batch.BatchApplication;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.ContextConfiguration;

@SpringBatchTest
@ContextConfiguration(classes = {BatchApplication.class, TestConfiguration.class})
class SavePersonConfigurationTest {
    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;
    @Autowired
    JobBuilderFactory jobBuilderFactory;

    @Autowired
    PersonRepository repository;

    @After
    void tearDown() throws Exception {
        repository.deleteAll();
    }

    @Test
    void test_step() {
        JobExecution jobExecution = jobLauncherTestUtils.launchStep("savePersonStep");
        Assertions.assertThat(jobExecution.getStepExecutions().stream()
                .mapToInt(StepExecution::getWriteCount)
                .sum())
                .isEqualTo(repository.count())
                .isEqualTo(3);
    }

    @Test
    void test_allow_duplicate() throws Exception {

        JobParameters jobParameters = new JobParametersBuilder()
                .addString("allow_duplictate", "false")
                .toJobParameters();

        JobExecution jobExecution = jobLauncherTestUtils.launchJob(jobParameters);


        Assertions.assertThat(jobExecution.getStepExecutions().stream()
                .mapToInt(StepExecution::getWriteCount)
                .sum())
                .isEqualTo(repository.count())
                .isEqualTo(3);

    }

    @Test
    void test_not_allow_duplicate() throws Exception {

        JobParameters jobParameters = new JobParametersBuilder()
                .addString("allow_duplictate", "true")
                .toJobParameters();

        JobExecution jobExecution = jobLauncherTestUtils.launchJob(jobParameters);


        Assertions.assertThat(jobExecution.getStepExecutions().stream()
                .mapToInt(StepExecution::getWriteCount)
                .sum())
                .isEqualTo(repository.count())
                .isEqualTo(100);
    }
}