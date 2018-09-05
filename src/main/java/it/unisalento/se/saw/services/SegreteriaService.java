package it.unisalento.se.saw.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.unisalento.se.saw.Iservices.ISegreteriaService;
import it.unisalento.se.saw.domain.Corso;
import it.unisalento.se.saw.domain.Segreteria;
import it.unisalento.se.saw.exceptions.SegreteriaNotFoundException;
import it.unisalento.se.saw.repositories.SegreteriaRepository;

@Service
public class SegreteriaService implements ISegreteriaService{
	@Autowired
	SegreteriaRepository segreteriaRepository;
	
	@Override
	public List<Segreteria> getAll() throws SegreteriaNotFoundException {
		// TODO Auto-generated method stub
		return segreteriaRepository.findAll();
	}

	@Override
	public Segreteria save(Segreteria segreteria) {
		// TODO Auto-generated method stub
		return segreteriaRepository.save(segreteria);
	}

	@Override
	public void removeSegnalazioneById(int id) throws SegreteriaNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Segreteria getById(int id) throws SegreteriaNotFoundException {
		// TODO Auto-generated method stub
		return segreteriaRepository.getOne(id);
	}

	@Override
	public int count() throws SegreteriaNotFoundException {
		// TODO Auto-generated method stub
		return (int) segreteriaRepository.count();
	}
	
}
