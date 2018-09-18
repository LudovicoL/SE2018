package it.unisalento.se.saw.Iservices;

import java.util.List;

import it.unisalento.se.saw.domain.Strumento;
import it.unisalento.se.saw.dto.StrumentoDTO;
import it.unisalento.se.saw.exceptions.StrumentoNotFoundException;

public interface IStrumentoService {
	public List<Strumento> getAll() throws StrumentoNotFoundException;
	public Strumento save(Strumento strumento);
	public void removeStrumentoById (int id) throws StrumentoNotFoundException;
	public Strumento getById(int id) throws StrumentoNotFoundException;
	public int count() throws StrumentoNotFoundException;
	public void update(StrumentoDTO strumentoDTO);
}
