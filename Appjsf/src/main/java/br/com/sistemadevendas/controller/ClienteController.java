package br.com.sistemadevendas.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sistemadevendas.model.ClienteModel;
import br.com.sistemadevendas.repository.ClienteRepository;
import br.com.sistemadevendas.uteis.Uteis;
 
@Named(value="clienteController")
@RequestScoped
public class ClienteController {
 

	@Inject transient
	ClienteModel clienteModel;
	
	@Produces 
	private List<ClienteModel> clientes;
 
	@Inject
	ClienteRepository clienteRepository;
 		
	public ClienteModel getClienteModel() {
		return clienteModel;
	}
 
	public void setClienteModel(ClienteModel clienteModel) {
		this.clienteModel = clienteModel;
	}
	
	
	


	public List<ClienteModel> getFiliais() {
		return clientes;
	}

	public void setFiliais(List<ClienteModel> clientes) {
		this.clientes = clientes;
	}

	@PostConstruct
	public void init(){
 
		//RETORNAR AS PESSOAS CADASTRADAS
		this.clientes = clienteRepository.GetClientes();
	}
 
	/**
	 *SALVA UM NOVO REGISTRO VIA INPUT 
	 */
	public void Salvar(){
		
		clienteRepository.SalvarNovoRegistro(this.clienteModel);
 
		this.clienteModel = null;
 
		Uteis.MensagemInfo("Registro cadastrado com sucesso");
 
	}
	
	public void Editar(ClienteModel clienteModel){
		this.clienteModel = clienteModel;
	}
 
	/***
	 * ATUALIZA O REGISTRO QUE FOI ALTERADO
	 */
	public void AlterarRegistro(){
 
		this.clienteRepository.AlterarRegistro(this.clienteModel);	
 
 
		/*RECARREGA OS REGISTROS*/
		this.init();
	}
	
	/***
	 * EXCLUINDO UM REGISTRO
	 * @param pessoaModel
	 */
	public void Excluir(ClienteModel clienteModel){
 
		//EXCLUI A PESSOA DO BANCO DE DADOS
		this.clienteRepository.ExcluirRegistro(clienteModel.getCodigo());
		this.clientes.remove(clienteModel);
 
	}
 
}
