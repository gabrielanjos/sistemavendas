package br.com.sistemadevendas.repository.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="tb_produto")

@NamedQueries({
 
	@NamedQuery(name = "ProdutoEntity.findAll",query= "SELECT p FROM ProdutoEntity p")
 
})
public class ProdutoEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "id_produto")
	private Integer codigo;
	
	@Column(name = "nm_nome")
	private String nome;
	
	@Column(name = "nm_valor")
	private Double valor;
	
	@Column(name = "nm_tamanho")
	private String tamanho;
	
	@OneToOne
	@JoinColumn(name="id_produto_categoria")
	private CategoriaEntity categoria;
	
	@OneToOne
	@JoinColumn(name="id_produto_marca")
	private MarcaEntity marca;
	
	

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

	public CategoriaEntity getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEntity categoria) {
		this.categoria = categoria;
	}

	public MarcaEntity getMarca() {
		return marca;
	}

	public void setMarca(MarcaEntity marca) {
		this.marca = marca;
	}
	
	
	
	

}
