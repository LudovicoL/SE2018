package it.unisalento.se.saw.dto;

public class InsegnamentoDTO {
	private int idInsegnamento;
	private String nome;
	private int cfu;
	private int anno;
	private int semestre;
	private int abilitazione;
	private int idCorso;
	
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
	public int getIdInsegnamento() {
		return idInsegnamento;
	}
	public void setIdInsegnamento(int idInsegnamento) {
		this.idInsegnamento = idInsegnamento;
	}
	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}
	public int getIdCorso() {
		return idCorso;
	}
	public void setIdCorso(int idCorso) {
		this.idCorso = idCorso;
	}
}
