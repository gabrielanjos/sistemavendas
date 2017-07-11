package br.com.sistemadevendas.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.sistemadevendas.model.CategoriaModel;
import br.com.sistemadevendas.model.ClienteModel;
import br.com.sistemadevendas.model.MarcaModel;
import br.com.sistemadevendas.model.ProdutoModel;
import br.com.sistemadevendas.model.VendaModel;
import br.com.sistemadevendas.repository.entity.CategoriaEntity;
import br.com.sistemadevendas.repository.entity.ClienteEntity;
import br.com.sistemadevendas.repository.entity.MarcaEntity;
import br.com.sistemadevendas.repository.entity.ProdutoEntity;
import br.com.sistemadevendas.repository.entity.VendaEntity;
import br.com.sistemadevendas.uteis.Uteis;
 
public class VendaRepository {
 
	@Inject
	VendaEntity vendaEntity;
 
	EntityManager entityManager;
 
	/***
	 * MÉTODO RESPONSÁVEL POR SALVAR UMA NOVA PESSOA
	 * @param vendaModel
	 */
	public void SalvarNovoRegistro(VendaModel vendaModel){
 
		entityManager =  Uteis.JpaEntityManager();

		vendaEntity = new VendaEntity();
		
		ClienteEntity clienteEntity = new ClienteEntity();
		clienteEntity.setCodigo(vendaModel.getCliente().getCodigo());
		clienteEntity.setNome(vendaModel.getCliente().getNome());
		clienteEntity.setCep(vendaModel.getCliente().getCep());
		clienteEntity.setCpf(vendaModel.getCliente().getCpf());
		clienteEntity.setNumero(vendaModel.getCliente().getNumero());
		clienteEntity.setDataNascimento(vendaModel.getCliente().getDataNascimento());
		clienteEntity.setEndereco(vendaModel.getCliente().getEndereco());
		clienteEntity.setTelefone(vendaModel.getCliente().getTelefone());
		
		vendaEntity.setCliente(clienteEntity);
		
		ProdutoEntity produtoEntity = new ProdutoEntity();
		produtoEntity.setCodigo(vendaModel.getProduto().getCodigo());
		produtoEntity.setNome(vendaModel.getProduto().getNome());
		produtoEntity.setTamanho(vendaModel.getProduto().getTamanho());
		
		
		CategoriaEntity cat = new CategoriaEntity();
		cat.setNome(vendaModel.getProduto().getCategoria().getNome());
		cat.setCodigo(vendaModel.getProduto().getCategoria().getCodigo());
		
		MarcaEntity m = new MarcaEntity();
		m.setNome(vendaModel.getProduto().getMarca().getNome());
		m.setCodigo(vendaModel.getProduto().getMarca().getCodigo());
		produtoEntity.setCategoria(cat);
		produtoEntity.setMarcaEntity(m);
		
		vendaEntity.setProduto(produtoEntity);
		
		vendaEntity.setFormaPagamento(vendaModel.getFormaPagamento());
		vendaEntity.setUsuario(vendaModel.getUsuario());
		vendaEntity.setDataVenda(vendaModel.getDataVenda());
		vendaEntity.setQuantidade(vendaModel.getQuantidade());
		
		
		
		
		 
		entityManager.persist(vendaEntity);
 
	}
 
	/***
	 * MÉTODO PARA CONSULTAR A PESSOA
	 * @return
	 */
	public List<VendaModel> GetVendas(){
 
		List<VendaModel> vendasModel = new ArrayList<VendaModel>();
 
		entityManager =  Uteis.JpaEntityManager();
 
		Query query = entityManager.createNamedQuery("VendaEntity.findAll");
 
		@SuppressWarnings("unchecked")
		Collection<VendaEntity> vendasEntity = (Collection<VendaEntity>)query.getResultList();
 
		VendaModel vendaModel = null;
 
		for (VendaEntity vendaEntity : vendasEntity) {
 
			vendaModel = new VendaModel();
			vendaModel.setCodigo(vendaEntity.getCodigo());
			vendaModel.setFormaPagamento(vendaEntity.getFormaPagamento());
			vendaModel.setUsuario(vendaEntity.getUsuario());
			vendaModel.setDataVenda(vendaEntity.getDataVenda());
			vendaModel.setQuantidade(vendaEntity.getQuantidade());
 
			
			ClienteModel  clienteModel = new ClienteModel();
			clienteModel.setCodigo(vendaEntity.getCliente().getCodigo());
			clienteModel.setNome(vendaEntity.getCliente().getNome());
			clienteModel.setCep(vendaEntity.getCliente().getCep());
			clienteModel.setCpf(vendaEntity.getCliente().getCpf());
			clienteModel.setNumero(vendaEntity.getCliente().getNumero());
			clienteModel.setDataNascimento(vendaEntity.getCliente().getDataNascimento());
			clienteModel.setEndereco(vendaEntity.getCliente().getEndereco());
			clienteModel.setTelefone(vendaEntity.getCliente().getTelefone());
			
			vendaModel.setCliente(clienteModel);
			
			
			ProdutoModel produtoModel = new ProdutoModel();
			produtoModel.setCodigo(vendaEntity.getProduto().getCodigo());
			produtoModel.setNome(vendaEntity.getProduto().getNome());
			produtoModel.setTamanho(vendaEntity.getProduto().getTamanho());
			
			
			CategoriaModel cat = new CategoriaModel();
			cat.setNome(vendaEntity.getProduto().getCategoria().getNome());
			cat.setCodigo(vendaEntity.getProduto().getCategoria().getCodigo());
			
			MarcaModel m = new MarcaModel();
			m.setNome(vendaEntity.getProduto().getMarcaEntity().getNome());
			m.setCodigo(vendaEntity.getProduto().getMarcaEntity().getCodigo());
			produtoModel.setCategoria(cat);
			produtoModel.setMarca(m);
			
			vendaModel.setProduto(produtoModel);
			
			
	
			vendasModel.add(vendaModel);
		}
 
		return vendasModel;
 
	}
	
	/***
	 * CONSULTA UMA PESSOA CADASTRADA PELO CÓDIGO
	 * @param codigo
	 * @return
	 */
	private VendaEntity GetCliente(int codigo){
 
		entityManager =  Uteis.JpaEntityManager();
 
		return entityManager.find(VendaEntity.class, codigo);
	}
 
	/***
	 * ALTERA UM REGISTRO CADASTRADO NO BANCO DE DADOS
	 * @param vendaModel
	 */
	public void AlterarRegistro(VendaModel vendaModel){
 
		entityManager =  Uteis.JpaEntityManager();
 
		VendaEntity pessoaEntity = this.GetCliente(vendaModel.getCodigo());
		//pessoaEntity.setNome(vendaModel.getNome());
		
 
		entityManager.merge(pessoaEntity);
	}
	
	/***
	 * EXCLUI UM REGISTRO DO BANCO DE DADOS
	 * @param codigo
	 */
	public void ExcluirRegistro(int codigo){
 
		entityManager =  Uteis.JpaEntityManager();		
 
		VendaEntity pessoaEntity = this.GetCliente(codigo);
 
		entityManager.remove(pessoaEntity);
	}
}