package it.unisalento.se.saw.restapi;

import java.util.ArrayList;
import java.util.Collections;
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

import it.unisalento.se.saw.Iservices.IAulaService;
import it.unisalento.se.saw.Iservices.IDocenteService;
import it.unisalento.se.saw.Iservices.ISegnalazioneService;
import it.unisalento.se.saw.Iservices.IStrumentoService;
import it.unisalento.se.saw.adapter.AulaAdapter;
import it.unisalento.se.saw.adapter.SegnalazioneAdapter;
import it.unisalento.se.saw.domain.Aula;
import it.unisalento.se.saw.domain.Docente;
import it.unisalento.se.saw.domain.Segnalazione;
import it.unisalento.se.saw.domain.Strumento;
import it.unisalento.se.saw.dto.AulaDTO;
import it.unisalento.se.saw.dto.SegnalazioneDTO;
import it.unisalento.se.saw.exceptions.AulaNotFoundException;
import it.unisalento.se.saw.exceptions.DocenteNotFoundException;
import it.unisalento.se.saw.exceptions.SegnalazioneNotFoundException;
import it.unisalento.se.saw.exceptions.StrumentoNotFoundException;
import it.unisalento.se.saw.repositories.AulaRepository;
import it.unisalento.se.saw.services.AulaService;

@RestController() //puoi usare i metodi taggati all'interno con l'annotazione responsebody
@RequestMapping(value="/segnalazione")

public class SegnalazioneRestController {
	
	@Autowired
	ISegnalazioneService segnalazioneService;
	
	@Autowired
	IAulaService aulaService;
	
	@Autowired
	IDocenteService docenteService;
	
	@Autowired
	IStrumentoService strumentoService;
	
	public SegnalazioneRestController() {
		super();
	}
	
	public SegnalazioneRestController(ISegnalazioneService segnalazioneService) {
		this.segnalazioneService = segnalazioneService;
	}
	
	@PatchMapping(value="/update", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody SegnalazioneDTO segnalazioneDTO){
		segnalazioneService.update(segnalazioneDTO);
	}
	
	@RequestMapping(value="/delete/{idSegnalazione}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("idSegnalazione") int idSegnalazione) {
		segnalazioneService.delete(idSegnalazione);
	}
	
	@PostMapping(value="save", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void post(@RequestBody SegnalazioneDTO segnalazioneDTO) throws AulaNotFoundException, DocenteNotFoundException {
		Segnalazione segnalazione=new Segnalazione();
		Aula aula=aulaService.getById(segnalazioneDTO.getIdAula()); 
		Docente docente=docenteService.getById(segnalazioneDTO.getIdDocente());
		segnalazione=SegnalazioneAdapter.SegnalazioneDTOToSegnalazione(segnalazioneDTO,docente,aula);
		segnalazioneService.save(segnalazione);
	}
	
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<SegnalazioneDTO> getAll() throws AulaNotFoundException, SegnalazioneNotFoundException, DocenteNotFoundException, StrumentoNotFoundException {
		List<SegnalazioneDTO> segnalazioniDTO=new ArrayList<SegnalazioneDTO>();
		List<Segnalazione> segnalazioni=segnalazioneService.getAll();
		Iterator<Segnalazione> segnalazioneit=segnalazioni.iterator();
		while(segnalazioneit.hasNext()){
			Segnalazione segnalazione=segnalazioneit.next();
			SegnalazioneDTO segnalazioneDTO=new SegnalazioneDTO();
			segnalazioneDTO=SegnalazioneAdapter.SegnalazioneToSegnalazioneDTO(segnalazione);
			segnalazioniDTO.add(segnalazioneDTO);
		}
		return segnalazioniDTO;
	}

}
