package br.com.sistemadevendas.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sistemadevendas.model.ClienteModel;
import br.com.sistemadevendas.model.ProdutoModel;
import br.com.sistemadevendas.model.VendaModel;
import br.com.sistemadevendas.repository.ClienteRepository;
import br.com.sistemadevendas.repository.ProdutoRepository;
import br.com.sistemadevendas.repository.VendaRepository;
import br.com.sistemadevendas.uteis.Uteis;
 
@Named(value="cadastrarVendaController")
@ViewScoped
public class VendaController implements Serializable {
 
	@Inject transient
	VendaModel vendaModel;

	@Produces 
	private List<VendaModel> vendas;


	@Produces 
	private List<ClienteModel> clientes;

	@Produces 
	private List<ProdutoModel> produtos;

	@Inject transient
	VendaRepository vendaRepository;
	
	private Double valor;
	private String valorString;
	private Double valorUnitario;
	private ProdutoModel produtoModel;
 
	
	
	
	
 
	public String getValorString() {
		return valorString;
	}

	public void setValorString(String valorString) {
		this.valorString = valorString;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public ProdutoModel getProdutoModel() {
		return produtoModel;
	}

	public void setProdutoModel(ProdutoModel produtoModel) {
		this.produtoModel = produtoModel;
	}

	public VendaModel getVendaModel() {
		return vendaModel;
	}

	public void setVendaModel(VendaModel vendaModel) {
		this.vendaModel = vendaModel;
	}

	public List<VendaModel> getVendas() {
		return vendas;
	}

	public void setVendas(List<VendaModel> vendas) {
		this.vendas = vendas;
	}

	public List<ClienteModel> getClientes() {
		ClienteRepository c = new ClienteRepository();
		return c.GetClientes();
	}

	public void setClientes(List<ClienteModel> clientes) {
		this.clientes = clientes;
	}


	public List<ProdutoModel> getProdutos() {
		ProdutoRepository p = new ProdutoRepository();
		return p.GetProdutos();
	}

	public void setProdutos(List<ProdutoModel> produtos) {
		this.produtos = produtos;
	}
	
	


	public Double getValor() {
		return valor;
	
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@PostConstruct
	public void init(){
 
		//RETORNAR OS PRODUTOS CADASTRADOS
		this.vendas = vendaRepository.GetVendas();
	}




	/**
	 *SALVA UM NOVO REGISTRO VIA INPUT 
	 */
	public void Salvar(){
		vendaModel.setProduto(produtoModel);
		vendaModel.setValor(valor);
		vendaModel.setDataVenda("11-07-2017");
		vendaModel.setUsuario("admin");
		vendaModel.setCliente(new ClienteRepository().GetClientes().get(0));
	
		vendaRepository.SalvarNovoRegistro(this.vendaModel);
 
		this.vendaModel = null;
		this.produtoModel = null;
		this.valorString = null;
 
		Uteis.MensagemInfo("Registro cadastrado com sucesso");
 
	}
	
	public void Calcular(){
		
		
		try {
			  valor = produtoModel.getValor() * vendaModel.getQuantidade();
			valorString = "Valor total do produto: R$"  + valor + " Valor unitario: R$" +  produtoModel.getValor() ;
			
			
		} catch (Exception e) {
			valor = 0.1;
		}
 
	}
 
}