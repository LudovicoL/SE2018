package it.unisalento.se.saw.restapi;

import java.util.List;
import java.util.Optional;

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
import it.unisalento.se.saw.domain.Corso;
import it.unisalento.se.saw.dto.CorsoDTO;
import it.unisalento.se.saw.dto.StudenteDTO;
import it.unisalento.se.saw.exceptions.CorsoNotFoundException;

@RestController() //puoi usare i metodi taggati all'interno con l'annotazione responsebody
@RequestMapping(value="/corso")

public class CorsoRestController {
	
	@Autowired
	ICorsoService corsoService;
	
	public CorsoRestController() {
		super();
	}
	
	public CorsoRestController(ICorsoService corsoService) {
		this.corsoService = corsoService;
	}
	
	@PostMapping(value="save", consumes=MediaType.APPLICATION_JSON_VALUE)
	public Corso post(@RequestBody Corso corso) throws CorsoNotFoundException {
		return corsoService.save(corso);
	}
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Corso> getAll() {
		return corsoService.getAll();
	}
	
	@RequestMapping(value="/count", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public int count() throws CorsoNotFoundException{

		return corsoService.count();
	}
	
	@GetMapping(value="/getById/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public CorsoDTO getById(@PathVariable("id") int id) throws CorsoNotFoundException{
		CorsoDTO corsoDto = new CorsoDTO();;
		corsoDto.setNome(corsoService.getById(id).getNome());
		corsoDto.setFacolta(corsoService.getById(id).getFacolta());
		corsoDto.setDurata(corsoService.getById(id).getDurata());
		corsoDto.setLivello(corsoService.getById(id).getLivello());
		return corsoDto;
	}	
	
	@PatchMapping(value="/update", consumes=MediaType.APPLICATION_JSON_VALUE)
	public Corso update(@RequestBody Corso corso) throws CorsoNotFoundException {
		return corsoService.update(corso);
	}
	

}
