package br.com.sistema.service.desk.models;

public class Cliente {
	
	private Long id;
	private String nome;
	private String empresa;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String cliente) {
		this.nome = cliente;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", cliente=" + nome + ", empresa=" + empresa + "]";
	}
	
	
	

}
