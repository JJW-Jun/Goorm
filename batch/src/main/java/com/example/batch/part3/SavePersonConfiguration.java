//package com.example.batch.part3;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.JobScope;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.database.JpaItemWriter;
//import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
//import org.springframework.batch.item.file.mapping.DefaultLineMapper;
//import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
//import org.springframework.batch.item.support.CompositeItemWriter;
//import org.springframework.batch.item.support.builder.CompositeItemWriterBuilder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//
//import javax.persistence.EntityManager;
//
//@Configuration
//@Slf4j
//public class SavePersonConfiguration {
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    private StepBuilderFactory stepBuilderFactory;
//    private EntityManager entityManager;
//
//
//
//    @Bean
//    public Job savePersonJob() throws Exception {
//        return this.jobBuilderFactory.get("savePersonJob")
//                .incrementer(new RunIdIncrementer())
//                .start(this.savePersonStep(null))
//                .build();
//    }
//
//    @Bean
//    @JobScope
//    public Step savePersonStep(@Value("#{jobParameters[allow_duplicate]}") String allowDuplicates) throws Exception {
//        return this.stepBuilderFactory.get("savePersonStep")
//                .<Person, Person>chunk(10)
//                .reader(itemReader())
//                .processor((ItemProcessor<Person, Person>) new DuplicationValidationProcessor<>(Person::getName, false))
//                .writer(itemWriter())
//                .build();
//
//    }
//
//    private ItemWriter<? super Person> itemWriter() throws Exception {
////        items -> items.forEach(x -> log.info("저는 {} 입니다.", x.getName()));
//        JpaItemWriter<Person> jpaItemWriter = new JpaItemWriterBuilder<Person>()
//                .entityManagerFactory(entityManager.getEntityManagerFactory())
//                .build();
//        ItemWriter<Person> logItemWriter = items -> log.info("personsize= {}", items.size());
//        var compositeItemWriter = new CompositeItemWriterBuilder<Person>()
//                .delegates(jpaItemWriter)
//                .build();
//        compositeItemWriter.afterPropertiesSet();
//        return compositeItemWriter;
//    }
//
//
//    private ItemReader<Person> itemReader() throws Exception {
//        DefaultLineMapper<Person> lineMapper = new DefaultLineMapper<>();
//        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
//        lineTokenizer.setNames("name", "age", "address");
//        lineMapper.setLineTokenizer(lineTokenizer);
//        lineMapper.setFieldSetMapper(fieldSet -> new Person(
//                fieldSet.readString(0),
//                fieldSet.readInt(1),
//                fieldSet.readString(2)
//        ));
//        FlatFileItemReader<Person> itemReader = new FlatFileItemReaderBuilder<Person>()
//                .name("savePersonItemReader")
//                .encoding("UTF-8")
//                .linesToSkip(1)
//                .resource(new ClassPathResource("person.csv"))
//                .lineMapper(lineMapper)
//                .build();
//        itemReader.afterPropertiesSet();
//        return itemReader;
//    }
//
//
//}
