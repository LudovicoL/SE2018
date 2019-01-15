package it.unisalento.se.saw.services;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import it.unisalento.se.saw.Iservices.ILibrettoService;
import it.unisalento.se.saw.domain.Insegnamento;
import it.unisalento.se.saw.domain.Libretto;
import it.unisalento.se.saw.domain.Studente;
import it.unisalento.se.saw.dto.LibrettoDTO;
import it.unisalento.se.saw.exceptions.LezioneNotFoundException;
import it.unisalento.se.saw.exceptions.LibrettoNotFoundException;
import it.unisalento.se.saw.repositories.LibrettoRepository;

@Service
public class LibrettoService implements ILibrettoService{

	@Autowired
	LibrettoRepository librettoRepository;
	
	@Override
	public List<Libretto> getAll() throws LibrettoNotFoundException {
		// TODO Auto-generated method stub
		return librettoRepository.findAll();
	}

	@Override
	public Libretto save(Libretto libretto) {
		// TODO Auto-generated method stub
		return librettoRepository.save(libretto);
	}

	@Override
	public void removeLibrettoById(int id) throws LibrettoNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Libretto getById(int id) throws LibrettoNotFoundException {
		// TODO Auto-generated method stub
		return librettoRepository.getOne(id);
	}

	@Override
	public void update(LibrettoDTO librettoDTO) {
		// TODO Auto-generated method stub
		librettoRepository.update(librettoDTO.getIdLibretto(),librettoDTO.getAttivo());
	}
	
	@Override
	public Libretto getByIds(Studente studente, Insegnamento insegnamento){
		return librettoRepository.getLibrettoByIds(studente, insegnamento);
	}
	
	@Override
	public List<Libretto> getByIdStudente(Studente studente){
		return librettoRepository.getLibrettoByIdStudente(studente);
	}

	@Override
	public List<Studente> getStudentiByIdInsegnamento(Insegnamento insegnamento){
		return librettoRepository.getStudentiByIdInsegnamento(insegnamento);
	}

}
