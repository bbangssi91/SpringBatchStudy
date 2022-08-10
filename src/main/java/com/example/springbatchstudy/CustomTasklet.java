package com.example.springbatchstudy;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class CustomTasklet implements Tasklet {

    private long sum;
    private Object object = new Object();

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {

        synchronized (object){
            for(int i = 0; i < 100000000; i++){
                sum++;
            }

            System.out.println(" == > Thread :: " + Thread.currentThread().getName() + " == > StepName :: " + stepContribution.getStepExecution().getStepName());
            System.out.println(" == > Sum :: " + sum);
        }

        return RepeatStatus.FINISHED;
    }
}
