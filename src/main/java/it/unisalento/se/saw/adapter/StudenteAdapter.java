package it.unisalento.se.saw.adapter;

import org.springframework.beans.factory.annotation.Autowired;

import it.unisalento.se.saw.domain.Corso;
import it.unisalento.se.saw.domain.Studente;
import it.unisalento.se.saw.domain.Utente;
import it.unisalento.se.saw.dto.StudenteDTO;
import it.unisalento.se.saw.services.CorsoService;

public class StudenteAdapter {
	@Autowired
	CorsoService corsoService;
	
	public static Studente StudenteDTOToStudente(StudenteDTO studenteDTO,Utente utente,Corso corso){
		Studente studente=new Studente();
		studente.setMatricola(studenteDTO.getMatricola());
		studente.setCorso(corso);
		studente.setUtente(utente);
		return studente;	
	}

	public static StudenteDTO StudenteToStudenteDTO(Studente studente,Utente utente){
		StudenteDTO studenteDTO=new StudenteDTO();
		studenteDTO.setMatricola(studente.getMatricola());
		studenteDTO.setIdcorso(studente.getCorso().getIdCorso());
		studenteDTO.setNome(utente.getNome());
		studenteDTO.setCognome(utente.getCognome());
		studenteDTO.setData(utente.getDatanascita().toString());
		studenteDTO.setEmail(utente.getEmail());
		studenteDTO.setIndirizzo(utente.getIndirizzo());	
		return studenteDTO;
	}

}
