package it.unisalento.se.saw.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.unisalento.se.saw.Iservices.ISegreteriaService;
import it.unisalento.se.saw.domain.SegreteriaDidattica;
import it.unisalento.se.saw.exceptions.SegreteriaNotFoundException;
import it.unisalento.se.saw.repositories.SegreteriaRepository;

public class SegreteriaService implements ISegreteriaService{
	@Autowired
	SegreteriaRepository segreteriaRepository;
	
	@Override
	public List<SegreteriaDidattica> getAll() throws SegreteriaNotFoundException {
		// TODO Auto-generated method stub
		return segreteriaRepository.findAll();
	}

	@Override
	public SegreteriaDidattica save(SegreteriaDidattica segreteria) {
		// TODO Auto-generated method stub
		return segreteriaRepository.save(segreteria);
	}

	@Override
	public void removeSegnalazioneById(int id) throws SegreteriaNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SegreteriaDidattica getById(int id) throws SegreteriaNotFoundException {
		// TODO Auto-generated method stub
		return segreteriaRepository.getOne(id);
	}

	@Override
	public int count() throws SegreteriaNotFoundException {
		// TODO Auto-generated method stub
		return (int) segreteriaRepository.count();
	}

}
