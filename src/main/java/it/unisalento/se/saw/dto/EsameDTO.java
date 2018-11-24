package it.unisalento.se.saw.dto;

import java.util.Date;

public class EsameDTO {
	private int idEsame;
	private Date datainizio;
	private Date datafine;
	private String tipo;
	private int idInsegnamento;
	private int idAula;
	private int abilitazione;
	private String nomeInsegnamento;
	private String nomeDocente;
	private String nomeaula;

	public int getAbilitazione() {
		return abilitazione;
	}

	public void setAbilitazione(int abilitazione) {
		this.abilitazione = abilitazione;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

	public int getIdEsame() {
		return idEsame;
	}

	public void setIdEsame(int idEsame) {
		this.idEsame = idEsame;
	}

	public String getNomeInsegnamento() {
		return nomeInsegnamento;
	}

	public void setNomeInsegnamento(String nomeInsegnamento) {
		this.nomeInsegnamento = nomeInsegnamento;
	}

	public String getNomeaula() {
		return nomeaula;
	}

	public void setNomeaula(String nomeaula) {
		this.nomeaula = nomeaula;
	}

	public String getNomeDocente() {
		return nomeDocente;
	}

	public void setNomeDocente(String nomeDocente) {
		this.nomeDocente = nomeDocente;
	}
}
