package it.unisalento.se.saw.dto;

public class StrumentoDTO {
	private String nome;
	private int funzionante;
	private int idAula;
	private int abilitazione;
	
	public int getAbilitazione() {
		return abilitazione;
	}
	public void setAbilitazione(int abilitazione) {
		this.abilitazione = abilitazione;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdAula() {
		return idAula;
	}
	public void setIdAula(int idAula) {
		this.idAula = idAula;
	}
	public int getFunzionante() {
		return funzionante;
	}
	public void setFunzionante(int funzionante) {
		this.funzionante = funzionante;
	}
}
