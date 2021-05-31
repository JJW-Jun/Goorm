//package com.example.batch.part3;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.file.FlatFileItemWriter;
//import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
//import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
//import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
//import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.FileSystemResource;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Configuration
//@Slf4j
//public class ItemWriterConfiguration {
//    private final JobBuilderFactory jobBuilderFactory;
//    private final StepBuilderFactory stepBuilderFactory;
//
//
//    public ItemWriterConfiguration(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
//        this.jobBuilderFactory = jobBuilderFactory;
//        this.stepBuilderFactory = stepBuilderFactory;
//    }
//
//    @Bean
//    public Job itemWriterJob() throws Exception {
//        return this.jobBuilderFactory.get("itemWriterJob")
//                .incrementer(new RunIdIncrementer())
//                .start(this.itemWriterStep())
//                .build();
//    }
//
//    @Bean
//    public Step itemWriterStep() throws Exception {
//        return this.stepBuilderFactory.get("csvItemWriterStep")
//                .<Person, Person>chunk(10)
//                .reader(itemReader())
//                .writer(csvFileItemWriter())
//                .build();
//
//    }
//
//    private ItemWriter<Person> csvFileItemWriter() throws Exception {
//        BeanWrapperFieldExtractor<Person> fieldExtractor = new BeanWrapperFieldExtractor<>();
//        fieldExtractor.setNames(new String[]{"name", "age", "address"});
//        DelimitedLineAggregator<Person> lineAggregator = new DelimitedLineAggregator<>();
//        lineAggregator.setDelimiter(",");
//        lineAggregator.setFieldExtractor(fieldExtractor);
//
//        FlatFileItemWriter<Person> itemWriter = new FlatFileItemWriterBuilder<Person>()
//                .name("csvFileItemWriter")
//                .encoding("UTF-8")
//                .resource(new FileSystemResource("output/test-out.csv"))
//                .lineAggregator(lineAggregator)
//                .headerCallback(writer -> writer.write("id, 'name, age, address"))
//                // 꼭 붙여야ㅕ
//                .footerCallback(writer -> writer.write("--------------------------\n"))
//                .append(true)
//                .build();
//        itemWriter.afterPropertiesSet();
//        return itemWriter;
//    }
//
//    private ItemReader<Person> itemReader() {
//        return new CustomItemReader<>(getItems());
//    }
//
//    private List<Person> getItems() {
//        List<Person> items = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            items.add(new Person(1L, i + "", i + 10, "address"));
//        }
//        return items;
//    }
//
//
//}
