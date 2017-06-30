package br.com.sistemadevendas.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProdutoModel implements Serializable {
	
	private int codigo;
	private String nome;
	private Double valor;
	private String tamanho;
	
	private CategoriaModel categoria;
	private MarcaModel marca;
	
	public ProdutoModel(){}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
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

	public void setMarcaModel(MarcaModel marca) {
		this.marca = marca;
	}
	
	
	
	

}
