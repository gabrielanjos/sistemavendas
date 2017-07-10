package br.com.sistemadevendas.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_venda")
 
@NamedQueries({
 
	@NamedQuery(name = "VendaEntity.findAll",query= "SELECT p FROM VendaEntity p")
 
})
public class VendaEntity  {
	
	
	@Id
	@GeneratedValue
	@Column(name = "id_venda")
	private Integer codigo;
	@Column(name = "quantidade")
	private int  quantidade;
	@OneToOne
	@JoinColumn(name="id_cliente")
	private ClienteEntity cliente;
	@OneToOne
	@JoinColumn(name="id_produto")
	private ProdutoEntity produto;
	@Column(name = "data_venda")
	private String dataVenda;
	@Column(name = "forma_pagamento")
	private String formaPagamento;
	@Column(name = "usuario_logado")
	private String usuario;
	@Column(name = "valor_venda")
	private double valor;

	
	

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public ProdutoEntity getProduto() {
		return produto;
	}

	public void setProduto(ProdutoEntity produto) {
		this.produto = produto;
	}

	public String getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(String dataVenda) {
		this.dataVenda = dataVenda;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	
	

}
