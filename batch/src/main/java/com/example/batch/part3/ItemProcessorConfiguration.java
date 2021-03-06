package com.example.batch.part3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Slf4j
public class ItemProcessorConfiguration {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;


    public ItemProcessorConfiguration(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    public Job itemProcessorJob() {
        return jobBuilderFactory.get("itemProcessorJob")
                .incrementer(new RunIdIncrementer())
                .start(this.itemProcessorStep())
                .build();
    }


    @Bean
    public Step itemProcessorStep() {
        return this.stepBuilderFactory.get("itemProcessorStep")
                .<Person, Person>chunk(10)
                .reader(itemReader())
                .processor(itemProcessor())
                .writer(itemWriter())
                .build();
    }



    private ItemWriter<Person> itemWriter() {
        log.info("====================================================================");
        return items -> items.forEach(x -> log.info("PERSON.ID:{}", x.getId()));

    }




    private ItemProcessor<Person, Person> itemProcessor() {
        return person -> {
            if (person.getId() % 2 == 0) {
                System.out.println("item= " + person.getId());
                return person;
            }
            return null;
        };
    }

    private ItemReader<Person> itemReader() {
        return new CustomItemReader<>(getItems());
    }

    private List<Person> getItems() {
        List<Person> items = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            items.add(new Person(1L, "name ", i + 10, "서울"));
        }
        System.out.println("Person.size()= " + items.size());
        return items;
    }


}
