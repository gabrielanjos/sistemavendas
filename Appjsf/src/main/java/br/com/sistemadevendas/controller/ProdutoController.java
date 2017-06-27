package br.com.sistemadevendas.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import br.com.sistemadevendas.model.ProdutoModel;
import br.com.sistemadevendas.repository.ProdutoRepository;
import br.com.sistemadevendas.uteis.Uteis;
 
@Named(value="produtoController")
@RequestScoped
public class ProdutoController {
 

	@Inject transient
	ProdutoModel produtoModel;
	
	@Produces 
	private List<ProdutoModel> produtos;
 
	@Inject
	ProdutoRepository produtoRepository;
	
	
	public ProdutoModel getProdutoModel() {
		return produtoModel;
	}

	public void setProdutoModel(ProdutoModel produtoModel) {
		this.produtoModel = produtoModel;
	}

	public List<ProdutoModel> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoModel> produtos) {
		this.produtos = produtos;
	}

 
	/**
	 *SALVA UM NOVO REGISTRO VIA INPUT 
	 */
	public void SalvarCategoria(){
		
		produtoRepository.SalvarNovoRegistro(this.produtoModel);
 
		this.produtoModel = null;
 
		Uteis.MensagemInfo("Registro cadastrado com sucesso");
 
	}
	

}
