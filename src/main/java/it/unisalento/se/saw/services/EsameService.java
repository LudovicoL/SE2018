package it.unisalento.se.saw.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.unisalento.se.saw.Iservices.IEsameService;
import it.unisalento.se.saw.domain.Docente;
import it.unisalento.se.saw.domain.Esame;
import it.unisalento.se.saw.domain.Insegnamento;
import it.unisalento.se.saw.domain.Lezione;
import it.unisalento.se.saw.exceptions.EsameNotFoundException;
import it.unisalento.se.saw.repositories.EsameRepository;
import it.unisalento.se.saw.repositories.InsegnamentoRepository;
@Service
public class EsameService implements IEsameService{
	@Autowired
	EsameRepository esameRepository;
	@Autowired
	InsegnamentoRepository insegnamentoRepository;
	@Override
	public List<Esame> getAll() throws EsameNotFoundException {
		// TODO Auto-generated method stub
		return esameRepository.findAll();
	}

	@Override
	public Esame save(Esame esame) {
		// TODO Auto-generated method stub
		return esameRepository.save(esame);
	}

	@Override
	public void removeEsameById(int id) throws EsameNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Esame getById(int id) throws EsameNotFoundException {
		// TODO Auto-generated method stub
		return esameRepository.getOne(id);
	}

	@Override
	public int count() throws EsameNotFoundException {
		// TODO Auto-generated method stub
		return (int) esameRepository.count();
	}

	@Override
	public void update(Esame esame) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public int esameEsistente(Date datainizio,Date datafine,int idInsegnamento) {
		Insegnamento insegnamento=new Insegnamento();
		insegnamento=insegnamentoRepository.getOne(idInsegnamento);
		return esameRepository.esameEsistente(datainizio, datafine, insegnamento);
	}
	
	@Override
	public List<Esame> esameDocente(Date datainizio, Date datafine,Docente docente) {
		return esameRepository.esameDocente(datainizio,datafine,docente);
	}

	@Override
	public List<Esame> listaEsamiByInsegnamento(Date datainizio, Insegnamento insegnamento) {
		return esameRepository.esameInsegnamento(datainizio,insegnamento);
	}
	
	@Override
	public List<Esame> esameStudente(Date datainizio, Date datafine, Integer idstudente){
		return esameRepository.esameStudente(datainizio,datafine,idstudente);	
	}

}
