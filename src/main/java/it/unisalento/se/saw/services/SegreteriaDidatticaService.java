package it.unisalento.se.saw.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.unisalento.se.saw.Iservices.ISegreteriaDidatticaService;
import it.unisalento.se.saw.domain.Corso;
import it.unisalento.se.saw.domain.SegreteriaDidattica;
import it.unisalento.se.saw.exceptions.SegreteriaDidatticaNotFoundException;
import it.unisalento.se.saw.repositories.SegreteriaDidatticaRepository;

public class SegreteriaDidatticaService implements ISegreteriaDidatticaService{
	@Autowired
	SegreteriaDidatticaRepository segreteriaRepository;
	
	@Override
	public List<SegreteriaDidattica> getAll() throws SegreteriaDidatticaNotFoundException {
		// TODO Auto-generated method stub
		return segreteriaRepository.findAll();
	}

	@Override
	public SegreteriaDidattica save(SegreteriaDidattica segreteria) {
		// TODO Auto-generated method stub
		return segreteriaRepository.save(segreteria);
	}

	@Override
	public void removeSegnalazioneById(int id) throws SegreteriaDidatticaNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SegreteriaDidattica getById(int id) throws SegreteriaDidatticaNotFoundException {
		// TODO Auto-generated method stub
		return segreteriaRepository.getOne(id);
	}

	@Override
	public int count() throws SegreteriaDidatticaNotFoundException {
		// TODO Auto-generated method stub
		return (int) segreteriaRepository.count();
	}
	
}
