package br.com.sistemadevendas.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sistemadevendas.model.FilialModel;
import br.com.sistemadevendas.repository.FilialRepository;
import br.com.sistemadevendas.uteis.Uteis;
 
@Named(value="filialController")
@RequestScoped
public class FilialController {
 

	@Inject transient
	FilialModel filialModel;
	
	@Produces 
	private List<FilialModel> filiais;
 
	@Inject
	FilialRepository filialRepository;
 		
	public FilialModel getFilialModel() {
		return filialModel;
	}
 
	public void setFilialModel(FilialModel filialModel) {
		this.filialModel = filialModel;
	}
	
	
	


	public List<FilialModel> getFiliais() {
		return filiais;
	}

	public void setFiliais(List<FilialModel> filiais) {
		this.filiais = filiais;
	}

	@PostConstruct
	public void init(){
 
		//RETORNAR AS PESSOAS CADASTRADAS
		this.filiais = filialRepository.GetFiliais();
	}
 
	/**
	 *SALVA UM NOVO REGISTRO VIA INPUT 
	 */
	public void Salvar(){
		
		filialRepository.SalvarNovoRegistro(this.filialModel);
 
		this.filialModel = null;
 
		Uteis.MensagemInfo("Registro cadastrado com sucesso");
 
	}
	
	public void Editar(FilialModel filialModel){
		this.filialModel = filialModel;
	}
 
	/***
	 * ATUALIZA O REGISTRO QUE FOI ALTERADO
	 */
	public void AlterarRegistro(){
 
		this.filialRepository.AlterarRegistro(this.filialModel);	
 
 
		/*RECARREGA OS REGISTROS*/
		this.init();
	}
	
	/***
	 * EXCLUINDO UM REGISTRO
	 * @param pessoaModel
	 */
	public void Excluir(FilialModel filialModel){
 
		//EXCLUI A PESSOA DO BANCO DE DADOS
		this.filialRepository.ExcluirRegistro(filialModel.getCodigo());
		this.filiais.remove(filialModel);
 
	}
 
}
