package it.unisalento.se.saw.restapi;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.unisalento.se.saw.Iservices.IInsegnamentoService;
import it.unisalento.se.saw.domain.Insegnamento;
import it.unisalento.se.saw.exceptions.InsegnamentoNotFoundException;

@RestController() //puoi usare i metodi taggati all'interno con l'annotazione responsebody
@RequestMapping(value="/insegnamento")
public class InsegnamentoRestController {
	
	@Autowired
	IInsegnamentoService insegnamentoService;
	
	public InsegnamentoRestController() {
		super();
	}
	
	public InsegnamentoRestController(IInsegnamentoService insegnamentoService) {
		this.insegnamentoService = insegnamentoService;
	}
	
	
	@PostMapping(value="save", consumes=MediaType.APPLICATION_JSON_VALUE)
	public Insegnamento post(@RequestBody Insegnamento insegnamento) throws InsegnamentoNotFoundException {
		return insegnamentoService.save(insegnamento);
	}
}
