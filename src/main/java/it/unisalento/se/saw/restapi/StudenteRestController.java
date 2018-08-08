package it.unisalento.se.saw.restapi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.unisalento.se.saw.Iservices.IStudenteService;
import it.unisalento.se.saw.Iservices.IUtenteService;
import it.unisalento.se.saw.domain.Studente;
import it.unisalento.se.saw.domain.Utente;
import it.unisalento.se.saw.dto.StudenteDTO;
import it.unisalento.se.saw.dto.UtenteDTO;
import it.unisalento.se.saw.exceptions.StudenteNotFoundException;
import it.unisalento.se.saw.exceptions.UtenteNotFoundException;



@RestController() //puoi usare i metodi taggati all'interno con l'annotazione responsebody
@RequestMapping(value="/studente")

public class StudenteRestController {
	
	@Autowired
	IStudenteService studenteService;
	@Autowired
	IUtenteService utenteService;
	
	public StudenteRestController() {
		super();
	}
	
	public StudenteRestController(IStudenteService studenteService) {
		this.studenteService = studenteService;
	}
	

	@RequestMapping(value="/getAll", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<StudenteDTO> getAll() throws StudenteNotFoundException, UtenteNotFoundException{;
		List<Studente> stud = null;
		List<StudenteDTO> studDTO=new ArrayList<StudenteDTO>();
		stud=(studenteService.getAll());
		int idutente;
		int i;
		Utente utente=new Utente();
		System.out.println(stud.get(0).getMatricola());
		for(i=0;i<stud.size();i++) {
			StudenteDTO studenteDTO= new StudenteDTO();
			idutente=stud.get(i).getUtenteIdUtente();
			utente=utenteService.getById(idutente);
			studenteDTO.setName(utente.getNome());
			studenteDTO.setSurname(utente.getCognome());
			studenteDTO.setData(utente.getDatanascita().toString());
			studenteDTO.setEmail(utente.getEmail());
			studenteDTO.setMatricola(stud.get(i).getMatricola());
			studenteDTO.setIdcorso(stud.get(i).getCorsoIdCorso());
			studenteDTO.setIndirizzo(utente.getIndirizzo());
			studDTO.add(i, studenteDTO);
		}
		return studDTO;
	}
	
	@GetMapping(value="/getById/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	//quello che arriva in id sopra mettilo in id sotto
	public StudenteDTO getById(@PathVariable("id") int id) throws StudenteNotFoundException, UtenteNotFoundException{
		Utente utente=new Utente();
		List<Studente> studente;
		studente=studenteService.getAll();
		int idutente=studente.get(id-1).getUtenteIdUtente();
		utente=utenteService.getById(idutente);
		StudenteDTO studenteDTO = new StudenteDTO();
		studenteDTO.setName(utente.getNome());
		studenteDTO.setSurname(utente.getCognome());
		return studenteDTO;
	}
	

	//se è un post si puo usare anche questo tipo di annotation al posto di requestmapping
	@PostMapping(value="save", consumes=MediaType.APPLICATION_JSON_VALUE)
	public Studente post(@RequestBody StudenteDTO studenteDTO) throws ParseException, UtenteNotFoundException, StudenteNotFoundException {
		DateFormat formatter1;
		formatter1 = new SimpleDateFormat("yyyy-mm-DD");
		Studente studente=new Studente();
		int idutente=utenteService.count()+1;
		System.out.println(idutente);
		Utente utente=new Utente();
		utente.setNome(studenteDTO.getName());
		utente.setCognome(studenteDTO.getSurname());
		utente.setDatanascita(formatter1.parse(studenteDTO.getData()));
		utente.setEmail(studenteDTO.getEmail());
		utente.setIndirizzo(studenteDTO.getIndirizzo());
		utente.setPassword(studenteDTO.getPassword());
		studente.setMatricola(studenteDTO.getMatricola());
		studente.setCorsoIdCorso(studenteDTO.getIdcorso());
		studente.setUtenteIdUtente(idutente);
		utenteService.save(utente);
		studenteService.save(studente);	
		return null;
	}

}
