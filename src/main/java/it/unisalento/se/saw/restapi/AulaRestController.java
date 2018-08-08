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
import it.unisalento.se.saw.Iservices.IAulaService;
import it.unisalento.se.saw.domain.Aula;
import it.unisalento.se.saw.domain.Studente;
import it.unisalento.se.saw.exceptions.AulaNotFoundException;

@RestController() //puoi usare i metodi taggati all'interno con l'annotazione responsebody
@RequestMapping(value="/aula")

public class AulaRestController {
	@Autowired
	IAulaService aulaService;
	
	public AulaRestController() {
		super();
	}
	
	public AulaRestController(IAulaService aulaService) {
		this.aulaService = aulaService;
	}
	
	@PostMapping(value="save", consumes=MediaType.APPLICATION_JSON_VALUE)
	public Aula post(@RequestBody Aula aula) throws AulaNotFoundException {
		return aulaService.save(aula);
	}
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Aula> getAll() throws AulaNotFoundException {
		return aulaService.getAll();
	}
	
	@RequestMapping(value="/count", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public int count() throws AulaNotFoundException{
		return aulaService.count();
	}
	
	@GetMapping(value="/getById/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Aula getById(@PathVariable("id") int id) throws AulaNotFoundException{
		return aulaService.getById(id);
	}	
	
	@GetMapping(value="/removeById/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public void removeById(@PathVariable("id") int id) throws AulaNotFoundException{
		aulaService.removeAulaById(id);
	}	
	
	@GetMapping(value="/getAulaById/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Aula removeAulaById(@PathVariable("id") int id) throws AulaNotFoundException{
		return aulaService.getAulaById(id);
	}	
	
	@RequestMapping(value="/getultimaaula",  method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public int getUltimaAula() throws AulaNotFoundException {
		List<Aula> aula = null;
		aula=aulaService.getAll();
		int numero=aula.size();
		return aula.get(numero-1).getIdAula();
	}	
}
