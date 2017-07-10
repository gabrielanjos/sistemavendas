package br.com.sistemadevendas.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.sistemadevendas.model.CategoriaModel;
import br.com.sistemadevendas.model.MarcaModel;
import br.com.sistemadevendas.model.ProdutoModel;
import br.com.sistemadevendas.repository.entity.CategoriaEntity;
import br.com.sistemadevendas.repository.entity.MarcaEntity;
import br.com.sistemadevendas.repository.entity.ProdutoEntity;
import br.com.sistemadevendas.uteis.Uteis;
 
public class ProdutoRepository {
 
	@Inject
	ProdutoEntity produtoEntity;
 
	EntityManager entityManager;
 
	/***
	 * MÉTODO RESPONSÁVEL POR SALVAR UMA NOVA PESSOA
	 * @param pessoaModel
	 */
	public void SalvarNovoRegistro(ProdutoModel produtoModel){
 
		entityManager =  Uteis.JpaEntityManager();
 
		produtoEntity = new ProdutoEntity();
		produtoEntity.setNome(produtoModel.getNome());
		produtoEntity.setTamanho(produtoModel.getTamanho());
		
		CategoriaEntity cat = new CategoriaEntity();
		cat.setNome(produtoModel.getCategoria().getNome());
		cat.setCodigo(produtoModel.getCategoria().getCodigo());
		
		MarcaEntity m = new MarcaEntity();
		m.setNome(produtoModel.getMarca().getNome());
		m.setCodigo(produtoModel.getMarca().getCodigo());
		
		produtoEntity.setCategoria(cat);
		produtoEntity.setMarcaEntity(m);
		produtoEntity.setValor(produtoModel.getValor());
	
		entityManager.persist(produtoEntity);
 
	}
 
	/***
	 * MÉTODO PARA CONSULTAR A PESSOA
	 * @return
	 */
	public List<ProdutoModel> GetProdutos(){
 
		List<ProdutoModel> produtoModels = new ArrayList<ProdutoModel>();
 
		entityManager =  Uteis.JpaEntityManager();
 
		Query query = entityManager.createNamedQuery("ProdutoEntity.findAll");
 
		@SuppressWarnings("unchecked")
		Collection<ProdutoEntity> pessoasEntity = (Collection<ProdutoEntity>)query.getResultList();
 
		ProdutoModel produtoModel = null;
 
		for (ProdutoEntity produtoEntity : pessoasEntity) {
 
			produtoModel = new ProdutoModel();
			produtoModel.setCodigo(produtoEntity.getCodigo());
			produtoModel.setNome(produtoEntity.getNome());
			produtoModel.setTamanho(produtoEntity.getTamanho());
			
			CategoriaModel cat = new CategoriaModel();
			cat.setNome(produtoEntity.getCategoria().getNome());
			cat.setCodigo(produtoEntity.getCategoria().getCodigo());
			
			MarcaModel m = new MarcaModel();
			m.setNome(produtoEntity.getMarcaEntity().getNome());
			m.setCodigo(produtoEntity.getMarcaEntity().getCodigo());
			
			produtoModel.setCategoria(cat);
			produtoModel.setMarca(m);
			produtoModel.setValor(produtoEntity.getValor());
			
			produtoModels.add(produtoModel);
		}
 
		return produtoModels;
 
	}
	
	/***
	 * CONSULTA UMA PESSOA CADASTRADA PELO CÓDIGO
	 * @param codigo
	 * @return
	 */
	private ProdutoEntity GetProduto(int codigo){
 
		entityManager =  Uteis.JpaEntityManager();
 
		return entityManager.find(ProdutoEntity.class, codigo);
	}
 
	/***
	 * ALTERA UM REGISTRO CADASTRADO NO BANCO DE DADOS
	 * @param pessoaModel
	 */
	public void AlterarRegistro(ProdutoModel produtoModel){
 
		entityManager =  Uteis.JpaEntityManager();
 
		ProdutoEntity produtoEntity = this.GetProduto(produtoModel.getCodigo());
 
		produtoEntity = new ProdutoEntity();
		produtoEntity.setNome(produtoModel.getNome());
		produtoEntity.setTamanho(produtoModel.getTamanho());
		produtoEntity.setValor(produtoModel.getValor());
		
		CategoriaEntity cat = new CategoriaEntity();
		cat.setNome(produtoModel.getCategoria().getNome());
		cat.setCodigo(produtoModel.getCategoria().getCodigo());
		
		MarcaEntity m = new MarcaEntity();
		m.setNome(produtoModel.getMarca().getNome());
		m.setCodigo(produtoModel.getMarca().getCodigo());
		
		produtoEntity.setCategoria(cat);
		produtoEntity.setMarcaEntity(m);

		entityManager.merge(produtoEntity);
	}
	
	/***
	 * EXCLUI UM REGISTRO DO BANCO DE DADOS
	 * @param codigo
	 */
	public void ExcluirRegistro(int codigo){
 
		entityManager =  Uteis.JpaEntityManager();		
 
		ProdutoEntity produtoEntity = this.GetProduto(codigo);
 
		entityManager.remove(produtoEntity);
	}
}