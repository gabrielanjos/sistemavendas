package br.com.sistemadevendas.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
 
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.sistemadevendas.model.CategoriaModel;
import br.com.sistemadevendas.repository.entity.CategoriaEntity;
import br.com.sistemadevendas.uteis.Uteis;
 
public class CategoriaRepository {
 
	@Inject
	CategoriaEntity categoriaEntity;
 
	EntityManager entityManager;
 
	/***
	 * MÉTODO RESPONSÁVEL POR SALVAR UMA NOVA PESSOA
	 * @param categoriaModel
	 */
	public void SalvarNovoRegistro(CategoriaModel categoriaModel){
 
		entityManager =  Uteis.JpaEntityManager();

		categoriaEntity = new CategoriaEntity();
		categoriaEntity.setNome(categoriaModel.getNome());
		
 
		entityManager.persist(categoriaEntity);
 
	}
 
	/***
	 * MÉTODO PARA CONSULTAR A PESSOA
	 * @return
	 */
	public List<CategoriaModel> GetCategorias(){
 
		List<CategoriaModel> categoriaModels = new ArrayList<CategoriaModel>();
 
		entityManager =  Uteis.JpaEntityManager();
 
		Query query = entityManager.createNamedQuery("CategoriaEntity.findAll");
 
		@SuppressWarnings("unchecked")
		Collection<CategoriaEntity> categoriasEntity = (Collection<CategoriaEntity>)query.getResultList();
 
		CategoriaModel categoriaModel = null;
 
		for (CategoriaEntity categoriaEntity : categoriasEntity) {
 
			categoriaModel = new CategoriaModel();
			categoriaModel.setCodigo(categoriaEntity.getCodigo());
			categoriaModel.setNome(categoriaEntity.getNome());
 
	
			categoriaModels.add(categoriaModel);
		}
 
		return categoriaModels;
 
	}
	
	/***
	 * CONSULTA UMA PESSOA CADASTRADA PELO CÓDIGO
	 * @param codigo
	 * @return
	 */
	private CategoriaEntity GetCategoria(int codigo){
 
		entityManager =  Uteis.JpaEntityManager();
 
		return entityManager.find(CategoriaEntity.class, codigo);
	}
 
	/***
	 * ALTERA UM REGISTRO CADASTRADO NO BANCO DE DADOS
	 * @param pessoaModel
	 */
	public void AlterarRegistro(CategoriaModel categoriaModel){
 
		entityManager =  Uteis.JpaEntityManager();
 
		CategoriaEntity categoriaEntity = this.GetCategoria(categoriaModel.getCodigo());
		categoriaEntity.setCodigo(categoriaModel.getCodigo());
		categoriaEntity.setNome(categoriaModel.getNome());
		
 
		entityManager.merge(categoriaEntity);
	}
	
	/***
	 * EXCLUI UM REGISTRO DO BANCO DE DADOS
	 * @param codigo
	 */
	public void ExcluirRegistro(int codigo){
 
		entityManager =  Uteis.JpaEntityManager();		
 
		CategoriaEntity pessoaEntity = this.GetCategoria(codigo);
 
		entityManager.remove(pessoaEntity);
	}
}