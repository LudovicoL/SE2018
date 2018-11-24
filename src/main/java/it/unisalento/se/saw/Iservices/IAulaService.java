package it.unisalento.se.saw.Iservices;

import java.util.Date;
import java.util.List;

import it.unisalento.se.saw.domain.Aula;
import it.unisalento.se.saw.exceptions.AulaNotFoundException;

public interface IAulaService {
	public List<Aula> getAll() throws AulaNotFoundException;
	public Aula save(Aula aula);
	public void removeAulaById (int id) throws AulaNotFoundException;
	public Aula getById(int id) throws AulaNotFoundException;
	public int count() throws AulaNotFoundException;
	public void update(Aula aula);
	public void delete(int idAula);
	public List<Aula> auleLibere(Date datainizio, Date datafine);
	List<Aula> auleLibereEsame(Date datainizio, Date datafine);
}
