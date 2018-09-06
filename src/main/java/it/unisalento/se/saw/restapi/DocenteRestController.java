package it.unisalento.se.saw.restapi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
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
import it.unisalento.se.saw.adapter.DocenteAdapter;
import it.unisalento.se.saw.adapter.UtenteAdapter;
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
		List<Docente> docente = null;
		List<DocenteDTO> docDTO=new ArrayList<DocenteDTO>();
		docente=(docenteService.getAll());
		Utente utente=new Utente();
		Iterator<Docente> docent = docente.iterator();
		while(docent.hasNext()) {
			DocenteDTO docenteDTO= new DocenteDTO();
			Docente doc=docent.next();
			utente=doc.getUtente();
			utente=utenteService.getById(utente.getIdUtente());
			docenteDTO=DocenteAdapter.DocenteToDocenteDTO(doc, utente);
			docDTO.add(docenteDTO);
		}
		return docDTO;
	}
		

	//se è un post si puo usare anche questo tipo di annotation al posto di requestmapping
	@PostMapping(value="save", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void post(@RequestBody DocenteDTO docenteDTO) throws ParseException, UtenteNotFoundException {
		Docente docente=new Docente();
		Utente utente=new Utente();
		utente=UtenteAdapter.DocenteDTOToUtente(docenteDTO);
		utenteService.save(utente);
		docente=DocenteAdapter.DocenteDTOToDocente(docenteDTO, utente);
		docenteService.save(docente);
	}
}
