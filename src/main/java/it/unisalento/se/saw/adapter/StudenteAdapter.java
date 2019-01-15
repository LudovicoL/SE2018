package it.unisalento.se.saw.adapter;

import org.springframework.beans.factory.annotation.Autowired;

import it.unisalento.se.saw.domain.Corso;
import it.unisalento.se.saw.domain.Studente;
import it.unisalento.se.saw.domain.Utente;
import it.unisalento.se.saw.dto.StudenteDTO;

public class StudenteAdapter {
	
	public static Studente StudenteDTOToStudente(StudenteDTO studenteDTO,Utente utente,Corso corso){
		Studente studente=new Studente();
		studente.setMatricola(studenteDTO.getMatricola());
		studente.setCorso(corso);
		studente.setUtente(utente);
		studente.setIdStudente(studenteDTO.getIdStudente());
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
		studenteDTO.setIdUtente(utente.getIdUtente());
		studenteDTO.setIdStudente(studente.getIdStudente());
		studenteDTO.setPassword(utente.getPassword());
		if(utente.getAbilitazione()==1)
			studenteDTO.setAbilit("Attivo");
		else
			studenteDTO.setAbilit("Disattivo");
		return studenteDTO;
	}

}
