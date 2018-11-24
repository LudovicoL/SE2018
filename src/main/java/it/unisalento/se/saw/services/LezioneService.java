package it.unisalento.se.saw.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.unisalento.se.saw.Iservices.ILezioneService;
import it.unisalento.se.saw.domain.Docente;
import it.unisalento.se.saw.domain.Insegnamento;
import it.unisalento.se.saw.domain.Lezione;
import it.unisalento.se.saw.domain.Studente;
import it.unisalento.se.saw.exceptions.LezioneNotFoundException;
import it.unisalento.se.saw.repositories.InsegnamentoRepository;
import it.unisalento.se.saw.repositories.LezioneRepository;
@Service
public class LezioneService implements ILezioneService{
	@Autowired
	LezioneRepository lezioneRepository;
	@Autowired
	InsegnamentoRepository insegnamentoRepository;
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

	@Override
	public void update(Lezione lezione) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public int lezioneEsistente(Date datainizio,Date datafine,int idInsegnamento) {
		Insegnamento insegnamento=new Insegnamento();
		insegnamento=insegnamentoRepository.getOne(idInsegnamento);
		return lezioneRepository.lezioneEsistente(datainizio, datafine, insegnamento);
	}
	
	@Override
	public List<Lezione> lezioneDocente(Date datainizio, Date datafine,Docente docente) {
		return lezioneRepository.lezioneDocente(datainizio,datafine,docente);
	}
	@Override
	public List<Lezione> lezioneStudente(Date datainizio, Date datafine,Integer idstudente) {
		return lezioneRepository.lezioneStudente(datainizio,datafine,idstudente);
	}
	
	@Override
	public List<Lezione> lezioneInsegnamento(int idInsegnamento){
		Insegnamento insegnamento=insegnamentoRepository.getOne(idInsegnamento);
		return lezioneRepository.lezioneInsegnamento(insegnamento);
	}
}
