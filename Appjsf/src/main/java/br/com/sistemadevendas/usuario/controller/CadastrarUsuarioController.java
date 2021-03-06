package br.com.sistemadevendas.usuario.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
 
import br.com.sistemadevendas.model.UsuarioModel;
import br.com.sistemadevendas.repository.UsuarioRepository;
import br.com.sistemadevendas.repository.entity.TipoUsuarioEntity;
import br.com.sistemadevendas.usuario.controller.UsuarioController;
import br.com.sistemadevendas.uteis.Uteis;
 
@Named(value="cadastrarUsuarioController")
@RequestScoped
public class CadastrarUsuarioController {
 
	@Inject
	UsuarioModel usuarioModel;
 
	@Inject
	UsuarioController usuarioController;
 
	@Inject
	UsuarioRepository usuarioRepository;
 
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
	
 
	/**
	 *SALVA UM NOVO REGISTRO VIA INPUT 
	 */
	public void SalvarNovoUsuario(){
 
		usuarioRepository.SalvarNovoRegistro(this.usuarioModel);
 
		//this.usuarioModel = null;
		
		this.usuarioModel.setSenha(null);
		this.usuarioModel.setUsuario(null);
		this.usuarioModel.setTipoUsuario(null);
 
		Uteis.MensagemInfo("Registro cadastrado com sucesso");
 
	}
	
	
 
}
