package br.com.sistema.service.desk.models;

public enum Status {
	ABERTO("aberto"),ENCERRADO("encerrado");
	
	private String descricao;
	 
	Status(String descricao) {
        this.descricao = descricao;
	}
	 
	public String getDescricao() {
        return descricao;
    }
}
