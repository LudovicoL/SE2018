package it.unisalento.se.saw.Iservices;

import java.util.List;

import it.unisalento.se.saw.domain.SegreteriaDidattica;
import it.unisalento.se.saw.exceptions.SegreteriaDidatticaNotFoundException;

public interface ISegreteriaDidatticaService {
	public List<SegreteriaDidattica> getAll() throws SegreteriaDidatticaNotFoundException;
	public SegreteriaDidattica save(SegreteriaDidattica segreteria);
	public void removeSegnalazioneById (int id) throws SegreteriaDidatticaNotFoundException;
	public SegreteriaDidattica getById(int id) throws SegreteriaDidatticaNotFoundException;
	public int count() throws SegreteriaDidatticaNotFoundException;
}
