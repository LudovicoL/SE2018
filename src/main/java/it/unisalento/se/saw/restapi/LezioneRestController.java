package it.unisalento.se.saw.restapi;

import java.text.ParseException;
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

import it.unisalento.se.saw.Iservices.IAulaService;
import it.unisalento.se.saw.Iservices.IInsegnamentoService;
import it.unisalento.se.saw.Iservices.ILezioneService;
import it.unisalento.se.saw.adapter.InsegnamentoAdapter;
import it.unisalento.se.saw.adapter.LezioneAdapter;
import it.unisalento.se.saw.domain.Aula;
import it.unisalento.se.saw.domain.Corso;
import it.unisalento.se.saw.domain.Docente;
import it.unisalento.se.saw.domain.Insegnamento;
import it.unisalento.se.saw.domain.Lezione;
import it.unisalento.se.saw.dto.InsegnamentoDTO;
import it.unisalento.se.saw.dto.LezioneDTO;
import it.unisalento.se.saw.exceptions.AulaNotFoundException;
import it.unisalento.se.saw.exceptions.CorsoNotFoundException;
import it.unisalento.se.saw.exceptions.DocenteNotFoundException;
import it.unisalento.se.saw.exceptions.InsegnamentoNotFoundException;
import it.unisalento.se.saw.exceptions.LezioneNotFoundException;

@RestController() //puoi usare i metodi taggati all'interno con l'annotazione responsebody
@RequestMapping(value="/lezione")

public class LezioneRestController {
	@Autowired
	ILezioneService lezioneService;
	@Autowired
	IAulaService aulaService;
	@Autowired
	IInsegnamentoService insegnamentoService;
		
	public LezioneRestController() {
		super();
	}
		
	public LezioneRestController(ILezioneService lezioneService) {
		this.lezioneService = lezioneService;
	}
	
	@PatchMapping(value="/update", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody Lezione lezione) throws LezioneNotFoundException {
		lezioneService.update(lezione);
	}
	
	@PostMapping(value="save", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void post(@RequestBody LezioneDTO lezioneDTO) throws InsegnamentoNotFoundException, AulaNotFoundException, ParseException {
		Lezione lezione=new Lezione();
		Aula aula=aulaService.getById(lezioneDTO.getIdAula());
		Insegnamento insegnamento=insegnamentoService.getById(lezioneDTO.getIdInsegnamento());
		lezione=LezioneAdapter.LezioneDTOToLezione(lezioneDTO, aula, insegnamento);
		lezioneService.save(lezione);
	}
}
