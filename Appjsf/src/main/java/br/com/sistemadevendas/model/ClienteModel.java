package br.com.sistemadevendas.model;

import java.io.Serializable;

public class ClienteModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer codigo;

	private String nome;
	private String endereco;
	private String dataNascimento;
	private String cpf;
	private String cep;
	private String numero;
	private String telefone;
	

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	 public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        ClienteModel other = (ClienteModel) obj;
	        if (codigo == null) {
	            if (other.codigo != null)
	                return false;
	        } else if (!codigo.equals(other.codigo))
	            return false;
	        return true;
	    }

	@Override
	public String toString() {
		return "ClienteModel [codigo=" + codigo + ", nome=" + nome + ", endereco=" + endereco + ", dataNascimento="
				+ dataNascimento + ", cpf=" + cpf + ", cep=" + cep + ", numero=" + numero + ", telefone=" + telefone
				+ "]";
	}


}
