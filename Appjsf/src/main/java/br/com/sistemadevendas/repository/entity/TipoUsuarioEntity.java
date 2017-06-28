package br.com.sistemadevendas.repository.entity;

public enum TipoUsuarioEntity {
	ADMINISTRADOR("Administrador"),
	CAIXA("Caixa"),
	VENDEDOR("Vendedor"),
	ESTOQUISTA("Estoquista"),
	GERENTE("Gerente");
	
	private String label;
	
	TipoUsuarioEntity(String label){
		this.label = label;
	}

	public String getLabel(){
		return label;
	}
	
	

}
