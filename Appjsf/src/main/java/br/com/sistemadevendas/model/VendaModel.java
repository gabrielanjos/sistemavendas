package br.com.sistemadevendas.model;

import java.io.Serializable;

public class VendaModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer codigo;
	private int  quantidade;
	private ClienteModel cliente;
	private ProdutoModel produto; 
	private String usuario;
	private String dataVenda;
	private String formaPagamento;
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

	public ClienteModel getCliente() {
		return cliente;
	}

	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}

	public ProdutoModel getProduto() {
		return produto;
	}

	public void setProduto(ProdutoModel produto) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        VendaModel other = (VendaModel) obj;
	        if (codigo == null) {
	            if (other.codigo != null)
	                return false;
	        } else if (!codigo.equals(other.codigo))
	            return false;
	        return true;
	    }

	@Override
	public String toString() {
		return "VendaModel [codigo=" + codigo + ", quantidade=" + quantidade + ", cliente=" + cliente + ", produto="
				+ produto + ", usuario=" + usuario + ", dataVenda=" + dataVenda + ", formaPagamento=" + formaPagamento
				+ ", valor=" + valor + "]";
	}

	

	

}
