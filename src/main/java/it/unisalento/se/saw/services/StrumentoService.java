package it.unisalento.se.saw.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.unisalento.se.saw.Iservices.IStrumentoService;
import it.unisalento.se.saw.domain.Strumento;
import it.unisalento.se.saw.exceptions.StrumentoNotFoundException;
import it.unisalento.se.saw.repositories.StrumentoRepository;
@Service
public class StrumentoService implements IStrumentoService{
	@Autowired
	StrumentoRepository strumentoRepository;
	
	@Override
	public List<Strumento> getAll() throws StrumentoNotFoundException {
		// TODO Auto-generated method stub
		return strumentoRepository.findAll();
	}

	@Override
	public Strumento save(Strumento strumento) {
		// TODO Auto-generated method stub
		return strumentoRepository.save(strumento);
	}

	@Override
	public void removeStrumentoById(int id) throws StrumentoNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Strumento getById(int id) throws StrumentoNotFoundException {
		// TODO Auto-generated method stub
		return strumentoRepository.getOne(id);
	}

	@Override
	public int count() throws StrumentoNotFoundException {
		// TODO Auto-generated method stub
		return (int) strumentoRepository.count();
	}

}
