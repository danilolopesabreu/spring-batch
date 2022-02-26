package com.github.danilolopesabreu.filereader.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.github.danilolopesabreu.domain.Person;

@Configuration
public class FileReaderConfig {

	@Bean
	@StepScope
	public FlatFileItemReader<Person> flatFileItemReader(
				@Value("#{jobParameters['flatFile']}") Resource file
			){
		return new FlatFileItemReaderBuilder<Person>()
					.name("flatFileItemReader")
					.resource(file)
					.fixedLength()
					.columns(new Range[]{new Range(1,20), new Range(21,40), new Range(41,60)})
					.names(new String[]{"name", "email", "phone"})
					.targetType(Person.class)
					.build();
	} 
	
}