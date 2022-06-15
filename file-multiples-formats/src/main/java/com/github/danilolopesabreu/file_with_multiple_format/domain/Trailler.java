package com.github.danilolopesabreu.file_with_multiple_format.domain;

public class Trailler {
	private String tipoRegistro;
	private int numeroTrailler;

	public String getTipoRegistro() {
		return tipoRegistro;
	}

	public void setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	public int getNumeroTrailler() {
		return numeroTrailler;
	}

	public void setNumeroTrailler(int numeroTrailler) {
		this.numeroTrailler = numeroTrailler;
	}

	@Override
	public String toString() {
		return "Trailler [tipoRegistro=" + tipoRegistro + ", numeroTrailler=" + numeroTrailler + "]";
	}

}
