package it.unisalento.se.saw.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.unisalento.se.saw.Iservices.ICorsoService;
import it.unisalento.se.saw.domain.Corso;
import it.unisalento.se.saw.exceptions.CorsoNotFoundException;
import it.unisalento.se.saw.repositories.CorsoRepository;

@Service
public class CorsoService implements ICorsoService{
	@Autowired
	CorsoRepository corsoRepository;
	
	@Override
	public List<Corso> getAll() {
		// TODO Auto-generated method stub
		return corsoRepository.findAll();
	}

	@Override
	public Corso save(Corso corso) {
		// TODO Auto-generated method stub
		return corsoRepository.save(corso);
	}

	@Override
	public Corso getById(int id) throws CorsoNotFoundException {
		// TODO Auto-generated method stub
		return corsoRepository.getOne(id);
	}

	@Override
	public int count() throws CorsoNotFoundException {
		// TODO Auto-generated method stub
		return (int) corsoRepository.count();
	}
	
	@Override
	public Corso update(Corso corso) {
		return corsoRepository.update(corso.getNome());
	}

}
