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
 
@Named(value="produtoConsultaController")
@RequestScoped
public class ProdutoConsultaController {
 

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

	@PostConstruct
	public void init(){
 
		//RETORNAR AS PESSOAS CADASTRADAS
		
			this.produtos = produtoRepository.GetProdutos();
		
		
	}
 
	/**
	 *SALVA UM NOVO REGISTRO VIA INPUT 
	 */
	public void SalvarCategoria(){
		
		produtoRepository.SalvarNovoRegistro(this.produtoModel);
 
		this.produtoModel = null;
 
		Uteis.MensagemInfo("Registro cadastrado com sucesso");
 
	}
	
	public void Editar(ProdutoModel produtoModel){
		this.produtoModel = produtoModel;
	}
 
	/***
	 * ATUALIZA O REGISTRO QUE FOI ALTERADO
	 */
	public void AlterarRegistro(){
 
		this.produtoRepository.AlterarRegistro(this.produtoModel);	
 
 
		/*RECARREGA OS REGISTROS*/
		//this.init();
	}
	
	/***
	 * EXCLUINDO UM REGISTRO
	 * @param pessoaModel
	 */
	public void Excluir(ProdutoModel produtoModel){
 
		//EXCLUI A PESSOA DO BANCO DE DADOS
		this.produtoRepository.ExcluirRegistro(produtoModel.getCodigo());
		this.produtos.remove(produtoModel);
 
	}
 
}
