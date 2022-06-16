package com.github.danilolopesabreu.file_with_multiple_format.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.danilolopesabreu.file_with_multiple_format.domain.ClientesAgrupados;

@Configuration
public class ProcessadorConfig {

	@Bean
	public ItemProcessor<ClientesAgrupados, ClientesAgrupados> processarClientesAgrupados(ClientesAgrupados item) throws Exception {
		System.out.println(" processando - "+item);
		
		return null;
	}

}
