package com.github.danilolopesabreu.file_with_multiple_format.domain;

public class ClientesAgrupados {
	private Header header;
	private Cliente cliente;
	private Trailler trailler;

	public Header getHeader() {
		return header;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public Trailler getTrailler() {
		return trailler;
	}

	public void setTrailler(Trailler trailler) {
		this.trailler = trailler;
	}

	@Override
	public String toString() {
		return "ClientesAgrupados [header=" + header + ", cliente=" + cliente + ", trailler=" + trailler + "]";
	}

}
