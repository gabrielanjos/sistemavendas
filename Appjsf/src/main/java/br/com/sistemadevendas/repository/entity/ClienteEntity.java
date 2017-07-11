package br.com.sistemadevendas.repository.entity;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
 
 
@Entity
@Table(name="tb_cliente")
 
@NamedQueries({
 
	@NamedQuery(name = "ClienteEntity.findAll",query= "SELECT p FROM ClienteEntity p")
 
})
public class ClienteEntity {
 
	@Id
	@GeneratedValue
	@Column(name = "id_clientel")
	private Integer	codigo;
 
	@Column(name = "nm_cliente")
	private String nome;
	
	@Column(name = "endereco")
	private String endereco;
	@Column(name = "data_nascimento")
	private String dataNascimento;
	@Column(name = "cpf")
	private String cpf;
	@Column(name = "cep")
	private String cep;
	@Column(name = "numero")
	private String numero;
	@Column(name = "telefone")
	private String telefone;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	

}
