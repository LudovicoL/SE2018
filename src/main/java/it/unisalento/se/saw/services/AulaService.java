package it.unisalento.se.saw.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import it.unisalento.se.saw.Iservices.IAulaService;
import it.unisalento.se.saw.domain.Aula;
import it.unisalento.se.saw.exceptions.AulaNotFoundException;
import it.unisalento.se.saw.repositories.AulaRepository;

@Service
public class AulaService implements IAulaService{

	@Autowired
	AulaRepository aulaRepository;
	
	@Override
	public List<Aula> getAll() throws AulaNotFoundException {
		// TODO Auto-generated method stub
		return aulaRepository.findAll();
	}

	@Override
	public Aula save(Aula aula) {
		// TODO Auto-generated method stub
		return aulaRepository.save(aula);
	}

	@Override
	public void removeAulaById(int id) throws AulaNotFoundException {
		// TODO Auto-generated method stub
		aulaRepository.deleteById(id);
	}

	@Override
	public Aula getById(int id) throws AulaNotFoundException {
		// TODO Auto-generated method stub
		return aulaRepository.getOne(id);
	}

	@Override
	public int count() throws AulaNotFoundException {
		// TODO Auto-generated method stub
		return (int) aulaRepository.count();
	}

	@Override
	public void update(Aula aula) {
		// TODO Auto-generated method stub
		
	}
}
