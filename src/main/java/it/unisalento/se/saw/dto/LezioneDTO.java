package it.unisalento.se.saw.dto;

public class LezioneDTO {
	private String data;
	private int idInsegnamento;
	private int idAula;
	private boolean abilitazione;
	
	public boolean isAbilitazione() {
		return abilitazione;
	}
	public void setAbilitazione(boolean abilitazione) {
		this.abilitazione = abilitazione;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
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
}
