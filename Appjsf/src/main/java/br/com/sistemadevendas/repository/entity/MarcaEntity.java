package br.com.sistemadevendas.repository.entity;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
 
 
@Entity
@Table(name="tb_marca")
 
@NamedQueries({
 
	@NamedQuery(name = "MarcaEntity.findAll",query= "SELECT p FROM MarcaEntity p")
 
})
public class MarcaEntity {
 
	@Id
	@GeneratedValue
	@Column(name = "id_marca")
	private Integer 		codigo;
 
	@Column(name = "nm_marca")
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
