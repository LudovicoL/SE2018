package it.unisalento.se.saw.dto;

public class CorsoDTO {
	private int idCorso;
	private String nome;
	private String facolta;
	private int durata;
	private String livello;
	public int getIdCorso() {
		return idCorso;
	}
	public void setIdCorso(int idCorso) {
		this.idCorso = idCorso;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFacolta() {
		return facolta;
	}
	public void setFacolta(String facolta) {
		this.facolta = facolta;
	}
	public int getDurata() {
		return durata;
	}
	public void setDurata(int durata) {
		this.durata = durata;
	}
	public String getLivello() {
		return livello;
	}
	public void setLivello(String livello) {
		this.livello = livello;
	}
}