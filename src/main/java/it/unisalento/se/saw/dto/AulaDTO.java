package it.unisalento.se.saw.dto;

public class AulaDTO {
	private String nome;
	private String grandezza;
	private double latitudine;
	private double longitudine;
	private int abilitazione;
	
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
	public String getGrandezza() {
		return grandezza;
	}
	public void setGrandezza(String grandezza) {
		this.grandezza = grandezza;
	}
	public double getLatitudine() {
		return latitudine;
	}
	public void setLatitudine(double latitudine) {
		this.latitudine = latitudine;
	}
	public double getLongitudine() {
		return longitudine;
	}
	public void setLongitudine(double longitudine) {
		this.longitudine = longitudine;
	}
	
}