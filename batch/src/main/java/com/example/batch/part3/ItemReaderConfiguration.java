package com.example.batch.part3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

@Slf4j
@Configuration
public class ItemReaderConfiguration {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final DataSource dataSource;


    public ItemReaderConfiguration(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory
            , DataSource dataSource) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.dataSource = dataSource;
    }

    @Bean
    public Job itemReaderJob() throws Exception {
        System.out.println("Job 실행");
        return this.jobBuilderFactory.get("itemReaderJob")
                .incrementer(new RunIdIncrementer())
                .start(this.customItemReaderStep())
                .next(this.csvFileStep())
//                .next(this.jdbcStep())
                .build();
    }

    @Bean
    public Step customItemReaderStep() {
        return this.stepBuilderFactory.get("customItemReaderStep")
                .<Person, Person>chunk(10)
                .reader(new CustomItemReader<>(getItems()))
                .writer(itemWriter())
                .build();

    }


    @Bean
    public Step csvFileStep() throws Exception {
        return stepBuilderFactory.get("csvFileStep")
                .<Person, Person>chunk(10)
                .reader(this.csvFileItemReader())
                .writer(itemWriter())
                .build();
    }

    @Bean
    public Step jdbcStep() throws Exception {
        System.out.println("================");
        return stepBuilderFactory.get("jdbcStep")
                .<Person, Person>chunk(10)
                .reader(jdbcCursorItemReader())
                .writer(itemWriter())
                .build();
    }

    private JdbcCursorItemReader<Person> jdbcCursorItemReader() throws Exception {
        JdbcCursorItemReader<Person> itemReader = new JdbcCursorItemReaderBuilder<Person>()
                .name("jdbcCursorItemReader")
                .dataSource(dataSource)
                .sql("select id, name, age, address from person")
                .rowMapper((rs, rowNum) -> new Person(
                        rs.getLong(1), rs.getString(2), rs.getInt(3), rs.getString(4)
                )).build();

        itemReader.afterPropertiesSet();
        return itemReader;
    }


    private FlatFileItemReader<Person> csvFileItemReader() throws Exception {
        DefaultLineMapper<Person> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setNames("id", "name", "age", "address");
        lineMapper.setLineTokenizer(tokenizer);

        lineMapper.setFieldSetMapper(fieldSet -> {
            long id = fieldSet.readInt("id");
            String name = fieldSet.readString("name");
            int age = fieldSet.readInt("age");
            String address = fieldSet.readString("address");
            return new Person(id, name, age, address);
        });

        FlatFileItemReader<Person> itemReader = new FlatFileItemReaderBuilder<Person>()
                .name("csvFileItemReader")
                .encoding("UTF-8")
                .resource(new ClassPathResource("test.csv"))
                .linesToSkip(1)
                .lineMapper(lineMapper)
                .build();

        itemReader.afterPropertiesSet();//필드명 스킵
        return itemReader;

    }

    private ItemWriter<Person> itemWriter() {
        return items -> log.info(items.stream()
                .map(Person::getName)
                .collect(Collectors.joining(", ")));
    }

    private List<Person> getItems() {
        List<Person> items = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            items.add(new Person(i + 1L, "name ", i + 10, "서울"));
        }

        return items;
    }


}
