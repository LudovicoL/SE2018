package it.unisalento.se.saw.Iservices;

import java.text.ParseException;
import java.util.List;

import it.unisalento.se.saw.domain.Docente;
import it.unisalento.se.saw.dto.DocenteDTO;
import it.unisalento.se.saw.exceptions.DocenteNotFoundException;
import it.unisalento.se.saw.exceptions.UtenteNotFoundException;

public interface IDocenteService {
	public List<Docente> getAll() throws DocenteNotFoundException;
	public Docente save(Docente docente) throws ParseException, UtenteNotFoundException;
	public Docente getById(int id) throws DocenteNotFoundException;
	public int count() throws DocenteNotFoundException;
	public void update1(DocenteDTO docenteDTO);
	public void update2(DocenteDTO docenteDTO);

}
