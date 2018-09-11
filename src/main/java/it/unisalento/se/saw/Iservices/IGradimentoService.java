package it.unisalento.se.saw.Iservices;

import java.util.List;

import it.unisalento.se.saw.domain.Gradimento;
import it.unisalento.se.saw.exceptions.GradimentoNotFoundException;

public class IGradimentoService {
	
	public List<Gradimento> getAll();
	public Gradimento save(Gradimento gradimento);
	public Gradimento getById(int id) throws GradimentoNotFoundException;
	public int count() throws GradimentoNotFoundException;
	public void update(Gradimento gradimento);

}
