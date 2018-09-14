package it.unisalento.se.saw.Iservices;

import java.util.List;

import it.unisalento.se.saw.domain.Corso;
import it.unisalento.se.saw.exceptions.CorsoNotFoundException;

public interface ICorsoService {

	public List<Corso> getAll();
	public Corso save(Corso corso);
	public Corso getById(int id) throws CorsoNotFoundException;
	public int count() throws CorsoNotFoundException;
	public void update(Corso corso);
}
