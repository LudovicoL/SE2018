package it.unisalento.se.saw.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.unisalento.se.saw.Iservices.ILezioneService;
import it.unisalento.se.saw.domain.Lezione;
import it.unisalento.se.saw.exceptions.LezioneNotFoundException;
import it.unisalento.se.saw.repositories.LezioneRepository;

public class LezioneService implements ILezioneService{
	@Autowired
	LezioneRepository lezioneRepository;
	
	@Override
	public List<Lezione> getAll() throws LezioneNotFoundException {
		// TODO Auto-generated method stub
		return lezioneRepository.findAll();
	}

	@Override
	public Lezione save(Lezione lezione) {
		// TODO Auto-generated method stub
		return lezioneRepository.save(lezione);
	}

	@Override
	public void removeLezioneById(int id) throws LezioneNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Lezione getById(int id) throws LezioneNotFoundException {
		// TODO Auto-generated method stub
		return lezioneRepository.getOne(id);
	}

	@Override
	public int count() throws LezioneNotFoundException {
		// TODO Auto-generated method stub
		return (int) lezioneRepository.count();
	}

}
