package it.unisalento.se.saw.dto;

public class InsegnamentoDTO {
	private String nome;
	private int cfu;
	private int semestre;
	private boolean abilitazione;
	
	public boolean isAbilitazione() {
		return abilitazione;
	}
	public void setAbilitazione(boolean abilitazione) {
		this.abilitazione = abilitazione;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCfu() {
		return cfu;
	}
	public void setCfu(int cfu) {
		this.cfu = cfu;
	}
	public int getSemestre() {
		return semestre;
	}
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
}
