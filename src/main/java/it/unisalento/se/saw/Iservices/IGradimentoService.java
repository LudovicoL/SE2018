package it.unisalento.se.saw.Iservices;

import java.util.List;

import it.unisalento.se.saw.domain.Gradimento;
import it.unisalento.se.saw.domain.Materiale;
import it.unisalento.se.saw.domain.Studente;
import it.unisalento.se.saw.exceptions.GradimentoNotFoundException;

public interface IGradimentoService {

	public List<Gradimento> getAll();
	public Gradimento save(Gradimento gradimento);
	public Gradimento getById(int id) ;
	public int count();
	//public void update(Gradimento gradimento);
	public Integer getGiaVotato(Studente studente, Materiale idMateriale);

}
