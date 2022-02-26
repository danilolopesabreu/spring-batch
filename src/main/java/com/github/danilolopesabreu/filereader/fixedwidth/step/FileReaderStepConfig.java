package com.github.danilolopesabreu.filereader.fixedwidth.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.danilolopesabreu.domain.Person;

@EnableBatchProcessing
@Configuration
public class FileReaderStepConfig {

	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step stepReadFromFileFixedSizeWidth(
			ItemReader<Person> flatFileItemReader,
			ItemWriter<Person> fileWriter) {
		return this.stepBuilderFactory
				.get("stepReadFromFileFixedSizeWidth")
				.<Person, Person>chunk(1)
				.reader(flatFileItemReader)
				.writer(fileWriter)
				.build();
	}

}
