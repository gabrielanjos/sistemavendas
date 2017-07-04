package br.com.sistemadevendas.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.sistemadevendas.model.FilialModel;
import br.com.sistemadevendas.repository.entity.FilialEntity;
import br.com.sistemadevendas.uteis.Uteis;
 
public class FilialRepository {
 
	@Inject
	FilialEntity filialEntity;
 
	EntityManager entityManager;
 
	/***
	 * MÉTODO RESPONSÁVEL POR SALVAR UMA NOVA PESSOA
	 * @param filialModel
	 */
	public void SalvarNovoRegistro(FilialModel filialModel){
 
		entityManager =  Uteis.JpaEntityManager();

		filialEntity = new FilialEntity();
		filialEntity.setNome(filialModel.getNome());
		
 
		entityManager.persist(filialEntity);
 
	}
 
	/***
	 * MÉTODO PARA CONSULTAR A PESSOA
	 * @return
	 */
	public List<FilialModel> GetFiliais(){
 
		List<FilialModel> filiaisModel = new ArrayList<FilialModel>();
 
		entityManager =  Uteis.JpaEntityManager();
 
		Query query = entityManager.createNamedQuery("FilialEntity.findAll");
 
		@SuppressWarnings("unchecked")
		Collection<FilialEntity> categoriasEntity = (Collection<FilialEntity>)query.getResultList();
 
		FilialModel filialModel = null;
 
		for (FilialEntity filialEntity : categoriasEntity) {
 
			filialModel = new FilialModel();
			filialModel.setCodigo(filialEntity.getCodigo());
			filialModel.setNome(filialEntity.getNome());
 
	
			filiaisModel.add(filialModel);
		}
 
		return filiaisModel;
 
	}
	
	/***
	 * CONSULTA UMA PESSOA CADASTRADA PELO CÓDIGO
	 * @param codigo
	 * @return
	 */
	private FilialEntity GetFilial(int codigo){
 
		entityManager =  Uteis.JpaEntityManager();
 
		return entityManager.find(FilialEntity.class, codigo);
	}
 
	/***
	 * ALTERA UM REGISTRO CADASTRADO NO BANCO DE DADOS
	 * @param filialModel
	 */
	public void AlterarRegistro(FilialModel filialModel){
 
		entityManager =  Uteis.JpaEntityManager();
 
		FilialEntity pessoaEntity = this.GetFilial(filialModel.getCodigo());
		pessoaEntity.setNome(filialModel.getNome());
		
 
		entityManager.merge(pessoaEntity);
	}
	
	/***
	 * EXCLUI UM REGISTRO DO BANCO DE DADOS
	 * @param codigo
	 */
	public void ExcluirRegistro(int codigo){
 
		entityManager =  Uteis.JpaEntityManager();		
 
		FilialEntity pessoaEntity = this.GetFilial(codigo);
 
		entityManager.remove(pessoaEntity);
	}
}