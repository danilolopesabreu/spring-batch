package com.github.danilolopesabreu.file_with_multiple_format.reader;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.mapping.PatternMatchingCompositeLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.FixedLengthTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.danilolopesabreu.file_with_multiple_format.domain.Cliente;
import com.github.danilolopesabreu.file_with_multiple_format.domain.Header;
import com.github.danilolopesabreu.file_with_multiple_format.domain.Trailler;
import com.github.danilolopesabreu.file_with_multiple_format.domain.Transacao;

@Configuration
public class ClienteTransacaoLineMapperConfig {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public PatternMatchingCompositeLineMapper lineMapper() {
		PatternMatchingCompositeLineMapper lineMapper = new PatternMatchingCompositeLineMapper<>();
		lineMapper.setTokenizers(tokenizers());
		lineMapper.setFieldSetMappers(fieldSetMappers());
		return lineMapper;
	}

	@SuppressWarnings("rawtypes")
	private Map<String, FieldSetMapper> fieldSetMappers() {
		Map<String, FieldSetMapper> fieldSetMappers = new HashMap<>();
		fieldSetMappers.put("0*", fieldSetMapper(Cliente.class));
		fieldSetMappers.put("1*", fieldSetMapper(Transacao.class));
		fieldSetMappers.put("H*", fieldSetMapper(Header.class));
		fieldSetMappers.put("T*", fieldSetMapper(Trailler.class));
		return fieldSetMappers;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private FieldSetMapper fieldSetMapper(Class classe) {
		BeanWrapperFieldSetMapper fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(classe);
		return fieldSetMapper;
	}

	/**
	 * identify the pattern between lines 
	 * */
	private Map<String, LineTokenizer> tokenizers() {
		Map<String, LineTokenizer> tokenizers = new HashMap<>();
		tokenizers.put("0*", clienteLineTokenizer());
		tokenizers.put("1*", transacaoLineTokenizer());
		tokenizers.put("H*", headerLineTokenizer());
		tokenizers.put("T*", traillerLineTokenizer());
		return tokenizers;
	}

	private LineTokenizer headerLineTokenizer() {
		FixedLengthTokenizer lineTokenizer = new FixedLengthTokenizer();
		lineTokenizer.setColumns(new Range[]{new Range(1,1), new Range(2,7), new Range(8,10)});
		lineTokenizer.setNames("tipoRegistro","nomeHeader","numeroHeader");
		return lineTokenizer;
	}

	private LineTokenizer traillerLineTokenizer() {
		FixedLengthTokenizer lineTokenizer = new FixedLengthTokenizer();
		lineTokenizer.setColumns(new Range[]{new Range(1,1), new Range(2,4)});
		lineTokenizer.setNames("tipoRegistro","numeroTrailler");
		return lineTokenizer;
	}

	private LineTokenizer clienteLineTokenizer() {
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();//the file is delimited
		lineTokenizer.setNames("nome", "sobrenome", "idade", "email");
		lineTokenizer.setIncludedFields(1, 2, 3, 4);//jumpin the first 0
		return lineTokenizer;
	}
	
	private LineTokenizer transacaoLineTokenizer() {
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames("id", "descricao", "valor");
		lineTokenizer.setIncludedFields(1, 2, 3);
		return lineTokenizer;
	}
}
