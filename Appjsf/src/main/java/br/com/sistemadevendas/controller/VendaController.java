package br.com.sistemadevendas.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.bean.ViewScoped;
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


	@PostConstruct
	public void init(){
 
		//RETORNAR OS PRODUTOS CADASTRADOS
		this.vendas = vendaRepository.GetVendas();
	}




	/**
	 *SALVA UM NOVO REGISTRO VIA INPUT 
	 */
	public void Salvar(){
		
	
		vendaRepository.SalvarNovoRegistro(this.vendaModel);
 
		this.vendaModel = null;
 
		Uteis.MensagemInfo("Registro cadastrado com sucesso");
 
	}
 
}