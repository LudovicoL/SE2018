package it.unisalento.se.saw.Iservices;

import java.util.List;

import it.unisalento.se.saw.domain.SegreteriaDidattica;
import it.unisalento.se.saw.exceptions.SegreteriaNotFoundException;

public interface ISegreteriaService {
	public List<SegreteriaDidattica> getAll() throws SegreteriaNotFoundException;
	public SegreteriaDidattica save(SegreteriaDidattica segreteria);
	public void removeSegnalazioneById (int id) throws SegreteriaNotFoundException;
	public SegreteriaDidattica getById(int id) throws SegreteriaNotFoundException;
	public int count() throws SegreteriaNotFoundException;
}
