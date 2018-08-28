package it.unisalento.se.saw.dto;

public class AulaDTO {
	private String name;
	private String grandezza;
	private double latitudine;
	private double longitudine;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
