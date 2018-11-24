package it.unisalento.se.saw.Iservices;

import java.util.List;

import it.unisalento.se.saw.domain.Docente;
import it.unisalento.se.saw.domain.Lezione;
import it.unisalento.se.saw.domain.Materiale;
import it.unisalento.se.saw.dto.MaterialeDTO;
import it.unisalento.se.saw.exceptions.MaterialeNotFoundException;

public interface IMaterialeService {
	public List<Materiale> getAll() throws MaterialeNotFoundException;
	public Materiale save(Materiale materiale);
	public void removeMaterialeById (int id) throws MaterialeNotFoundException;
	public Materiale getById(int id) throws MaterialeNotFoundException;
	public int count() throws MaterialeNotFoundException;
	public void update(Materiale materiale);
}
