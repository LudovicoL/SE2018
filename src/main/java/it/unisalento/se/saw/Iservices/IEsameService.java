package it.unisalento.se.saw.Iservices;

import java.util.Date;
import java.util.List;

import it.unisalento.se.saw.domain.Docente;
import it.unisalento.se.saw.domain.Esame;
import it.unisalento.se.saw.domain.Insegnamento;
import it.unisalento.se.saw.exceptions.EsameNotFoundException;

public interface IEsameService {
	public List<Esame> getAll() throws EsameNotFoundException;
	public Esame save(Esame esame);
	public void removeEsameById (int id) throws EsameNotFoundException;
	public Esame getById(int id) throws EsameNotFoundException;
	public int count() throws EsameNotFoundException;
	public void update(Esame esame);
	int esameEsistente(Date datainizio, Date datafine, int idInsegnamento);
	List<Esame> esameDocente(Date datainizio, Date datafine, Docente docente);
	List<Esame> listaEsamiByInsegnamento(Date datainizio, Insegnamento insegnamento);
	List<Esame> esameStudente(Date datainizio, Date datafine, Integer idstudente);

}
