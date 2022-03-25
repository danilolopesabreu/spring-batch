package com.springbatch.skipexception.dominio;

import java.io.Serializable;
import java.util.Objects;

public class Cliente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private String sobrenome;
	private String idade;
	private String email;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(email, idade, nome, sobrenome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(email, other.email) && Objects.equals(idade, other.idade)
				&& Objects.equals(nome, other.nome) && Objects.equals(sobrenome, other.sobrenome);
	}

	@Override
	public String toString() {
		return "Cliente{" +
	                "nome='" + nome + "'" +
	                ", sobrenome ='" + sobrenome + "'" +
	                ", idade='" + idade + "'" +
	                ", email='" + email + "'" +
	                '}';
	}
}