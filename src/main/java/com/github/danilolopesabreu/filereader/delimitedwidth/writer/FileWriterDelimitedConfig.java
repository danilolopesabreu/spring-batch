package com.github.danilolopesabreu.filereader.delimitedwidth.writer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.danilolopesabreu.domain.Person;

@Configuration
public class FileWriterDelimitedConfig {

	@Bean
	public ItemWriter<Person> fileWriterDelimited() {
		return items -> items.forEach(System.out::println);
	}
	
}
