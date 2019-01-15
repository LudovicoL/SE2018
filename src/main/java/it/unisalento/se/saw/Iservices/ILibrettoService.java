package it.unisalento.se.saw.Iservices;

import java.util.List;

import it.unisalento.se.saw.domain.Insegnamento;
import it.unisalento.se.saw.domain.Libretto;
import it.unisalento.se.saw.domain.Materiale;
import it.unisalento.se.saw.domain.Studente;
import it.unisalento.se.saw.dto.LibrettoDTO;
import it.unisalento.se.saw.exceptions.LibrettoNotFoundException;


public interface ILibrettoService {
	public List<Libretto> getAll() throws LibrettoNotFoundException;
	public Libretto save(Libretto libretto);
	public void removeLibrettoById (int id) throws LibrettoNotFoundException;
	public Libretto getById(int id) throws LibrettoNotFoundException;
	public void update(LibrettoDTO librettoDTO);
	public Libretto getByIds(Studente studente, Insegnamento insegnamento);
	public List<Libretto> getByIdStudente(Studente studente);
	public List<Studente> getStudentiByIdInsegnamento(Insegnamento insegnamento);

}
