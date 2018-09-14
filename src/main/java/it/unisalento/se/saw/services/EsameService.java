package it.unisalento.se.saw.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.unisalento.se.saw.Iservices.IEsameService;
import it.unisalento.se.saw.domain.Esame;
import it.unisalento.se.saw.exceptions.EsameNotFoundException;
import it.unisalento.se.saw.repositories.EsameRepository;

public class EsameService implements IEsameService{
	@Autowired
	EsameRepository esameRepository;
	
	@Override
	public List<Esame> getAll() throws EsameNotFoundException {
		// TODO Auto-generated method stub
		return esameRepository.findAll();
	}

	@Override
	public Esame save(Esame esame) {
		// TODO Auto-generated method stub
		return esameRepository.save(esame);
	}

	@Override
	public void removeEsameById(int id) throws EsameNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Esame getById(int id) throws EsameNotFoundException {
		// TODO Auto-generated method stub
		return esameRepository.getOne(id);
	}

	@Override
	public int count() throws EsameNotFoundException {
		// TODO Auto-generated method stub
		return (int) esameRepository.count();
	}

	@Override
	public void update(Esame esame) {
		// TODO Auto-generated method stub
		
	}

}
