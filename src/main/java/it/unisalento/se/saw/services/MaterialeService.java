package it.unisalento.se.saw.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.unisalento.se.saw.Iservices.IMaterialeService;
import it.unisalento.se.saw.domain.Materiale;
import it.unisalento.se.saw.exceptions.MaterialeNotFoundException;
import it.unisalento.se.saw.repositories.MaterialeRepository;

public class MaterialeService implements IMaterialeService{
	@Autowired
	MaterialeRepository materialeRepository;
	
	@Override
	public List<Materiale> getAll() throws MaterialeNotFoundException {
		// TODO Auto-generated method stub
		return materialeRepository.findAll();
	}

	@Override
	public Materiale save(Materiale materiale) {
		// TODO Auto-generated method stub
		return materialeRepository.save(materiale);
	}

	@Override
	public void removeMaterialeById(int id) throws MaterialeNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Materiale getById(int id) throws MaterialeNotFoundException {
		// TODO Auto-generated method stub
		return materialeRepository.getOne(id);
	}

	@Override
	public int count() throws MaterialeNotFoundException {
		// TODO Auto-generated method stub
		return (int) materialeRepository.count();
	}

}
