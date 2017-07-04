package br.com.sistemadevendas.repository.entity;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
 
 
@Entity
@Table(name="tb_filial")
 
@NamedQueries({
 
	@NamedQuery(name = "FilialEntity.findAll",query= "SELECT p FROM FilialEntity p")
 
})
public class FilialEntity {
 
	@Id
	@GeneratedValue
	@Column(name = "id_filial")
	private Integer 		codigo;
 
	@Column(name = "nm_categoria")
	private String  		nome;
 
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

}
