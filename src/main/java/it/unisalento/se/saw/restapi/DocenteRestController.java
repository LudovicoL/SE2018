package it.unisalento.se.saw.restapi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.unisalento.se.saw.Iservices.ICorsoService;
import it.unisalento.se.saw.Iservices.IDocenteService;
import it.unisalento.se.saw.Iservices.IInsegnamentoService;
import it.unisalento.se.saw.Iservices.IUtenteService;
import it.unisalento.se.saw.adapter.AulaAdapter;
import it.unisalento.se.saw.adapter.DocenteAdapter;
import it.unisalento.se.saw.adapter.UtenteAdapter;
import it.unisalento.se.saw.domain.Aula;
import it.unisalento.se.saw.domain.Corso;
import it.unisalento.se.saw.domain.Docente;
import it.unisalento.se.saw.domain.Insegnamento;
import it.unisalento.se.saw.domain.Utente;
import it.unisalento.se.saw.dto.AulaDTO;
import it.unisalento.se.saw.dto.DocenteDTO;
import it.unisalento.se.saw.dto.StudenteDTO;
import it.unisalento.se.saw.exceptions.AulaNotFoundException;
import it.unisalento.se.saw.exceptions.CorsoNotFoundException;
import it.unisalento.se.saw.exceptions.DocenteNotFoundException;
import it.unisalento.se.saw.exceptions.UtenteNotFoundException;

@RestController() //puoi usare i metodi taggati all'interno con l'annotazione responsebody
@RequestMapping(value="/docente")

public class DocenteRestController {
	@Autowired
	IDocenteService docenteService;
	@Autowired
	IUtenteService utenteService;
	@Autowired
	IInsegnamentoService insegnamentoService;
	
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
	
	@PatchMapping(value="/update", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody DocenteDTO docenteDTO) {
		docenteService.update1(docenteDTO);
		docenteService.update2(docenteDTO);
	}
	
	@PatchMapping(value="/updateAbilitazione", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void updateabilitazione(@RequestBody DocenteDTO docenteDTO) {
		docenteService.updateAbilitazione(docenteDTO);
	}
	
	@GetMapping(value="/getDocenteById/{idDocente}", produces=MediaType.APPLICATION_JSON_VALUE)
	public DocenteDTO getById(@PathVariable("idDocente") int idDocente) throws AulaNotFoundException, DocenteNotFoundException, UtenteNotFoundException{
		DocenteDTO docenteDTO=new DocenteDTO();
		Docente docente=new Docente();
		docente=docenteService.getById(idDocente);
		Utente utente=new Utente();
		utente=utenteService.getById(docente.getUtente().getIdUtente());
		docenteDTO=DocenteAdapter.DocenteToDocenteDTO(docente,utente);
		return docenteDTO;
	}	
}
