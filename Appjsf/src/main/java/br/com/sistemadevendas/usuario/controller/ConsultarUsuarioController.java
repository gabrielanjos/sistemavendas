package br.com.sistemadevendas.usuario.controller;

import java.io.Serializable;
import java.util.List;
 
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
 
import br.com.sistemadevendas.model.UsuarioModel;
import br.com.sistemadevendas.repository.UsuarioRepository;
import br.com.sistemadevendas.repository.entity.TipoUsuarioEntity;
 
@Named(value="consultarUsuarioController")
@ViewScoped
public class ConsultarUsuarioController implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	@Inject transient
	private UsuarioModel usuarioModel;
 
	@Produces 
	private List<UsuarioModel> usuarios;
 
	@Inject transient
	private UsuarioRepository usuarioRepository;
 
	public List<UsuarioModel> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<UsuarioModel> usuarios) {
		this.usuarios = usuarios;
	}		
	public UsuarioModel getUsuarioModel() {
		return usuarioModel;
	}
	public void setUsuarioModel(UsuarioModel usuarioModel) {
		this.usuarioModel = usuarioModel;
	}
	
	/*Aqui método que acesso no selectOneMenu*/
	public TipoUsuarioEntity[] getTipoUsuarios(){
		return TipoUsuarioEntity.values();
	}
 
	/***
	 * CARREGA OS USUARIOS NA INICIALIZAÇÃO 
	 */
	@PostConstruct
	public void init(){
 
		//RETORNAR OS USUARIOS CADASTRADOS
		this.usuarios = usuarioRepository.GetUsuarios();
	}
	
	/***
	 * CARREGA INFORMAÇÕES DE UM USUARIO PARA SER EDITADA
	 * @param usuarioModel
	 */
	public void Editar(UsuarioModel usuarioModel){
 
		this.usuarioModel = usuarioModel;
 
	}
 
	/***
	 * ATUALIZA O REGISTRO QUE FOI ALTERADO
	 */
	public void AlterarRegistro(){
		
		System.out.println("Teste");
 
		this.usuarioRepository.AlterarRegistro(this.usuarioModel);	
		 
		/*RECARREGA OS REGISTROS*/
		this.init();
	}
	
	/***
	 * EXCLUINDO UM REGISTRO
	 * @param usuarioModel
	 */
	public void ExcluirUsuario(UsuarioModel usuarioModel){
		
		System.out.println("Teste Excluir");
 
		//EXCLUI O USUARIO DO BANCO DE DADOS
		this.usuarioRepository.ExcluirRegistro(usuarioModel.getCodigo());
 
		//REMOVENDO O USUARIO DA LISTA
		//ASSIM QUE É O USUARIO É REMOVIDO DA LISTA O DATATABLE É ATUALIZADO
		this.usuarios.remove(usuarioModel);
 
	}
 
 
}
