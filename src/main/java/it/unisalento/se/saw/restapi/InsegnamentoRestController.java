package it.unisalento.se.saw.restapi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.unisalento.se.saw.Iservices.ICorsoService;
import it.unisalento.se.saw.Iservices.IDocenteService;
import it.unisalento.se.saw.Iservices.IInsegnamentoService;
import it.unisalento.se.saw.adapter.InsegnamentoAdapter;
import it.unisalento.se.saw.adapter.StudenteAdapter;
import it.unisalento.se.saw.domain.Corso;
import it.unisalento.se.saw.domain.Docente;
import it.unisalento.se.saw.domain.Insegnamento;
import it.unisalento.se.saw.domain.Studente;
import it.unisalento.se.saw.domain.Utente;
import it.unisalento.se.saw.dto.InsegnamentoDTO;
import it.unisalento.se.saw.dto.StudenteDTO;
import it.unisalento.se.saw.exceptions.CorsoNotFoundException;
import it.unisalento.se.saw.exceptions.DocenteNotFoundException;
import it.unisalento.se.saw.exceptions.InsegnamentoNotFoundException;
import it.unisalento.se.saw.exceptions.StudenteNotFoundException;
import it.unisalento.se.saw.exceptions.UtenteNotFoundException;
import it.unisalento.se.saw.repositories.CorsoRepository;
import it.unisalento.se.saw.services.CorsoService;

@RestController() //puoi usare i metodi taggati all'interno con l'annotazione responsebody
@RequestMapping(value="/insegnamento")
public class InsegnamentoRestController {
	
	@Autowired
	IInsegnamentoService insegnamentoService;
	@Autowired
	ICorsoService corsoService;
	@Autowired
	IDocenteService docenteService;
	
	public InsegnamentoRestController() {
		super();
	}
	
	public InsegnamentoRestController(IInsegnamentoService insegnamentoService) {
		this.insegnamentoService = insegnamentoService;
	}
	
	
	@PostMapping(value="save", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void post(@RequestBody InsegnamentoDTO insegnamentoDTO) throws InsegnamentoNotFoundException, CorsoNotFoundException, DocenteNotFoundException {
		Insegnamento insegnamento=new Insegnamento();
		Corso corso=corsoService.getById(insegnamentoDTO.getIdCorso());
		Docente docente=docenteService.getById(insegnamentoDTO.getIdDocente());
		insegnamento=InsegnamentoAdapter.InsegnamentoDTOToInsegnamento(insegnamentoDTO, corso, docente);
		insegnamentoService.save(insegnamento);
	}
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<InsegnamentoDTO> getAll() throws InsegnamentoNotFoundException {;
		List<Insegnamento> insegnamento = null;
		List<InsegnamentoDTO> insDTO=new ArrayList<InsegnamentoDTO>();
		insegnamento=(insegnamentoService.getAll());
		Iterator<Insegnamento> insegnament = insegnamento.iterator();
		while(insegnament.hasNext()) {
			InsegnamentoDTO insegnamentoDTO= new InsegnamentoDTO();
			Insegnamento insegn=insegnament.next();
			insegnamentoDTO=InsegnamentoAdapter.InsegnamentoToInsegnamentoDTO(insegn);
			insDTO.add(insegnamentoDTO);	
		}
		return insDTO;
	}
	
	@PatchMapping(value="/update", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody InsegnamentoDTO insegnamentoDTO) {
		insegnamentoService.update(insegnamentoDTO);
	}
	@PatchMapping(value="/updateabilitazione", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void updateabilitazione(@RequestBody InsegnamentoDTO insegnamentoDTO) {
		insegnamentoService.updateAbilitazione(insegnamentoDTO);
	}
}
