package it.unisalento.se.saw.dto;

public class LezioneDTO {
	private String datainizio;
	private String datafine;
	private int idInsegnamento;
	private int idAula;
	private int abilitazione;
	private int idLezione;
	
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
	public String getDatainizio() {
		return datainizio;
	}
	public void setDatainizio(String datainizio) {
		this.datainizio = datainizio;
	}
	public String getDatafine() {
		return datafine;
	}
	public void setDatafine(String datafine) {
		this.datafine = datafine;
	}
	public int getIdLezione() {
		return idLezione;
	}
	public void setIdLezione(int idLezione) {
		this.idLezione = idLezione;
	}
}
