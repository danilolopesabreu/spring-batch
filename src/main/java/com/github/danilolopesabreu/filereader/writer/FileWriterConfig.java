package com.github.danilolopesabreu.filereader.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.danilolopesabreu.domain.Person;

@Configuration
public class FileWriterConfig {

	@Bean
	public ItemWriter<Person> fileWriter() {
		return items -> items.forEach(System.out::println);
	}
	
}
