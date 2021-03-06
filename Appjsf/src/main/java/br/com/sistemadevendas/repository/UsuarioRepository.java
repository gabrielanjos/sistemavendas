package br.com.sistemadevendas.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.sistemadevendas.model.UsuarioModel;
import br.com.sistemadevendas.repository.entity.UsuarioEntity;
import br.com.sistemadevendas.uteis.Uteis;
 
 
public class UsuarioRepository implements Serializable {
 
 
	private static final long serialVersionUID = 1L;
	
	@Inject
	UsuarioEntity usuarioEntity;
 
	EntityManager entityManager;
 
	/***
	 * MÉTODO RESPONSÁVEL POR SALVAR UMA NOVO USUARIO
	 * @param usuarioModel
	 */
	public void SalvarNovoRegistro(UsuarioModel usuarioModel){
 
		entityManager =  Uteis.JpaEntityManager();
 
		usuarioEntity = new UsuarioEntity();
		usuarioEntity.setUsuario(usuarioModel.getUsuario());
		usuarioEntity.setSenha(usuarioModel.getSenha());
		usuarioEntity.setTipoUsuario(usuarioModel.getTipoUsuario());
 
		entityManager.persist(usuarioEntity);
 
	}
	
	/***
	 * MÉTODO PARA CONSULTAR O USUARIO
	 * @return
	 */
	public List<UsuarioModel> GetUsuarios(){
 
		List<UsuarioModel> usuariosModel = new ArrayList<UsuarioModel>();
 
		entityManager =  Uteis.JpaEntityManager();
 
		Query query = entityManager.createNamedQuery("UsuarioEntity.findAll");
 
		@SuppressWarnings("unchecked")
		Collection<UsuarioEntity> usuariosEntity = (Collection<UsuarioEntity>)query.getResultList();
 
		UsuarioModel usuarioModel = null;
 
		for (UsuarioEntity usuarioEntity : usuariosEntity) {
 
			usuarioModel = new UsuarioModel();
			usuarioModel.setCodigo(usuarioEntity.getCodigo());
			usuarioModel.setUsuario(usuarioEntity.getUsuario()); 
			usuarioModel.setSenha(usuarioEntity.getSenha());
			usuarioModel.setTipoUsuario(usuarioEntity.getTipoUsuario());
			
			
			usuariosModel.add(usuarioModel);
		}
 
		return usuariosModel;
 
	}
	
	/***
	 * CONSULTA UM USUARIO CADASTRADO PELO CÓDIGO
	 * @param codigo
	 * @return
	 */
	private UsuarioEntity GetUsuario(String codigo){
 
		entityManager =  Uteis.JpaEntityManager();
 
		return entityManager.find(UsuarioEntity.class, codigo);
	}
	
	
	/***
	 * ALTERA UM REGISTRO CADASTRADO NO BANCO DE DADOS
	 * @param usuarioModel
	 */
	public void AlterarRegistro(UsuarioModel usuarioModel){
 
		entityManager =  Uteis.JpaEntityManager();
 
		UsuarioEntity usuarioEntity = this.GetUsuario(usuarioModel.getCodigo());
		
		usuarioEntity.setCodigo(usuarioModel.getCodigo());
		usuarioEntity.setUsuario(usuarioModel.getUsuario()); 
		usuarioEntity.setSenha(usuarioModel.getSenha());
		usuarioEntity.setTipoUsuario(usuarioModel.getTipoUsuario());
		
		System.out.println("Codigo: "+usuarioEntity.getCodigo());
		System.out.println("Usuario: "+usuarioEntity.getUsuario());
		System.out.println("Senha: "+usuarioEntity.getSenha());
		System.out.println("Tipo: "+usuarioEntity.getTipoUsuario());
		
		entityManager.merge(usuarioEntity);

	}
	
	
	/***
	 * EXCLUI UM REGISTRO DO BANCO DE DADOS
	 * @param codigo
	 */
	public void ExcluirRegistro(String codigo){
 
		entityManager =  Uteis.JpaEntityManager();		
		
		UsuarioEntity usuarioEntity = this.GetUsuario(codigo);
 
		entityManager.remove(usuarioEntity);
	}
	
 
	public UsuarioEntity ValidaUsuario(UsuarioModel usuarioModel){
 
		try {
 
			//QUERY QUE VAI SER EXECUTADA (UsuarioEntity.findUser) 	
			Query query = Uteis.JpaEntityManager().createNamedQuery("UsuarioEntity.findUser");
 
			//PARÂMETROS DA QUERY
			query.setParameter("usuario", usuarioModel.getUsuario());
			query.setParameter("senha", usuarioModel.getSenha());
 
			//RETORNA O USUÁRIO SE FOR LOCALIZADO
			return (UsuarioEntity)query.getSingleResult();
 
		} catch (Exception e) {
 
			return null;
		}
 
 
 
	}
}
