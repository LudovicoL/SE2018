package it.unisalento.se.saw.Iservices;

import java.util.List;

import it.unisalento.se.saw.domain.Utente;
import it.unisalento.se.saw.exceptions.UtenteNotFoundException;


public interface IUtenteService {
	public List<Utente> getAll() throws UtenteNotFoundException;
	public Utente save(Utente utente);
	public void removeUtenteById (int id) throws UtenteNotFoundException;
	public Utente getById(int id) throws UtenteNotFoundException;
	public int count() throws UtenteNotFoundException;
	Utente utentebyid(int id) throws UtenteNotFoundException;
}
