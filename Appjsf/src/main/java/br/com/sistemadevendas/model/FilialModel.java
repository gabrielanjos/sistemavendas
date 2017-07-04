package br.com.sistemadevendas.model;

import java.io.Serializable;

public class FilialModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer codigo;
	private String nome;
	
	

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
	
	 @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        FilialModel other = (FilialModel) obj;
	        if (codigo == null) {
	            if (other.codigo != null)
	                return false;
	        } else if (!codigo.equals(other.codigo))
	            return false;
	        return true;
	    }
	    @Override
	    public String toString() {
	        return "FilialModel [codigo=" + codigo + ", nome=" + nome + "]";
	    }

}
