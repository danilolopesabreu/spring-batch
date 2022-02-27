package com.github.danilolopesabreu.filereader.delimitedwidth.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.github.danilolopesabreu.domain.Person;

@Configuration
public class FileReaderDelimitedConfig {

	@Bean
	@StepScope
	public FlatFileItemReader<Person> flatFileItemReaderDelimited(
				@Value("#{jobParameters['flatDelimitedFile']}") Resource file
			){
		return new FlatFileItemReaderBuilder<Person>()
					.name("flatFileItemReaderDelimited")
					.resource(file)
					.delimited()
					.names(new String[]{"name", "email", "phone"})
					.targetType(Person.class)
					.build();
	} 
	
}