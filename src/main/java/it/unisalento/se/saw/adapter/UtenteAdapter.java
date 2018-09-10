package it.unisalento.se.saw.adapter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import it.unisalento.se.saw.domain.Utente;
import it.unisalento.se.saw.dto.DocenteDTO;
import it.unisalento.se.saw.dto.StudenteDTO;

public class UtenteAdapter {
	public static Utente DocenteDTOToUtente(DocenteDTO docenteDTO) throws ParseException{
		DateFormat formatter1;
		formatter1 = new SimpleDateFormat("yyyy-mm-DD");
		Utente utente=new Utente();
		utente.setNome(docenteDTO.getNome());
		utente.setCognome(docenteDTO.getCognome());
		utente.setDatanascita(formatter1.parse(docenteDTO.getData()));
		utente.setEmail(docenteDTO.getEmail());
		utente.setIndirizzo(docenteDTO.getIndirizzo());
		utente.setPassword(docenteDTO.getPassword());
		return utente;
	}
	
	public static Utente StudenteDTOToUtente(StudenteDTO studenteDTO) throws ParseException{
		DateFormat formatter1;
		formatter1 = new SimpleDateFormat("yyyy-mm-DD");
		Utente utente=new Utente();
		utente.setNome(studenteDTO.getNome());
		utente.setCognome(studenteDTO.getCognome());
		utente.setDatanascita(formatter1.parse(studenteDTO.getData()));
		utente.setEmail(studenteDTO.getEmail());
		utente.setIndirizzo(studenteDTO.getIndirizzo());
		utente.setPassword(studenteDTO.getPassword());
		return utente;
	}
}
