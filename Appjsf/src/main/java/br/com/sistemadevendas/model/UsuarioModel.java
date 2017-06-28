package br.com.sistemadevendas.model;

import java.io.Serializable;

import br.com.sistemadevendas.repository.entity.TipoUsuarioEntity;

public class UsuarioModel implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	private String codigo;
	private String usuario;
	private String senha;
	private TipoUsuarioEntity tipoUsuario;
 
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public TipoUsuarioEntity getTipoUsuario() {
			return tipoUsuario;
	}
	public void setTipoUsuario(TipoUsuarioEntity tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
 
}
