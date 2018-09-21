package it.unisalento.se.saw.adapter;

import it.unisalento.se.saw.domain.Docente;
import it.unisalento.se.saw.domain.Utente;
import it.unisalento.se.saw.dto.DocenteDTO;

public class DocenteAdapter {

	public static Docente DocenteDTOToDocente(DocenteDTO docenteDTO,Utente utente){
		Docente docente=new Docente();
		docente.setStipendio(docenteDTO.getStipendio());
		docente.setUtente(utente);
		return docente;	
	}

	public static DocenteDTO DocenteToDocenteDTO(Docente docente,Utente utente){
		DocenteDTO docenteDTO=new DocenteDTO();
		docenteDTO.setNome(utente.getNome());
		docenteDTO.setCognome(utente.getCognome());
		docenteDTO.setData(utente.getDatanascita().toString());
		docenteDTO.setEmail(utente.getEmail());
		docenteDTO.setStipendio(docente.getStipendio());
		docenteDTO.setIndirizzo(utente.getIndirizzo());
		docenteDTO.setIdDocente(docente.getIdDocente());
		docenteDTO.setIdUtente(utente.getIdUtente());
		if(utente.getAbilitazione()==1)
			docenteDTO.setAbilit("Attivo");
		else
			docenteDTO.setAbilit("Disattivo");
		return docenteDTO;
	}

}
