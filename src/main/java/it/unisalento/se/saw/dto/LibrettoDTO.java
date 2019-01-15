package it.unisalento.se.saw.dto;

import it.unisalento.se.saw.domain.Insegnamento;
import it.unisalento.se.saw.domain.Studente;

public class LibrettoDTO {
	private Integer idLibretto;
	private Integer attivo;
	private Integer idStudente;
	private Integer idInsegnamento;
	private String nomeInsegnamento;
	private Integer idDocente;

	public Integer getIdLibretto() {
		return idLibretto;
	}
	public void setIdLibretto(Integer idLibretto) {
		this.idLibretto = idLibretto;
	}
	public Integer getAttivo() {
		return attivo;
	}
	public void setAttivo(Integer attivo) {
		this.attivo = attivo;
	}
	public Integer getIdStudente() {
		return idStudente;
	}
	public void setIdStudente(Integer idStudente) {
		this.idStudente = idStudente;
	}
	public Integer getIdInsegnamento() {
		return idInsegnamento;
	}
	public void setIdInsegnamento(Integer idInsegnamento) {
		this.idInsegnamento = idInsegnamento;
	}
	public String getNomeInsegnamento() {
		return nomeInsegnamento;
	}
	public void setNomeInsegnamento(String nomeInsegnamento) {
		this.nomeInsegnamento = nomeInsegnamento;
	}
	public Integer getIdDocente() {
		return idDocente;
	}
	public void setIdDocente(Integer idDocente) {
		this.idDocente = idDocente;
	}


}
