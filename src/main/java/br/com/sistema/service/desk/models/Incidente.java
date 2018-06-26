package br.com.sistema.service.desk.models;

import java.util.Date;

public class Incidente {
	
	private Long id;
	private Long idCliente;
	private Long idAtendente;
	private String descricao;
	private String status;
	private Date creationTime;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public Long getIdAtendente() {
		return idAtendente;
	}
	public void setIdAtendente(Long idAtendente) {
		this.idAtendente = idAtendente;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	@Override
	public String toString() {
		return "Incidente [id=" + id + ", cliente=" + idCliente + ", atendente=" + idAtendente + ", descricao=" + descricao
				+ ", status=" + status + ", creationTime=" + creationTime + "]";
	}
	
	
	
}
