package com.example.batch.part3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.JpaCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.database.builder.JpaCursorItemReaderBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Configuration
public class ItemReaderConfiguration {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final DataSource dataSource;
    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    // input타입은 아이템 리더ㅣㅇ세ㅓ 리턴하고 아이템프로세서에서 받아서 아웃풋으로 변환후 데이터를 못아서 아웃풋타입의 리스트를 아이템 라이터에 전달한다.
    public ItemReaderConfiguration(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory
            , DataSource dataSource, EntityManagerFactory entityManagerFactory, EntityManager entityManager) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.dataSource = dataSource;
        this.entityManagerFactory = entityManagerFactory;
        this.entityManager = entityManager;
    }

    @Bean
    public Job itemReaderJob() throws Exception {
        System.out.println("Job 실행");
        return this.jobBuilderFactory.get("itemReaderJob")
                .incrementer(new RunIdIncrementer())
                .start(this.customItemReaderStep())
//                .next(this.jdbcStep())
//                .next(this.csvFileStep())
                .next(this.jpaStep())
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

    private ItemWriter<Person> itemWriter() {
        return items -> log.info(items.stream()
                .map(Person::toString)
                .collect(Collectors.joining(", ")));
    }

    private List<Person> getItems() {
        List<Person> items = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            items.add(new Person(1L, "Test ", i + 10, "서울"));
        }
        return items;
    }

    private FlatFileItemReader<Person> csvFileItemReader() throws Exception {
        DefaultLineMapper<Person> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setNames("id", "name", "age", "address");
        lineMapper.setLineTokenizer(tokenizer);
        System.out.println("=======================Token============================");
        lineMapper.setFieldSetMapper(fieldSet -> {
            Long id = fieldSet.readLong("id");
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

        itemReader.afterPropertiesSet();
        return itemReader;

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
        System.out.println("================================================================");
        return stepBuilderFactory.get("jdbcStep")
                .<Person, Person>chunk(10)
                .reader(jdbcCursorItemReader())
                .writer(itemWriter())
                .build();
    }

    private JdbcCursorItemReader<Person> jdbcCursorItemReader() throws Exception {
        System.out.println("=======================Query==========================");
        JdbcCursorItemReader<Person> itemReader = new JdbcCursorItemReaderBuilder<Person>()
                .name("jdbcCursorItemReader")
                .dataSource(dataSource)
                .sql("select id, name, age, address from person")
                .rowMapper((rs, rowNum) -> new Person(
                        rs.getLong(1),
                        rs.getString(2), rs.getInt(3), rs.getString(4)
                )).build();

        itemReader.afterPropertiesSet();
        return itemReader;
    }


    @Bean
    public Step jpaStep() throws Exception {
        return stepBuilderFactory.get("jpaStep")
                .<Person, Person>chunk(10)
                .reader(this.jpaCursorItemReader())
                .writer(itemWriter())
                .build();
    }

    private JpaCursorItemReader<Person> jpaCursorItemReader() throws Exception {
        JpaCursorItemReader<Person> itemReader = new JpaCursorItemReaderBuilder<Person>()
                .name("jpaCursorItemReader")
                .entityManagerFactory(entityManagerFactory)
                .queryString("select p from Person p")
                .build();
        itemReader.afterPropertiesSet();
        return itemReader;
    }

}


//    @Bean
//    public Job item() throws Exception {
//        System.out.println("This is the test");
//        return this.jobBuilderFactory.get("itemReaderJob")
//                .incrementer(new RunIdIncrementer())
//                .start(this.customItemReaderStep())
//                .next(this.csvFileStep())
//                .build();
//    }

//


//    @Bean
//    public Step jdbcBatchItemWriterStep(){
//        return stepBuilderFactory.get("jdbcBatchItemWriterStep")
//                .<Person, Person>chunk(10)
//                .reader(itemReader())
//                .writer(jdbcBatchItemWriter())
//                .build();
//
//    }

//    private ItemWriter<? super Person> jdbcBatchItemWriter() {
//        JdbcBatchItemWriter<Person> jdbcBatchItemWriter = new JdbcBatchItemWriterBuilder<Person>()
//                .dataSource(dataSource)
//                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
//                .sql("insert into person(name, age, address) values(:name, :age, :address")
//                .build();
//
//        jdbcBatchItemWriter.afterPropertiesSet();
//        return jdbcBatchItemWriter;
//
//    }


//
//        FlatFileItemReader<Person> itemReader = new FlatFileItemReaderBuilder<Person>()
//                .name("csvFileItemReader")
//                .encoding("UTF-8")
//                .resource(new ClassPathResource("test.csv"))
//                .linesToSkip(1)
//                .lineMapper(lineMapper)
//                .build();
//
//        itemReader.afterPropertiesSet();//필드명 스킵
//        return itemReader;
//
//    }


