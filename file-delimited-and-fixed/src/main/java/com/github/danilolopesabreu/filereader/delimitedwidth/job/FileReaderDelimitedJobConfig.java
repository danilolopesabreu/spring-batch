package com.github.danilolopesabreu.filereader.delimitedwidth.job;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class FileReaderDelimitedJobConfig {
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Bean
	public Job jobReadFromFileDelimited(Step stepReadFromFileDelimitedSizeWidth) {
		return jobBuilderFactory
				.get("jobReadFromFileDelimited")
				.start(stepReadFromFileDelimitedSizeWidth)
				.incrementer(new RunIdIncrementer())
				.build();
	}
}