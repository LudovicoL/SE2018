package it.unisalento.se.saw.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.unisalento.se.saw.Iservices.IInsegnamentoService;
import it.unisalento.se.saw.domain.Insegnamento;
import it.unisalento.se.saw.dto.InsegnamentoDTO;
import it.unisalento.se.saw.exceptions.InsegnamentoNotFoundException;
import it.unisalento.se.saw.repositories.InsegnamentoRepository;

@Service
public class InsegnamentoService implements IInsegnamentoService{
	@Autowired
	InsegnamentoRepository insegnamentoRepository;
	
	@Override
	public List<Insegnamento> getAll() {
		// TODO Auto-generated method stub
		return insegnamentoRepository.findAll();
	}

	
	@Override
	public void save(Insegnamento insegnamento) {
		// TODO Auto-generated method stub
		insegnamentoRepository.save(insegnamento);
	}

	@Override
	public void removeInsegnamentoById(int id) throws InsegnamentoNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Insegnamento getById(int id) throws InsegnamentoNotFoundException {
		// TODO Auto-generated method stub
		return insegnamentoRepository.getOne(id);
	}

	@Override
	public int count() throws InsegnamentoNotFoundException {
		// TODO Auto-generated method stub
		return (int) insegnamentoRepository.count();
	}

}
