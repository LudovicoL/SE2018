package it.unisalento.se.saw.singleton;

import it.unisalento.se.saw.domain.Docente;
import it.unisalento.se.saw.domain.Studente;
import it.unisalento.se.saw.domain.Utente;
import it.unisalento.se.saw.dto.DocenteDTO;
import it.unisalento.se.saw.dto.SegreteriaDTO;
import it.unisalento.se.saw.dto.StudenteDTO;
import it.unisalento.se.saw.dto.UtenteDTO;

public class StudenteSingleton {
	
	private static StudenteSingleton instance = null;
	
	static StudenteDTO studenteDTO=new StudenteDTO();
	static DocenteDTO docenteDTO=new DocenteDTO();
	static SegreteriaDTO segreteriaDTO=new SegreteriaDTO();

		    
	public static StudenteSingleton getInstance() {
		if (instance == null)
			instance = new StudenteSingleton();
		return instance;
	}
	
	public static void clear()  {
		instance=null;
	}
	  
	private StudenteSingleton() {
	}

	public static StudenteDTO getStudenteDTO() {
		return studenteDTO;
	}

	public static void setStudenteDTO(StudenteDTO studenteDTO) {
		StudenteSingleton.studenteDTO = studenteDTO;
	}

	public static DocenteDTO getDocenteDTO() {
		return docenteDTO;
	}

	public static void setDocenteDTO(DocenteDTO docenteDTO) {
		StudenteSingleton.docenteDTO = docenteDTO;
	}

	public static SegreteriaDTO getSegreteriaDTO() {
		return segreteriaDTO;
	}

	public static void setSegreteriaDTO(SegreteriaDTO segreteriaDTO) {
		StudenteSingleton.segreteriaDTO = segreteriaDTO;
	}
	
}
