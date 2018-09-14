package it.unisalento.se.saw.restapi;

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

import it.unisalento.se.saw.Iservices.IEsameService;
import it.unisalento.se.saw.domain.Esame;
import it.unisalento.se.saw.exceptions.EsameNotFoundException;

@RestController() //puoi usare i metodi taggati all'interno con l'annotazione responsebody
@RequestMapping(value="/esame")

public class EsameRestController {
	
	@Autowired
	IEsameService esameService;
		
	public EsameRestController() {
		super();
	}
		
	public EsameRestController(IEsameService esameService) {
		this.esameService = esameService;
	}

	@PatchMapping(value="/update", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody Esame esame) throws EsameNotFoundException {
		esameService.update(esame);
	}
}
