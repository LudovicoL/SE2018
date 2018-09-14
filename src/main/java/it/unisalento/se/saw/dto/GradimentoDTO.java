package it.unisalento.se.saw.dto;

public class GradimentoDTO {
	private int idGradimento;
	private int voto;
	private int idStudente;
	private int idMateriale;
	private int idLezione;
	private int abilitazione;
	
	public int getAbilitazione() {
		return abilitazione;
	}
	public void setAbilitazione(int abilitazione) {
		this.abilitazione = abilitazione;
	}
	public int getVoto() {
		return voto;
	}
	public void setVoto(int voto) {
		this.voto = voto;
	}
	public int getIdGradimento() {
		return idGradimento;
	}
	public void setIdGradimento(int idGradimento) {
		this.idGradimento = idGradimento;
	}
	public int getIdStudente() {
		return idStudente;
	}
	public void setIdStudente(int idStudente) {
		this.idStudente = idStudente;
	}
	public int getIdMateriale() {
		return idMateriale;
	}
	public void setIdMateriale(int idMateriale) {
		this.idMateriale = idMateriale;
	}
	public int getIdLezione() {
		return idLezione;
	}
	public void setIdLezione(int idLezione) {
		this.idLezione = idLezione;
	}
}
