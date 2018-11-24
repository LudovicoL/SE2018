package it.unisalento.se.saw.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.unisalento.se.saw.Iservices.IMaterialeService;
import it.unisalento.se.saw.domain.Docente;
import it.unisalento.se.saw.domain.Lezione;
import it.unisalento.se.saw.domain.Materiale;
import it.unisalento.se.saw.dto.MaterialeDTO;
import it.unisalento.se.saw.exceptions.MaterialeNotFoundException;
import it.unisalento.se.saw.repositories.MaterialeRepository;

@Service
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

	@Override
	public void update(Materiale materiale) {
		// TODO Auto-generated method stub
		
	}
	

}
