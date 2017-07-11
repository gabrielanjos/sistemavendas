package br.com.sistemadevendas.controller;

import java.io.Serializable;

import java.util.List;
 
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sistemadevendas.model.CategoriaModel;
import br.com.sistemadevendas.model.MarcaModel;
import br.com.sistemadevendas.model.ProdutoModel;
import br.com.sistemadevendas.repository.CategoriaRepository;
import br.com.sistemadevendas.repository.MarcaRepository;
import br.com.sistemadevendas.repository.ProdutoRepository;
 
@Named(value="consultarProdutoController")
@ViewScoped
public class ProdutoConsultaController implements Serializable{
 
	private static final long serialVersionUID = 1L;

	@Inject transient
	ProdutoModel produtoModel;
	
	@Produces 
	private List<ProdutoModel> produtos;
	
	@Produces 
	private List<CategoriaModel> categorias;
	
	@Produces 
	private List<MarcaModel> marcas;
 
	@Inject transient
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
	
	public List<CategoriaModel> getCategorias() {
		CategoriaRepository r = new CategoriaRepository();
		return r.GetCategorias();
		
	}

	public void setCategorias(List<CategoriaModel> categorias) {
		this.categorias = categorias;
	}
	
	

	public List<MarcaModel> getMarcas() {
		return new MarcaRepository().GetMarcas();
	}

	public void setMarcas(List<MarcaModel> marcas) {
		this.marcas = marcas;
	}


	@PostConstruct
	public void init(){
 
		//RETORNAR AS PESSOAS CADASTRADAS
		
			this.produtos = produtoRepository.GetProdutos();
		
		
	}
 
	/**
	 *SALVA UM NOVO REGISTRO VIA INPUT 
	 
	public void SalvarCategoria(){
		
		produtoRepository.SalvarNovoRegistro(this.produtoModel);
 
		this.produtoModel = null;
 
		Uteis.MensagemInfo("Registro cadastrado com sucesso");
 
	}*/
	
	public void Editar(ProdutoModel produtoModel){
		this.produtoModel = produtoModel;
		System.out.println("Controller Editar: "+this.produtoModel.getCodigo());
	}
 
	/***
	 * ATUALIZA O REGISTRO QUE FOI ALTERADO
	 */
	public void AlterarRegistro(){
 
		this.produtoRepository.AlterarRegistro(this.produtoModel);	
 
		System.out.println("Controller AlterarRegistro: "+this.produtoModel.getCodigo());
 
		/*RECARREGA OS REGISTROS*/
		this.init();
	}
	
	/***
	 * EXCLUINDO UM REGISTRO
	 * @param produtoModel
	 */
	public void Excluir(ProdutoModel produtoModel){
 
		//EXCLUI O PRODUTO DO BANCO DE DADOS
		this.produtoRepository.ExcluirRegistro(produtoModel.getCodigo());
		this.produtos.remove(produtoModel);
 
	}
 
}
