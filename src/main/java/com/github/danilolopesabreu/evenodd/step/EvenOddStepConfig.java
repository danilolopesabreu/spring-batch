package com.github.danilolopesabreu.evenodd.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class EvenOddStepConfig {

	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step printEvenOddStep(
			ItemReader<Integer> countUntilTenReader,
			ItemProcessor<Integer, String> evenOrOddProcessor, 
			ItemWriter<String> printWriter) {
		return this.stepBuilderFactory
				.get("printParImparStep")
				.<Integer, String>chunk(1)
				.reader(countUntilTenReader)
				.processor(evenOrOddProcessor)
				.writer(printWriter)
				.build();
	}

}
