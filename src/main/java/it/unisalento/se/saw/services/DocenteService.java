package it.unisalento.se.saw.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.unisalento.se.saw.Iservices.IDocenteService;
import it.unisalento.se.saw.domain.Corso;
import it.unisalento.se.saw.domain.Docente;
import it.unisalento.se.saw.dto.DocenteDTO;
import it.unisalento.se.saw.dto.StudenteDTO;
import it.unisalento.se.saw.exceptions.DocenteNotFoundException;
import it.unisalento.se.saw.repositories.DocenteRepository;

@Service
public class DocenteService implements IDocenteService{
	@Autowired
	DocenteRepository docenteRepository;
	
	@Override
	public List<Docente> getAll() throws DocenteNotFoundException {
		// TODO Auto-generated method stub
		return docenteRepository.findAll();
	}

	@Override
	public Docente save(Docente docente) {
		// TODO Auto-generated method stub
		return docenteRepository.save(docente);
	}

	@Override
	public Docente getById(int id) throws DocenteNotFoundException {
		// TODO Auto-generated method stub
		return docenteRepository.getOne(id);
	}

	@Override
	public int count() throws DocenteNotFoundException {
		// TODO Auto-generated method stub
		return (int) docenteRepository.count();
	}
	
	@Override
	public void update1(DocenteDTO docenteDTO) {
		docenteRepository.update1(docenteDTO.getStipendio(),docenteDTO.getIdDocente());
	}
	
	@Override
	public void update2(DocenteDTO docenteDTO) {
		docenteRepository.update2(docenteDTO.getEmail(),docenteDTO.getIndirizzo(),docenteDTO.getIdUtente());
	}
	
	@Override
	public void updateAbilitazione(DocenteDTO docenteDTO) {
		docenteRepository.updateAbilitazione(docenteDTO.getIdUtente(),docenteDTO.getAbilitazione());
	}	
}
