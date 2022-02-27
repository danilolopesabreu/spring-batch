package com.github.danilolopesabreu.evenodd.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrintWriterConfig {
	@Bean
	public ItemWriter<String> printWriter() {
		return items -> items.forEach(System.out::println);
	}
}