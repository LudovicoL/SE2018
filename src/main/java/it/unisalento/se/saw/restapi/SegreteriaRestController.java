package it.unisalento.se.saw.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.unisalento.se.saw.Iservices.ISegreteriaService;
import it.unisalento.se.saw.domain.Segreteria;
import it.unisalento.se.saw.exceptions.SegreteriaNotFoundException;

@RestController() //puoi usare i metodi taggati all'interno con l'annotazione responsebody
@RequestMapping(value="/segreteria")

public class SegreteriaRestController {
	
	@Autowired
	ISegreteriaService segreteriaService;
	
	public SegreteriaRestController() {
		super();
	}
	
	public SegreteriaRestController(ISegreteriaService segreteriaService) {
		this.segreteriaService = segreteriaService;
	}
	
	@PostMapping(value="save", consumes=MediaType.APPLICATION_JSON_VALUE)
	public Segreteria post(@RequestBody Segreteria segreteria) throws SegreteriaNotFoundException {
		return segreteriaService.save(segreteria);
	}
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Segreteria> getAll() throws SegreteriaNotFoundException {
		return segreteriaService.getAll();
	}
	
	@RequestMapping(value="/count", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public int count() throws SegreteriaNotFoundException{

		return segreteriaService.count();
	}
	
	@GetMapping(value="/getById/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Segreteria getById(@PathVariable("id") int id) throws SegreteriaNotFoundException{
		return segreteriaService.getById(id);
	}	
	

	

}

