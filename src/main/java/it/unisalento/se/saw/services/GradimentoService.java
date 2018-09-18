package it.unisalento.se.saw.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.unisalento.se.saw.Iservices.ICorsoService;
import it.unisalento.se.saw.Iservices.IGradimentoService;
import it.unisalento.se.saw.domain.Corso;
import it.unisalento.se.saw.domain.Gradimento;
import it.unisalento.se.saw.exceptions.CorsoNotFoundException;
import it.unisalento.se.saw.repositories.CorsoRepository;
import it.unisalento.se.saw.repositories.GradimentoRepository;

@Service
public class GradimentoService implements IGradimentoService{
	@Autowired
	GradimentoRepository gradimentoRepository;
	
	@Override
	public List<Gradimento> getAll() {
		// TODO Auto-generated method stub
		return gradimentoRepository.findAll();
	}

	@Override
	public Gradimento save(Gradimento gradimento) {
		// TODO Auto-generated method stub
		return gradimentoRepository.save(gradimento);
	}

	@Override
	public Gradimento getById(int id) {
		// TODO Auto-generated method stub
		return gradimentoRepository.getOne(id);
	}

	@Override
	public int count()  {
		// TODO Auto-generated method stub
		return (int) gradimentoRepository.count();
	}


}
