package com.github.danilolopesabreu.file_with_multiple_format.domain;

public class Header {
	private String tipoRegistro;
	private String nomeHeader;
	private int numeroHeader;

	public String getTipoRegistro() {
		return tipoRegistro;
	}

	public void setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	public String getNomeHeader() {
		return nomeHeader;
	}

	public void setNomeHeader(String nomeHeader) {
		this.nomeHeader = nomeHeader;
	}

	public int getNumeroHeader() {
		return numeroHeader;
	}

	public void setNumeroHeader(int numeroHeader) {
		this.numeroHeader = numeroHeader;
	}

	@Override
	public String toString() {
		return "Header [tipoRegistro=" + tipoRegistro + ", nomeHeader=" + nomeHeader + ", numeroHeader=" + numeroHeader
				+ "]";
	}
	
}
