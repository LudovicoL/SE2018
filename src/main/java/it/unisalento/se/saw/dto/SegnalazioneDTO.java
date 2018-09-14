package it.unisalento.se.saw.dto;

public class SegnalazioneDTO {
	private String segnalazione;
	private int idDocente;
	private int idStrumento;
	private int idAula;
	private int idSegreteria;
	private int abilitazione;
	
	public int getAbilitazione() {
		return abilitazione;
	}
	public void setAbilitazione(int abilitazione) {
		this.abilitazione = abilitazione;
	}
	public String getSegnalazione() {
		return segnalazione;
	}
	public void setSegnalazione(String segnalazione) {
		this.segnalazione = segnalazione;
	}
	public int getIdDocente() {
		return idDocente;
	}
	public void setIdDocente(int idDocente) {
		this.idDocente = idDocente;
	}
	public int getIdStrumento() {
		return idStrumento;
	}
	public void setIdStrumento(int idStrumento) {
		this.idStrumento = idStrumento;
	}
	public int getIdAula() {
		return idAula;
	}
	public void setIdAula(int idAula) {
		this.idAula = idAula;
	}
	public int getIdSegreteria() {
		return idSegreteria;
	}
	public void setIdSegreteria(int idSegreteria) {
		this.idSegreteria = idSegreteria;
	}
}
