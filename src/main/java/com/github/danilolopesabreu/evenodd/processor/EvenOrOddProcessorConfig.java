package com.github.danilolopesabreu.evenodd.processor;

import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EvenOrOddProcessorConfig {
	@Bean
	public FunctionItemProcessor<Integer, String> evenOrOddProcessor() {
		return new FunctionItemProcessor<Integer, String>(
				item -> item % 2 == 0 ? String.format("Item %s is Even", item) : String.format("Item %s is Odd", item));
	}
}