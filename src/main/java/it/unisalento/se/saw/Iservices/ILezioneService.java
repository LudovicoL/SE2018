package it.unisalento.se.saw.Iservices;

import java.util.Date;
import java.util.List;

import it.unisalento.se.saw.domain.Docente;
import it.unisalento.se.saw.domain.Lezione;
import it.unisalento.se.saw.exceptions.LezioneNotFoundException;

public interface ILezioneService {
	public List<Lezione> getAll() throws LezioneNotFoundException;
	public Lezione save(Lezione lezione);
	public void removeLezioneById (int id) throws LezioneNotFoundException;
	public Lezione getById(int id) throws LezioneNotFoundException;
	public int count() throws LezioneNotFoundException;
	public void update(Lezione lezione);
	public int lezioneEsistente(Date datainizio, Date datafine, int idInsegnamento);
	public List<Lezione> lezioneDocente(Date datainizio, Date datafine,Docente docente);
}
