package com.example.batch.miniproject1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration @Slf4j
public class MemberConfiguration {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    public MemberConfiguration(JobBuilderFactory jobBuilderFactory,
                                        StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    public Job job(MemberJob){
        return this.jobBuilderFactory.get("MemberJob")
                .incrementer(new RunIdIncrementer())
                .start(this.saveMemberStep())
                .build()
    }

    @Bean
    public Step step(){
        return this.stepBuilderFactory.get("saveMemberStep")
                .chunk()
                .reader()
                .processor()
                .writer()
                .build();
    }

}
