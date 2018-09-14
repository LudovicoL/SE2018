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
import it.unisalento.se.saw.Iservices.IMaterialeService;
import it.unisalento.se.saw.adapter.MaterialeAdapter;
import it.unisalento.se.saw.domain.Materiale;
import it.unisalento.se.saw.dto.MaterialeDTO;
import it.unisalento.se.saw.exceptions.MaterialeNotFoundException;

@RestController() //puoi usare i metodi taggati all'interno con l'annotazione responsebody
@RequestMapping(value="/materiale")

public class MaterialeRestController {
	
	@Autowired
	IMaterialeService materialeService;
	
	public MaterialeRestController() {
		super();
	}
	
	public MaterialeRestController(IMaterialeService materialeService) {
		this.materialeService = materialeService;
	}

	@PatchMapping(value="/update", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody Materiale materiale) throws MaterialeNotFoundException {
		materialeService.update(materiale);
	}
}
