package br.com.sistemadevendas.controller;

import java.io.Serializable;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import br.com.sistemadevendas.model.MarcaModel;
import br.com.sistemadevendas.repository.MarcaRepository;
import br.com.sistemadevendas.uteis.Uteis;
 
@Named(value="marcaController")
@ViewScoped
public class MarcaController implements Serializable{
 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject transient
	MarcaModel marcaModel;
	
	@Produces 
	private List<MarcaModel> marcas;
 
	@Inject transient
	MarcaRepository marcaRepository;
 		
	public MarcaModel getMarcaModel() {
		return marcaModel;
	}
 
	public void setMarcaModel(MarcaModel marcaModel) {
		this.marcaModel = marcaModel;
	}
	
	
	
	public List<MarcaModel> getMarcas() {
		return marcas;
	}

	public void setMarcas(List<MarcaModel> marcas) {
		this.marcas = marcas;
	}

	@PostConstruct
	public void init(){
 
		//RETORNAR AS PESSOAS CADASTRADAS
		this.marcas = marcaRepository.GetMarcas();
	}
 
	/**
	 *SALVA UM NOVO REGISTRO VIA INPUT 
	 */
	public void SalvarMarcas(){
		
		marcaRepository.SalvarNovoRegistro(this.marcaModel);
 
		this.marcaModel = null;
 
		Uteis.MensagemInfo("Registro cadastrado com sucesso");
 
	}
	
	public void Editar(MarcaModel marcaModel){
		this.marcaModel = marcaModel;
	}
 
	/***
	 * ATUALIZA O REGISTRO QUE FOI ALTERADO
	 */
	public void AlterarRegistro(){
		
 
		this.marcaRepository.AlterarRegistro(this.marcaModel);	
 
 
		/*RECARREGA OS REGISTROS*/
		this.init();
	}
	
	/***
	 * EXCLUINDO UM REGISTRO
	 * @param marcaModel
	 */
	public void Excluir(MarcaModel marcaModel){
 
		//EXCLUI A PESSOA DO BANCO DE DADOS
		this.marcaRepository.ExcluirRegistro(marcaModel.getCodigo());
		this.marcas.remove(marcaModel);
 
	}
 
}
