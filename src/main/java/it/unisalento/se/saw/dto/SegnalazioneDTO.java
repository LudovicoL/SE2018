package it.unisalento.se.saw.dto;

public class SegnalazioneDTO {
	private int idSegnalazione;
	private String descrizione;
	private int idDocente;
	private int idStrumento;
	private int idAula;
	private int abilitazione;
	private String stato;
	private String nomeaula;
	private String nomedocente;
	private String commento;
	
	public int getAbilitazione() {
		return abilitazione;
	}
	public void setAbilitazione(int abilitazione) {
		this.abilitazione = abilitazione;
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

	public int getIdSegnalazione() {
		return idSegnalazione;
	}
	public void setIdSegnalazione(int idSegnalazione) {
		this.idSegnalazione = idSegnalazione;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	public String getNomeaula() {
		return nomeaula;
	}
	public void setNomeaula(String nomeaula) {
		this.nomeaula = nomeaula;
	}
	public String getNomedocente() {
		return nomedocente;
	}
	public void setNomedocente(String nomedocente) {
		this.nomedocente = nomedocente;
	}
	public String getCommento() {
		return commento;
	}
	public void setCommento(String commento) {
		this.commento = commento;
	}
}
