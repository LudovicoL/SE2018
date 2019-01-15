package it.unisalento.se.saw.restapi;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.unisalento.se.saw.Iservices.IDocenteService;
import it.unisalento.se.saw.Iservices.IStudenteService;
import it.unisalento.se.saw.Iservices.IUtenteService;
import it.unisalento.se.saw.adapter.DocenteAdapter;
import it.unisalento.se.saw.adapter.StudenteAdapter;
import it.unisalento.se.saw.domain.Docente;
import it.unisalento.se.saw.domain.Studente;
import it.unisalento.se.saw.domain.Utente;
import it.unisalento.se.saw.dto.DocenteDTO;
import it.unisalento.se.saw.dto.StudenteDTO;
import it.unisalento.se.saw.exceptions.DocenteNotFoundException;
import it.unisalento.se.saw.exceptions.StudenteNotFoundException;
import it.unisalento.se.saw.singleton.StudenteSingleton;


@RestController() //puoi usare i metodi taggati all'interno con l'annotazione responsebody
@RequestMapping(value="/utente")

public class UtenteRestController {

	@Autowired
	IStudenteService studenteService;
	@Autowired
	IUtenteService utenteService;
	@Autowired
	IDocenteService docenteService;
	
	@GetMapping(value="/login/{email}/{password}", produces=MediaType.APPLICATION_JSON_VALUE)
	public StudenteDTO login(@PathVariable("email") String email,@PathVariable("password") String password) throws StudenteNotFoundException{
		boolean loggato = false;
		List<Studente> studente = null;
		studente=(studenteService.getAll());
		Utente utente=new Utente();
		StudenteDTO studenteDTO= new StudenteDTO();
		Iterator<Studente> student = studente.iterator();
		while(student.hasNext()) {
			StudenteDTO studenteeDTO= new StudenteDTO();
			Studente stud=student.next();
			utente=stud.getUtente();
			studenteeDTO=StudenteAdapter.StudenteToStudenteDTO(stud, utente);
			System.out.println(studenteeDTO.getEmail()+","+studenteeDTO.getPassword());
			if(studenteeDTO.getEmail().equals(email) && studenteeDTO.getPassword().equals(password))
			{
				//classSingleton1.setStudenteDTO(studenteeDTO);
				//System.out.println(classSingleton1.getStudenteDTO());
				loggato=true;
				System.out.println(loggato);
				studenteDTO=studenteeDTO;
				break;
			}
		}	
		return studenteDTO;
	}
	
	@GetMapping(value="/loginDocente/{email}/{password}", produces=MediaType.APPLICATION_JSON_VALUE)
	public DocenteDTO loginDocente(@PathVariable("email") String email,@PathVariable("password") String password) throws DocenteNotFoundException{
		boolean loggato = false;
		List<Docente> docente = null;
		docente=(docenteService.getAll());
		Utente utente=new Utente();
		DocenteDTO docenteDTO= new DocenteDTO();
		Iterator<Docente> docent = docente.iterator();
		while(docent.hasNext()) {
			DocenteDTO docenteeDTO= new DocenteDTO();
			Docente doc=docent.next();
			utente=doc.getUtente();
			docenteeDTO=DocenteAdapter.DocenteToDocenteDTO(doc, utente);
			System.out.println(docenteeDTO.getEmail()+","+docenteeDTO.getPassword());
			if(docenteeDTO.getEmail().equals(email) && docenteeDTO.getPassword().equals(password))
			{
				//classSingleton1.setStudenteDTO(studenteeDTO);
				//System.out.println(classSingleton1.getStudenteDTO());
				loggato=true;
				System.out.println(loggato);
				docenteDTO=docenteeDTO;
				break;
			}
		}	
		return docenteDTO;
	}
}
