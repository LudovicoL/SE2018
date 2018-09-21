package it.unisalento.se.saw.Iservices;

import java.util.List;

import it.unisalento.se.saw.domain.Insegnamento;
import it.unisalento.se.saw.dto.InsegnamentoDTO;
import it.unisalento.se.saw.exceptions.InsegnamentoNotFoundException;

public interface IInsegnamentoService {
	public List<Insegnamento> getAll() throws InsegnamentoNotFoundException;
	public void save(Insegnamento insegnamento);
	public void removeInsegnamentoById (int id) throws InsegnamentoNotFoundException;
	public Insegnamento getById(int id) throws InsegnamentoNotFoundException;
	public int count() throws InsegnamentoNotFoundException;
	public void update(InsegnamentoDTO insegnamentoDTO);
	public void updateAbilitazione(InsegnamentoDTO insegnamentoDTO);

}
