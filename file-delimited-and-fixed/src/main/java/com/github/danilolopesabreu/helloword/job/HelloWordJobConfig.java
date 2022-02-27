package com.github.danilolopesabreu.helloword.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class HelloWordJobConfig {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Bean
	public Job jobPrintHello(Step printHelloStep) {
		return jobBuilderFactory
				.get("jobPrintHello")
				.start(printHelloStep)
				.incrementer(new RunIdIncrementer())
				.build();
	}

}
