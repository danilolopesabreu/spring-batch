package com.github.danilolopesabreu.file_with_multiple_format.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.danilolopesabreu.file_with_multiple_format.domain.ClientesAgrupados;
import com.github.danilolopesabreu.file_with_multiple_format.reader.ArquivoClienteTransacaoReader;

@Configuration
public class LeituraArquivoMultiplosFormatosStepConfig {
	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@SuppressWarnings({"unchecked", "rawtypes"})
	@Bean
	public Step leituraArquivoMultiplosFormatosStep(
			FlatFileItemReader<ClientesAgrupados> arquivoMultiplosFormatosItemReader,
			ItemProcessor<ClientesAgrupados, ClientesAgrupados> processarClientesAgrupados,
			ItemWriter<ClientesAgrupados> leituraArquivoMultiplosFormatosItemWriter) {
		return stepBuilderFactory
				.get("leituraArquivoMultiplosFormatosStep")
				.<ClientesAgrupados, ClientesAgrupados> chunk(3)
				.reader(new ArquivoClienteTransacaoReader(arquivoMultiplosFormatosItemReader))
				.processor(processarClientesAgrupados)
				.writer(leituraArquivoMultiplosFormatosItemWriter)
				.build();
	}
}
