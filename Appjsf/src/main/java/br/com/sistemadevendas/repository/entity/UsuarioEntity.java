package br.com.sistemadevendas.repository.entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
 
@Table(name="tb_usuario")
@Entity	

@NamedQueries({
	 
	@NamedQuery(name = "UsuarioEntity.findAll",query= "SELECT u FROM UsuarioEntity u"),
	
	@NamedQuery(name = "UsuarioEntity.findUser",query= "SELECT u FROM UsuarioEntity u WHERE u.usuario = :usuario AND u.senha = :senha")

 
})
public class UsuarioEntity implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue
	@Column(name="id_usuario")
	private String codigo;
 
	@Column(name="ds_login")
	private String usuario;
 
	@Column(name="ds_senha")
	private String senha;
	
	//TESTE
	@Column(name="tipoUsuario")
	@Enumerated(EnumType.STRING)
	private TipoUsuarioEntity tipoUsuario;
	//TESTE
 
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
	
	// TESTE
	public TipoUsuarioEntity getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(TipoUsuarioEntity tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	//
 
}