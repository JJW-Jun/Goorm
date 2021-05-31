package com.example.batch.part3;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemStream;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
@Slf4j
public class ChunkProcessingConfiguration {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    public ChunkProcessingConfiguration(JobBuilderFactory jobBuilderFactory,
                                        StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    public Job chunkProcessingJob() {
        return jobBuilderFactory.get("chunkProcessingJob")
                .incrementer(new RunIdIncrementer())
                .start(chunkBaseStep("50"))
//                .next(this.chunkBaseStep(null))
                .build();
    }

    @Bean
    public Step taskBaseStep() {
        System.out.println("TaskBaseStep================================");
        return stepBuilderFactory.get("taskBaseStep")
                .tasklet(tasklet("30"))
                .build();
    }
    @Bean
    @StepScope
    public Tasklet tasklet(@Value("#{jobParameters[chunkSize]}") String value) {
        System.out.println("Value= "+value+"===========================");
        List<String> items = getItems();
        return (contribution, chunkContext) -> {
            StepExecution stepExecution = contribution.getStepExecution();
            int chunkSize = StringUtils.isNotEmpty(value) ? Integer.parseInt(value) : 10;
            int fromIndex = stepExecution.getReadCount();
            System.out.println("GetReadeCount ="+fromIndex+" / "+chunkSize);
            int toIndex = fromIndex + chunkSize;

            if (fromIndex >= items.size()) {
                return RepeatStatus.FINISHED;
            }
            List<String> subList = items.subList(fromIndex, toIndex);
            log.info("====================================================================");
            log.info("task item size:{}", subList.size());
            stepExecution.setReadCount(toIndex);
            log.info("====================================================================");
            return RepeatStatus.CONTINUABLE;
        };
    }

    private List<String> getItems() {
        List<String> items = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            items.add("hello " + i);
        }
        return items;
    }

    LocalDate localDate = LocalDate.now();


    @Bean
    @JobScope
    public Step chunkBaseStep(@Value("#{jobParameters[chunkSize]}") String chunksize) {
        return stepBuilderFactory.get("chunkBaseStep")
                .<String, String>chunk(StringUtils.isNotEmpty(chunksize) ? Integer.parseInt(chunksize) : 10)
                .reader(itemReader())
                .processor(itemProcessor())
                .writer(itemWriter())
                .build();
    }


    private ItemReader<String> itemReader() {
        // 생성자에 주입
        return new ListItemReader<>(getItems());
    }


    private ItemProcessor<? super String, String> itemProcessor() {
        // 프로세서는 리더의 데이터를 가공하거나 라이터로 연결돌지 말지 결정 ->null은 라이터로 넘어갈 수 없다.
        return item -> item + ", Spring Batch";
    }

    private ItemWriter<? super String> itemWriter() {
        log.info("====================================================================");
        return items -> log.info("chunk item size: {}", items.size());
//        return items->items.forEach(log::info);
    }

//    @Bean
//    @StepScope
//    public Tasklet tasklet(@Value("#{jobParameters[chunkSize]}") String value) {
//        List<String> items = getItems();
//        return ((contribution, chunkContext) -> {
//            // 읽은 아이템 크기를 읽는다 -> 조회도 가능
//            StepExecution stepExecution = contribution.getStepExecution();
//
//            // 방법1
////            JobParameters jobParameters = stepExecution.getJobParameters();
////            String value = jobParameters.getString("chunkSize", "10");
//            int chunkSize = StringUtils.isNotEmpty(value) ? Integer.parseInt(value) : 10;
//
//            int fromIndex = stepExecution.getReadCount();
//            System.out.println("fronIndex= " + fromIndex);
//            int toIndex = fromIndex + chunkSize;
//
//            if (fromIndex >= items.size()) {
//                return RepeatStatus.FINISHED;
//            }
//
////            items.subList(fromIndex, toIndex);
//
//            List<String> subList = items.subList(fromIndex, toIndex);
//
//            log.info("task item size: {}", subList.size());
//
//            stepExecution.setReadCount(toIndex);
//            return RepeatStatus.CONTINUABLE;
//        });
//    }
    // Scope은 항상 bean이어야 한다.
//    private Tasklet tasklet() {
//        List<String> items = getItems();
//        return ((contribution, chunkContext) -> {
//            // 읽은 아이템 크기를 읽는다 -> 조회도 가능
//            StepExecution stepExecution = contribution.getStepExecution();
//
//            // 방법1
//            JobParameters jobParameters = stepExecution.getJobParameters();
//            String value = jobParameters.getString("chunkSize", "10");
//            int chunkSize = StringUtils.isNotEmpty(value) ? Integer.parseInt(value) : 10;
//
//            int fromIndex = stepExecution.getReadCount();
//            System.out.println("fronIndex= " + fromIndex);
//            int toIndex = fromIndex + chunkSize;
//
//            if (fromIndex >= items.size()) {
//                return RepeatStatus.FINISHED;
//            }
//
////            items.subList(fromIndex, toIndex);
//
//            List<String> subList = items.subList(fromIndex, toIndex);
//
//            log.info("task item size: {}", subList.size());
//
//            stepExecution.setReadCount(toIndex);
//            return RepeatStatus.CONTINUABLE;
//        });
//    }

    //    @Bean
//    public Job chunkProcessingJob() {
//        return jobBuilderFactory.get("chunkProcessingJob")
//                .incrementer(new RunIdIncrementer())
//                .start(this.taskBaseStep())
//                .next(this.chunkBaseStep())
//                .build();
//    }

//    @Bean
//    public Step taskBaseStep() {
//        return stepBuilderFactory.get("taskBaseStep")
//                .tasklet(this.tasklet())
//                .build();
//    }

//    @Bean
//    public Step chunkBaseStep() {
//        return stepBuilderFactory.get("chunkBaseStep")
//                .<String, String>chunk(10)
//                .reader(itemReader())
//                .processor(itemProcessor())
//                .writer(itemWriter())
//                .build();
//    }

}
