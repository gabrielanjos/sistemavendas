package br.com.sistemadevendas.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.sistemadevendas.model.ClienteModel;
import br.com.sistemadevendas.repository.entity.ClienteEntity;
import br.com.sistemadevendas.uteis.Uteis;
 
public class ClienteRepository {
 
	@Inject
	ClienteEntity clienteEntity;
 
	EntityManager entityManager;
 
	/***
	 * MÉTODO RESPONSÁVEL POR SALVAR UMA NOVA PESSOA
	 * @param clienteModel
	 */
	public void SalvarNovoRegistro(ClienteModel clienteModel){
 
		entityManager =  Uteis.JpaEntityManager();

		clienteEntity = new ClienteEntity();
		clienteEntity.setNome(clienteModel.getNome());
		clienteEntity.setCep(clienteModel.getCep());
		clienteEntity.setCpf(clienteModel.getCpf());
		clienteEntity.setNumero(clienteModel.getNumero());
		clienteEntity.setDataNascimento(clienteModel.getDataNascimento());
		clienteEntity.setEndereco(clienteModel.getEndereco());
		clienteEntity.setTelefone(clienteModel.getTelefone());
		
		 
		entityManager.persist(clienteEntity);
 
	}
 
	/***
	 * MÉTODO PARA CONSULTAR A PESSOA
	 * @return
	 */
	public List<ClienteModel> GetClientes(){
 
		List<ClienteModel> clientesModel = new ArrayList<ClienteModel>();
 
		entityManager =  Uteis.JpaEntityManager();
 
		Query query = entityManager.createNamedQuery("ClienteEntity.findAll");
 
		@SuppressWarnings("unchecked")
		Collection<ClienteEntity> clientesEntity = (Collection<ClienteEntity>)query.getResultList();
 
		ClienteModel clienteModel = null;
 
		for (ClienteEntity clienteEntity : clientesEntity) {
 
			clienteModel = new ClienteModel();
			clienteModel.setCodigo(clienteEntity.getCodigo());
			clienteModel.setNome(clienteEntity.getNome());
			clienteModel.setCep(clienteEntity.getCep());
			clienteModel.setCpf(clienteEntity.getCpf());
			clienteModel.setNumero(clienteEntity.getNumero());
			clienteModel.setDataNascimento(clienteEntity.getDataNascimento());
			clienteModel.setEndereco(clienteEntity.getEndereco());
			clienteModel.setTelefone(clienteEntity.getTelefone());
 
	
			clientesModel.add(clienteModel);
		}
 
		return clientesModel;
 
	}
	
	/***
	 * CONSULTA UMA PESSOA CADASTRADA PELO CÓDIGO
	 * @param codigo
	 * @return
	 */
	private ClienteEntity GetCliente(int codigo){
 
		entityManager =  Uteis.JpaEntityManager();
 
		return entityManager.find(ClienteEntity.class, codigo);
	}
 
	/***
	 * ALTERA UM REGISTRO CADASTRADO NO BANCO DE DADOS
	 * @param clienteModel
	 */
	public void AlterarRegistro(ClienteModel clienteModel){
 
		entityManager =  Uteis.JpaEntityManager();
 
		ClienteEntity pessoaEntity = this.GetCliente(clienteModel.getCodigo());
		pessoaEntity.setNome(clienteModel.getNome());
		
 
		entityManager.merge(pessoaEntity);
	}
	
	/***
	 * EXCLUI UM REGISTRO DO BANCO DE DADOS
	 * @param codigo
	 */
	public void ExcluirRegistro(int codigo){
 
		entityManager =  Uteis.JpaEntityManager();		
 
		ClienteEntity pessoaEntity = this.GetCliente(codigo);
 
		entityManager.remove(pessoaEntity);
	}
}