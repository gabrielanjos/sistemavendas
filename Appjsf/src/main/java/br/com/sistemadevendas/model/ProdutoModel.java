package br.com.sistemadevendas.model;

import java.io.Serializable;


public class ProdutoModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer codigo;
	private String nome;
	private Double valor;
	private String tamanho;
	
	private CategoriaModel categoria;
	private MarcaModel marca;
	

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

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public CategoriaModel getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaModel categoria) {
		this.categoria = categoria;
	}

	public MarcaModel getMarca() {
		return marca;
	}

	public void setMarca(MarcaModel marca) {
		this.marca = marca;
	}

	 @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        ProdutoModel other = (ProdutoModel) obj;
	        if (codigo == null) {
	            if (other.codigo != null)
	                return false;
	        } else if (!codigo.equals(other.codigo))
	            return false;
	        return true;
	    }
	
	@Override
	public String toString() {
		return "ProdutoModel [codigo=" + codigo + ", nome=" + nome + ", valor=" + valor + ", tamanho=" + tamanho
				+ ", categoria=" + categoria + ", marca=" + marca + "]";
	}

}
