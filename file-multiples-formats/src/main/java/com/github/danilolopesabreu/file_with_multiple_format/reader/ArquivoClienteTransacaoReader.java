package com.github.danilolopesabreu.file_with_multiple_format.reader;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;

import com.github.danilolopesabreu.file_with_multiple_format.domain.Cliente;
import com.github.danilolopesabreu.file_with_multiple_format.domain.ClientesAgrupados;
import com.github.danilolopesabreu.file_with_multiple_format.domain.Header;
import com.github.danilolopesabreu.file_with_multiple_format.domain.Trailler;
import com.github.danilolopesabreu.file_with_multiple_format.domain.Transacao;

public class ArquivoClienteTransacaoReader implements ItemStreamReader<ClientesAgrupados> {
	private Object objAtual;
	private ItemStreamReader<ClientesAgrupados> delegate;
	private ClientesAgrupados clientesAgrupados = new ClientesAgrupados();
	
	public ArquivoClienteTransacaoReader(ItemStreamReader<ClientesAgrupados> delegate) {
		this.delegate = delegate;
	}
	
	@Override
	public void open(ExecutionContext executionContext) throws ItemStreamException {
		delegate.open(executionContext);
	}

	@Override
	public void update(ExecutionContext executionContext) throws ItemStreamException {
		delegate.update(executionContext);
	}

	@Override
	public void close() throws ItemStreamException {
		delegate.close();
	}

	@Override
	public ClientesAgrupados read() throws Exception {
		objAtual = delegate.read();
//
//		Cliente cliente = (Cliente) objAtual;
//		objAtual = null;
//		
//		if (cliente != null) {
//			while (peek() instanceof Transacao)
//				cliente.getTransacoes().add((Transacao) objAtual);
//		}
//		
//		return cliente;
		
		if(isObjectCliente(objAtual)) {
			Cliente cliente = (Cliente) objAtual;
			clientesAgrupados.setCliente(cliente);
		}
		
		if(isObjectTransacao(objAtual) && clientesAgrupados.getCliente() != null) {
			clientesAgrupados.getCliente().getTransacoes().add((Transacao)objAtual);
		}
		
		if(isObjectHeader(objAtual)) {
			clientesAgrupados.setHeader((Header) objAtual);
		}
		
		if(isObjectTrailler(objAtual)) {
			clientesAgrupados.setTrailler((Trailler)objAtual);
		}
		
		if(objAtual == null)//base case
			return null;
		
		return clientesAgrupados;
	}
	
	private void setTransacaoCliente(Cliente cliente) throws Exception {
		while (peek() instanceof Transacao) {
			cliente.getTransacoes().add((Transacao) objAtual);
		}
	}

	private Object peek() throws Exception {
		objAtual = delegate.read();
		return objAtual;
	}
	
	private boolean isObjectTransacao(Object obj) {
		return obj instanceof Transacao;
	}
	
	private boolean isObjectHeader(Object obj) {
		return obj instanceof Header;
	}

	private boolean isObjectTrailler(Object obj) {
		return obj instanceof Trailler;
	}
	
	private boolean isObjectCliente(Object obj) {
		return obj instanceof Cliente;
	}
}
