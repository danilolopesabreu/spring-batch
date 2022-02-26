package com.github.danilolopesabreu.filereader.delimitedwidth.step;
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
public class FileReaderDelimitedStepConfig {

	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step stepReadFromFileDelimitedSizeWidth(
			ItemReader<Person> flatFileItemReaderDelimited,
			ItemWriter<Person> fileWriterDelimited) {
		return this.stepBuilderFactory
				.get("stepReadFromFileDelimitedSizeWidth")
				.<Person, Person>chunk(1)
				.reader(flatFileItemReaderDelimited)
				.writer(fileWriterDelimited)
				.build();
	}

}