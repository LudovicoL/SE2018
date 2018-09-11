package it.unisalento.se.saw.Iservices;

import java.util.List;

import it.unisalento.se.saw.domain.Segreteria;
import it.unisalento.se.saw.exceptions.SegreteriaNotFoundException;

public interface ISegreteriaService {
	public List<Segreteria> getAll() throws SegreteriaNotFoundException;
	public Segreteria save(Segreteria segreteria);
	public void removeSegnalazioneById (int id) throws SegreteriaNotFoundException;
	public Segreteria getById(int id) throws SegreteriaNotFoundException;
	public int count() throws SegreteriaNotFoundException;
	public void update(Segreteria segreteria);
}
