package br.com.sistemadevendas.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
 
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;


import br.com.sistemadevendas.model.MarcaModel;
import br.com.sistemadevendas.repository.entity.MarcaEntity;
import br.com.sistemadevendas.uteis.Uteis;
 
public class MarcaRepository {
 
	@Inject
	MarcaEntity marcaEntity;
 
	EntityManager entityManager;
 
	/***
	 * MÉTODO RESPONS�?VEL POR SALVAR UMA NOVA PESSOA
	 * @param marcaModel
	 */
	public void SalvarNovoRegistro(MarcaModel marcaModel){
 
		entityManager =  Uteis.JpaEntityManager();

		marcaEntity = new MarcaEntity();
		marcaEntity.setNome(marcaModel.getNome());
		
 
		entityManager.persist(marcaEntity);
 
	}
 
	/***
	 * MÉTODO PARA CONSULTAR A PESSOA
	 * @return
	 */
	public List<MarcaModel> GetMarcas(){
 
		List<MarcaModel> marcaModels = new ArrayList<MarcaModel>();
 
		entityManager =  Uteis.JpaEntityManager();
 
		Query query = entityManager.createNamedQuery("MarcaEntity.findAll");
 
		@SuppressWarnings("unchecked")
		Collection<MarcaEntity> marcasEntity = (Collection<MarcaEntity>)query.getResultList();
 
		MarcaModel marcaModel = null;
 
		for (MarcaEntity marcaEntity : marcasEntity) {
 
			marcaModel = new MarcaModel();
			marcaModel.setCodigo(marcaEntity.getCodigo());
			marcaModel.setNome(marcaEntity.getNome());
 
	
			marcaModels.add(marcaModel);
		}
 
		return marcaModels;
 
	}
	
	/***
	 * CONSULTA UMA PESSOA CADASTRADA PELO CÓDIGO
	 * @param codigo
	 * @return
	 */
	private MarcaEntity GetMarca(int codigo){
 
		entityManager =  Uteis.JpaEntityManager();
 
		return entityManager.find(MarcaEntity.class, codigo);
	}
 
	/***
	 * ALTERA UM REGISTRO CADASTRADO NO BANCO DE DADOS
	 * @param marcaModel
	 */
	public void AlterarRegistro(MarcaModel marcaModel){
 
		entityManager =  Uteis.JpaEntityManager();
 
		MarcaEntity marcaEntity = this.GetMarca(marcaModel.getCodigo());
		marcaEntity.setCodigo(marcaModel.getCodigo());
		marcaEntity.setNome(marcaModel.getNome());
 
		entityManager.merge(marcaEntity);
	}
	
	/***
	 * EXCLUI UM REGISTRO DO BANCO DE DADOS
	 * @param codigo
	 */
	public void ExcluirRegistro(int codigo){
 
		entityManager =  Uteis.JpaEntityManager();		
 
		MarcaEntity marcaEntity = this.GetMarca(codigo);
 
		entityManager.remove(marcaEntity);
	}
}