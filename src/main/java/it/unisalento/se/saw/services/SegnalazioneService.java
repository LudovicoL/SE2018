package it.unisalento.se.saw.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.unisalento.se.saw.Iservices.ISegnalazioneService;
import it.unisalento.se.saw.domain.Segnalazione;
import it.unisalento.se.saw.dto.SegnalazioneDTO;
import it.unisalento.se.saw.exceptions.SegnalazioneNotFoundException;
import it.unisalento.se.saw.repositories.SegnalazioneRepository;
@Service
public class SegnalazioneService implements ISegnalazioneService{
	@Autowired
	SegnalazioneRepository segnalazioneRepository;
	
	@Override
	public List<Segnalazione> getAll() throws SegnalazioneNotFoundException {
		// TODO Auto-generated method stub
		return segnalazioneRepository.findAll();
	}

	@Override
	public Segnalazione save(Segnalazione segnalazione) {
		// TODO Auto-generated method stub
		return segnalazioneRepository.save(segnalazione);
	}

	@Override
	public void removeSegnalazioneById(int id) throws SegnalazioneNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Segnalazione getById(int id) throws SegnalazioneNotFoundException {
		// TODO Auto-generated method stub
		return segnalazioneRepository.getOne(id);
	}

	@Override
	public int count() throws SegnalazioneNotFoundException {
		// TODO Auto-generated method stub
		return (int) segnalazioneRepository.count();
	}

	@Override
	public void update(SegnalazioneDTO segnalazioneDTO) {
		// TODO Auto-generated method stub
		segnalazioneRepository.update(segnalazioneDTO.getAbilitazione(), segnalazioneDTO.getIdSegnalazione());
	}
	
	@Override
	public void delete(int idSegnalazione) {
		// TODO Auto-generated method stub
		segnalazioneRepository.delete(idSegnalazione);
	}
}
