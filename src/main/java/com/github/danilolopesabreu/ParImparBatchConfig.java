package com.github.danilolopesabreu;

import java.util.Arrays;
import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class ParImparBatchConfig {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job jobPrintParImpar() {
		return jobBuilderFactory
				.get("jobPrintParImpar")
				.start(printParImparStep())
				.incrementer(new RunIdIncrementer())
				.build();
	}

	private Step printParImparStep() {
		return this.stepBuilderFactory
				.get("printParImparStep")
				.<Integer, String>chunk(1)
				.reader(itemReader())
				.processor(itemProcessor())
				.writer(itemWriter())
				.build();
	}
	
	private IteratorItemReader<Integer> itemReader() {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		return new IteratorItemReader<Integer>(list.iterator());
	}

	private FunctionItemProcessor<Integer, String> itemProcessor() {
		return new FunctionItemProcessor<Integer, String>(
				item -> item % 2 == 0 ? String.format("Item %s é par", item) : String.format("Item %s é impar", item));
	}
	
	private ItemWriter<String> itemWriter() {
		return itens -> itens.forEach(System.out::println);
	}

}
