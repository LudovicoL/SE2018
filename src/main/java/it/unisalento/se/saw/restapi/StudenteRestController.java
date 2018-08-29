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
import it.unisalento.se.saw.exceptions.CorsoNotFoundException;
import it.unisalento.se.saw.exceptions.StudenteNotFoundException;
import it.unisalento.se.saw.exceptions.UtenteNotFoundException;
import it.unisalento.se.saw.services.CorsoService;



@RestController() //puoi usare i metodi taggati all'interno con l'annotazione responsebody
@RequestMapping(value="/studente")

public class StudenteRestController {
	
	@Autowired
	IStudenteService studenteService;
	@Autowired
	IUtenteService utenteService;
	@Autowired
	CorsoService corsoService;

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
		int i;
		Utente utente=new Utente();
		for(i=0;i<stud.size();i++) {
			StudenteDTO studenteDTO= new StudenteDTO();
			studenteDTO.setMatricola(stud.get(i).getMatricola());
			studenteDTO.setIdcorso(stud.get(i).getCorso().getIdCorso());
			utente=stud.get(i).getUtente();
			studenteDTO.setName(utente.getNome());
			studenteDTO.setSurname(utente.getCognome());
			studenteDTO.setData(utente.getDatanascita().toString());
			studenteDTO.setEmail(utente.getEmail());
			studenteDTO.setIndirizzo(utente.getIndirizzo());			
			studDTO.add(i, studenteDTO);
		}
		return studDTO;
	}
	
	@GetMapping(value="/getById/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	//quello che arriva in id sopra mettilo in id sotto
	public StudenteDTO getById(@PathVariable("id") int id) throws StudenteNotFoundException, UtenteNotFoundException{
		Utente utente=new Utente();
		Studente studente;
		studente=studenteService.getById(id);
		//int idutente=studente.get(id-1).getUtenteIdUtente();
		utente=utenteService.getById(studente.getUtente().getIdUtente());
		StudenteDTO studenteDTO = new StudenteDTO();
		studenteDTO.setName(utente.getNome());
		studenteDTO.setSurname(utente.getCognome());
		return studenteDTO;
	}
	

	//se è un post si puo usare anche questo tipo di annotation al posto di requestmapping
	@PostMapping(value="save", consumes=MediaType.APPLICATION_JSON_VALUE)
	public Studente post(@RequestBody StudenteDTO studenteDTO) throws ParseException, UtenteNotFoundException, StudenteNotFoundException, CorsoNotFoundException {
		DateFormat formatter1;
		formatter1 = new SimpleDateFormat("yyyy-mm-DD");
		Utente utente=new Utente();
		Studente studente=new Studente();
		//int idutente=utenteService.count()+1;
		//System.out.println(idutente);
		utente.setNome(studenteDTO.getName());
		utente.setCognome(studenteDTO.getSurname());
		utente.setDatanascita(formatter1.parse(studenteDTO.getData()));
		utente.setEmail(studenteDTO.getEmail());
		utente.setIndirizzo(studenteDTO.getIndirizzo());
		utente.setPassword(studenteDTO.getPassword());
		studente.setMatricola(studenteDTO.getMatricola());
		studente.setCorso(corsoService.getById(studenteDTO.getIdcorso()));
		studente.setUtente(utente);
		utenteService.save(utente);
		studenteService.save(studente);	
		return null;
	}


}
