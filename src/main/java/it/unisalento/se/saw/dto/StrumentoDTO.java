package it.unisalento.se.saw.dto;

public class StrumentoDTO {
	private String nome;
	private int agibile;
	private int idAula;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getAgibile() {
		return agibile;
	}
	public void setAgibile(int agibile) {
		this.agibile = agibile;
	}
	public int getIdAula() {
		return idAula;
	}
	public void setIdAula(int idAula) {
		this.idAula = idAula;
	}
}