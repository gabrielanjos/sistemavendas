package br.com.sistemadevendas.controller;

import java.io.Serializable;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import br.com.sistemadevendas.model.CategoriaModel;
import br.com.sistemadevendas.repository.CategoriaRepository;
import br.com.sistemadevendas.uteis.Uteis;
 
@Named(value="categoriaController")
@ViewScoped
public class CategoriaController implements Serializable{
 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject transient
	CategoriaModel categoriaModel;
	
	@Produces 
	private List<CategoriaModel> categorias;
 
	@Inject transient
	CategoriaRepository categoriaRepository;
 		
	public CategoriaModel getCategoriaModel() {
		return categoriaModel;
	}
 
	public void setCategoriaModel(CategoriaModel categoriaModel) {
		this.categoriaModel = categoriaModel;
	}
	
	
	
	public List<CategoriaModel> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<CategoriaModel> categorias) {
		this.categorias = categorias;
	}

	@PostConstruct
	public void init(){
 
		//RETORNAR AS PESSOAS CADASTRADAS
		this.categorias = categoriaRepository.GetCategorias();
	}
 
	/**
	 *SALVA UM NOVO REGISTRO VIA INPUT 
	 */
	public void SalvarCategoria(){
		
		categoriaRepository.SalvarNovoRegistro(this.categoriaModel);
 
		this.categoriaModel = null;
 
		Uteis.MensagemInfo("Registro cadastrado com sucesso");
 
	}
	
	public void Editar(CategoriaModel categorialModel){
		this.categoriaModel = categorialModel;
	}
 
	/***
	 * ATUALIZA O REGISTRO QUE FOI ALTERADO
	 */
	public void AlterarRegistro(){
 
		this.categoriaRepository.AlterarRegistro(this.categoriaModel);	
 
 
		/*RECARREGA OS REGISTROS*/
		this.init();
	}
	
	/***
	 * EXCLUINDO UM REGISTRO
	 * @param categoriaModel
	 */
	public void Excluir(CategoriaModel categoriaModel){
 
		//EXCLUI A PESSOA DO BANCO DE DADOS
		this.categoriaRepository.ExcluirRegistro(categoriaModel.getCodigo());
		this.categorias.remove(categoriaModel);
 
	}
 
}
