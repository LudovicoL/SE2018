package it.unisalento.se.saw.restapi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import it.unisalento.se.saw.Iservices.IDocenteService;
import it.unisalento.se.saw.Iservices.IUtenteService;
import it.unisalento.se.saw.domain.Docente;
import it.unisalento.se.saw.domain.Utente;
import it.unisalento.se.saw.dto.DocenteDTO;
import it.unisalento.se.saw.exceptions.DocenteNotFoundException;
import it.unisalento.se.saw.exceptions.UtenteNotFoundException;

@RestController() //puoi usare i metodi taggati all'interno con l'annotazione responsebody
@RequestMapping(value="/docente")

public class DocenteRestController {
	@Autowired
	IDocenteService docenteService;
	@Autowired
	IUtenteService utenteService;
	
	public DocenteRestController() {
		super();
	}
	
	public DocenteRestController(IDocenteService docenteService) {
		this.docenteService = docenteService;
	}
	
	

	@RequestMapping(value="/getAll", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<DocenteDTO> getAll() throws DocenteNotFoundException, UtenteNotFoundException{;
		List<Docente> doc = null;
		List<DocenteDTO> docDTO=new ArrayList<DocenteDTO>();
		doc=(docenteService.getAll());

		int i;
		Utente utente=new Utente();
		for(i=0;i<doc.size();i++) {
			DocenteDTO docenteDTO= new DocenteDTO();
			utente=doc.get(i).getUtente();
			utente=utenteService.getById(utente.getIdUtente());
			docenteDTO.setName(utente.getNome());
			docenteDTO.setSurname(utente.getCognome());
			docenteDTO.setData(utente.getDatanascita().toString());
			docenteDTO.setEmail(utente.getEmail());
			docenteDTO.setStipendio(doc.get(i).getStipendio());
			docenteDTO.setIndirizzo(utente.getIndirizzo());
			docDTO.add(i, docenteDTO);
		}
		return docDTO;
	}
		

	//se è un post si puo usare anche questo tipo di annotation al posto di requestmapping
	@PostMapping(value="save", consumes=MediaType.APPLICATION_JSON_VALUE)
	public Docente post(@RequestBody DocenteDTO docenteDTO) throws ParseException, UtenteNotFoundException {
		DateFormat formatter1;
		formatter1 = new SimpleDateFormat("yyyy-mm-DD");
		Docente docente=new Docente();
		int idutente=utenteService.count()+1;
		System.out.println(idutente);
		Utente utente=new Utente();
		utente.setNome(docenteDTO.getName());
		utente.setCognome(docenteDTO.getSurname());
		utente.setDatanascita(formatter1.parse(docenteDTO.getData()));
		utente.setEmail(docenteDTO.getEmail());
		utente.setIndirizzo(docenteDTO.getIndirizzo());
		utente.setPassword(docenteDTO.getPassword());
		utenteService.save(utente);
		docente.setStipendio(docenteDTO.getStipendio());
		docente.setUtenteIdUtente(idutente);
		docenteService.save(docente);
		return null;
	}
}
