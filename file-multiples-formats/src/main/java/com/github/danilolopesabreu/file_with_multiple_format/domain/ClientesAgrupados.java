package com.github.danilolopesabreu.file_with_multiple_format.domain;

import java.util.ArrayList;
import java.util.List;

public class ClientesAgrupados {
	private Header header;
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private Trailler trailler;

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Trailler getTrailler() {
		return trailler;
	}

	public void setTrailler(Trailler trailler) {
		this.trailler = trailler;
	}

	@Override
	public String toString() {
		return "ClientesAgrupados [header=" + header + ", clientes=" + clientes + ", trailler=" + trailler + "]";
	}

}
