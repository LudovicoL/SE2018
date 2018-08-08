package it.unisalento.se.saw.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.unisalento.se.saw.Iservices.IStrumentoService;
import it.unisalento.se.saw.domain.Strumento;
import it.unisalento.se.saw.exceptions.StrumentoNotFoundException;

@RestController() //puoi usare i metodi taggati all'interno con l'annotazione responsebody
@RequestMapping(value="/strumento")

public class StrumentoRestController {
	@Autowired
	IStrumentoService strumentoService;
	
	public StrumentoRestController() {
		super();
	}
	
	public StrumentoRestController(IStrumentoService strumentoService) {
		this.strumentoService = strumentoService;
	}
	
	@PostMapping(value="save", consumes=MediaType.APPLICATION_JSON_VALUE)
	public Strumento post(@RequestBody Strumento strumento) throws StrumentoNotFoundException {
		return strumentoService.save(strumento);
	}
}
