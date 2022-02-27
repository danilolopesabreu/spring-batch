package com.github.danilolopesabreu.helloword.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Qualifier("helloWordTasklet")
@Component
@StepScope
public class HelloWordTasklet implements Tasklet {
	
	@Value("#{jobParameters['name']}")
	private String name;
	
	public HelloWordTasklet() {}
	
//	public HelloWordTasklet(@Value("#{jobParameters['name']}") String name) {
//		this.name = name;
//	}
	
	
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
//		System.out.println("Hello: "+this.name);
		System.out.println("Hello !!..."+name);
		return RepeatStatus.FINISHED;
	}
}
