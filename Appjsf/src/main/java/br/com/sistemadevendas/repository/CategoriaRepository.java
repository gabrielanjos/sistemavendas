package br.com.sistemadevendas.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
 
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.sistemadevendas.model.CategoriaModel;
import br.com.sistemadevendas.model.PessoaModel;
import br.com.sistemadevendas.model.UsuarioModel;
import br.com.sistemadevendas.repository.entity.CategoriaEntity;
import br.com.sistemadevendas.repository.entity.PessoaEntity;
import br.com.sistemadevendas.repository.entity.UsuarioEntity;
import br.com.sistemadevendas.uteis.Uteis;
 
public class CategoriaRepository {
 
	@Inject
	CategoriaEntity categoriaEntity;
 
	EntityManager entityManager;
 
	/***
	 * MÉTODO RESPONSÁVEL POR SALVAR UMA NOVA PESSOA
	 * @param pessoaModel
	 */
	public void SalvarNovoRegistro(CategoriaModel pessoaModel){
 
		entityManager =  Uteis.JpaEntityManager();

		categoriaEntity = new CategoriaEntity();
		categoriaEntity.setNome(pessoaModel.getNome());
		
 
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
	public void AlterarRegistro(CategoriaModel pessoaModel){
 
		entityManager =  Uteis.JpaEntityManager();
 
		CategoriaEntity pessoaEntity = this.GetCategoria(pessoaModel.getCodigo());
		pessoaEntity.setNome(pessoaModel.getNome());
		
 
		entityManager.merge(pessoaEntity);
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