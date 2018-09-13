package it.unisalento.se.saw.dto;

public class StudenteDTO {
	private String nome;
	private String cognome;
	private String data;
	private String email;
	private String password;
	private String indirizzo;
	private int matricola;
	private int idcorso;
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
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public int getMatricola() {
		return matricola;
	}
	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}
	public int getIdcorso() {
		return idcorso;
	}
	public void setIdcorso(int idcorso) {
		this.idcorso = idcorso;
	}
}