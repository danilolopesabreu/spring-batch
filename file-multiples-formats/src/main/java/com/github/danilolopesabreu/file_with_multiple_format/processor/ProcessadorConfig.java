package com.github.danilolopesabreu.file_with_multiple_format.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.danilolopesabreu.file_with_multiple_format.domain.ClientesAgrupados;
import com.github.danilolopesabreu.file_with_multiple_format.domain.Header;

@Configuration
public class ProcessadorConfig {

	@Bean
	public ItemProcessor<ClientesAgrupados, ClientesAgrupados> processarClientesAgrupados() throws Exception {
		System.out.println(" processando - ");
		ValidatingItemProcessor<ClientesAgrupados> processor = new ValidatingItemProcessor<ClientesAgrupados>();
		processor.setValidator(validator());
		return processor;
	}

	private Validator<ClientesAgrupados> validator() {
		return new Validator<ClientesAgrupados>() {
			private Header header;
			@Override
			public void validate(ClientesAgrupados clienteAgrupado) throws ValidationException {
				
				if(clienteAgrupado.getHeader() != null)
					this.header = clienteAgrupado.getHeader();
				
				System.out.println(" validando "+clienteAgrupado);
				
			}
			
		};
	}

}
