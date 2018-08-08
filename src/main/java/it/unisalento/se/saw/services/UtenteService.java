package it.unisalento.se.saw.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.unisalento.se.saw.Iservices.IUtenteService;
import it.unisalento.se.saw.domain.Utente;
import it.unisalento.se.saw.exceptions.UtenteNotFoundException;
import it.unisalento.se.saw.repositories.StudenteRepository;
import it.unisalento.se.saw.repositories.UtenteRepository;



@Service
public class UtenteService implements IUtenteService{
	
	@Autowired
	UtenteRepository utenteRepository;
	
	@Autowired
	StudenteRepository studenteRepository;


	@Override
	public List<Utente> getAll() throws UtenteNotFoundException {
		return utenteRepository.findAll();
	}

	@Override
	public Utente save(Utente utente) {
		return utenteRepository.save(utente);
	}

	@Override
	public Utente getById(int id) throws UtenteNotFoundException {
		// TODO Auto-generated method stub
		return utenteRepository.getOne(id);
	}
	
	@Override
	public int count() throws UtenteNotFoundException {
		// TODO Auto-generated method stub
		return (int) utenteRepository.count();
	}
	@Override
	public void removeUtenteById(int id) throws UtenteNotFoundException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Utente utentebyid(int id) throws UtenteNotFoundException {
		return utenteRepository.getUserByIdStudente(id);
		// TODO Auto-generated method stub
		
	}

}
