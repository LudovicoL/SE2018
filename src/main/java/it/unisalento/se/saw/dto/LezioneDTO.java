package it.unisalento.se.saw.dto;

import java.util.Date;

public class LezioneDTO {
	private Date datainizio;
	private Date datafine;
	private int idInsegnamento;
	private int idAula;
	private int abilitazione;
	private int idLezione;
	private String nomeaula;
	private String nomeInsegnamento;
	private String nomeDocente;

	public int getAbilitazione() {
		return abilitazione;
	}
	public void setAbilitazione(int abilitazione) {
		this.abilitazione = abilitazione;
	}
	public int getIdInsegnamento() {
		return idInsegnamento;
	}
	public void setIdInsegnamento(int idInsegnamento) {
		this.idInsegnamento = idInsegnamento;
	}
	public int getIdAula() {
		return idAula;
	}
	public void setIdAula(int idAula) {
		this.idAula = idAula;
	}
	public int getIdLezione() {
		return idLezione;
	}
	public void setIdLezione(int idLezione) {
		this.idLezione = idLezione;
	}
	public String getNomeaula() {
		return nomeaula;
	}
	public void setNomeaula(String nomeaula) {
		this.nomeaula = nomeaula;
	}
	public String getNomeInsegnamento() {
		return nomeInsegnamento;
	}
	public void setNomeInsegnamento(String nomeInsegnamento) {
		this.nomeInsegnamento = nomeInsegnamento;
	}
	public Date getDatainizio() {
		return datainizio;
	}
	public void setDatainizio(Date datainizio) {
		this.datainizio = datainizio;
	}
	public Date getDatafine() {
		return datafine;
	}
	public void setDatafine(Date datafine) {
		this.datafine = datafine;
	}
	public String getNomeDocente() {
		return nomeDocente;
	}
	public void setNomeDocente(String nomeDocente) {
		this.nomeDocente = nomeDocente;
	}
}
