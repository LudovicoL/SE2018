package it.unisalento.se.saw.dto;

public class DocenteDTO {
	private int idDocente;
	private String nome;
	private String cognome;
	private String data;
	private String email;
	private String password;
	private String indirizzo;
	private int stipendio;
	private int abilitazione;
	private int idUtente;

	
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
	public int getStipendio() {
		return stipendio;
	}
	public void setStipendio(int stipendio) {
		this.stipendio = stipendio;
	}
	public int getIdDocente() {
		return idDocente;
	}
	public void setIdDocente(int idDocente) {
		this.idDocente = idDocente;
	}
	public int getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}
	
}