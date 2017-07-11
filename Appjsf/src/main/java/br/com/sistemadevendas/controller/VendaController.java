package br.com.sistemadevendas.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import br.com.sistemadevendas.model.CategoriaModel;
import br.com.sistemadevendas.model.ClienteModel;
import br.com.sistemadevendas.model.ProdutoModel;
import br.com.sistemadevendas.model.VendaModel;
import br.com.sistemadevendas.repository.CategoriaRepository;
import br.com.sistemadevendas.repository.ClienteRepository;
import br.com.sistemadevendas.repository.ProdutoRepository;
import br.com.sistemadevendas.repository.VendaRepository;
import br.com.sistemadevendas.uteis.Uteis;
 
@Named(value="vendaController")
@RequestScoped
public class VendaController {
 

	@Inject transient
	VendaModel vendaModel;
	
	@Produces 
	private List<VendaModel> vendas;
 
	@Inject
	VendaRepository vendaRepository;
 		
	@Produces 
	private List<ClienteModel> clientes;
	
	@Produces 
	private List<ProdutoModel> produtos;
	
	private double valor;
	

	public VendaModel getVendaModel() {
		return vendaModel;
	}

	public void setVendaModel(VendaModel vendaModel) {
		this.vendaModel = vendaModel;
	}

	public double getValor() {
		
		try { 
			// assim que muda o valor de quantidade chama aqui para fazer a quantdade * valor do produto
			return vendaModel.getProduto().getValor() * vendaModel.getQuantidade();
		} catch (Exception e) {
			return 0.0;
		}
		
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public List<ProdutoModel> getProdutos() {
		return new ProdutoRepository().GetProdutos();
	}

	public void setProdutos(List<ProdutoModel> produtos) {
		this.produtos = produtos;
	}

	public List<ClienteModel> getClientes() {
		ClienteRepository repository = new ClienteRepository();
		
		return repository.GetClientes();
	}

	public void setClientes(List<ClienteModel> clientes) {
		this.clientes = clientes;
	}

	public List<VendaModel> getVendas() {
		return vendas;
	}

	public void setVendas(List<VendaModel> vendas) {
		this.vendas = vendas;
	}

	@PostConstruct
	public void init(){
 
		//RETORNAR AS PESSOAS CADASTRADAS
		this.vendas = vendaRepository.GetVendas();
	}
 
	/**
	 *SALVA UM NOVO REGISTRO VIA INPUT 
	 */
	public void SalvarVenda(){
		
		vendaModel.setValor(valor);
		
		vendaRepository.SalvarNovoRegistro(this.vendaModel);
 
		this.vendaModel = null;
 
		Uteis.MensagemInfo("Registro cadastrado com sucesso");
 
	}
	
	public void Editar(VendaModel categorialModel){
		this.vendaModel = categorialModel;
	}
 
	/***
	 * ATUALIZA O REGISTRO QUE FOI ALTERADO
	 */
	public void AlterarRegistro(){
 
		this.vendaRepository.AlterarRegistro(this.vendaModel);	
 
 
		/*RECARREGA OS REGISTROS*/
		this.init();
	}
	
	/***
	 * EXCLUINDO UM REGISTRO
	 * @param pessoaModel
	 */
	public void Excluir(CategoriaModel categoriaModel){
 
		//EXCLUI A PESSOA DO BANCO DE DADOS
		this.vendaRepository.ExcluirRegistro(vendaModel.getCodigo());
		this.vendas.remove(categoriaModel);
 
	}
 
}
