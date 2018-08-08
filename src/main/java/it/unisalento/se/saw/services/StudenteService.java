package it.unisalento.se.saw.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.unisalento.se.saw.Iservices.IStudenteService;
import it.unisalento.se.saw.domain.Studente;
import it.unisalento.se.saw.domain.Utente;
import it.unisalento.se.saw.exceptions.StudenteNotFoundException;
import it.unisalento.se.saw.repositories.StudenteRepository;
import it.unisalento.se.saw.repositories.UtenteRepository;


@Service
public class StudenteService implements IStudenteService{
	
	@Autowired
	UtenteRepository utenteRepository;
	
	@Autowired
	StudenteRepository studenteRepository;


	
	@Transactional
	public Studente getById(int id) throws StudenteNotFoundException {
		return studenteRepository.getOne(id);
	}

	@Override
	public List<Studente> getAll() throws StudenteNotFoundException {
		// TODO Auto-generated method stub
		return studenteRepository.findAll();
	}
	
	
	
	@Transactional
	public Studente save(Studente studente) {
		// TODO Auto-generated method stub
		return studenteRepository.save(studente);
	}
	
	
/*
	@Transactional(rollbackFor=StudenteNotFoundException.class)
	public void removeStudenteById (int id) throws StudenteNotFoundException {
		try {
			Studente studente = studenteRepository.getOne(id);
			studenteRepository.delete(studente);
		} catch(Exception e) {
			throw new StudenteNotFoundException();
		}
	}	*/
}
