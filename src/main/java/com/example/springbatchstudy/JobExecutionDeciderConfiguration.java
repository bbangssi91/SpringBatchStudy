package com.example.springbatchstudy;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class JobExecutionDeciderConfiguration {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job batchJob(){
        return jobBuilderFactory.get("batchJob")
                .incrementer(new RunIdIncrementer())
                .start(step())
                .next(decider())
                .from(decider()).on("ODD").to(oddStep())
                .from(decider()).on("EVEN").to(evenStep())
                .end()
                .build();
    }

    @Bean
    public JobExecutionDecider decider() {
        return new CustomDecider();
    }


    @Bean
    public Step step() {
        System.out.println("===> Step Executed");

        return stepBuilderFactory.get("step")
                .tasklet((stepContribution, chunkContext) -> RepeatStatus.FINISHED)
                .build();
    }

    @Bean
    public Step evenStep() {
        System.out.println("===> evenStep Executed");

        return stepBuilderFactory.get("evenStep")
                .tasklet((stepContribution, chunkContext) -> RepeatStatus.FINISHED)
                .build();
    }

    @Bean
    public Step oddStep() {
        System.out.println("===> oddStep Executed");

        return stepBuilderFactory.get("oddStep")
                .tasklet((stepContribution, chunkContext) -> RepeatStatus.FINISHED)
                .build();
    }

}
