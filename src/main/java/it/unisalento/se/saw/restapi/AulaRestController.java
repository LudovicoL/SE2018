package it.unisalento.se.saw.restapi;

import java.util.ArrayList;
import java.util.Iterator;
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
import it.unisalento.se.saw.dto.AulaDTO;
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
	public void post(@RequestBody AulaDTO aulaDTO) throws AulaNotFoundException {
		Aula aula=new Aula();
		aula.setNome(aulaDTO.getNome());
		aula.setGrandezza(aulaDTO.getGrandezza());
		aula.setLatitudine(aulaDTO.getLatitudine());
		aula.setLongitudine(aulaDTO.getLongitudine());
		aulaService.save(aula);
	}
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<AulaDTO> getAll() throws AulaNotFoundException {
		List<AulaDTO> auleDTO=new ArrayList<AulaDTO>();
		List<Aula> aule=aulaService.getAll();
		Iterator<Aula> aulait=aule.iterator();
		while(aulait.hasNext()){
			Aula aula=aulait.next();
			AulaDTO aulaDTO=new AulaDTO();
			aulaDTO.setNome(aula.getNome());
			aulaDTO.setGrandezza(aula.getGrandezza());
			aulaDTO.setLatitudine(aula.getLatitudine());
			aulaDTO.setLongitudine(aula.getLongitudine());
			auleDTO.add(aulaDTO);
		}
		return auleDTO;
	}
	
	@RequestMapping(value="/count", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public int count() throws AulaNotFoundException{
		return aulaService.count();
	}
	
	@GetMapping(value="/getById/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public AulaDTO getById(@PathVariable("id") int id) throws AulaNotFoundException{
		AulaDTO aulaDTO=new AulaDTO();
		Aula aula=new Aula();
		aula=aulaService.getById(id);
		aulaDTO.setNome(aula.getNome());
		aulaDTO.setGrandezza(aula.getGrandezza());
		aulaDTO.setLatitudine(aula.getLatitudine());
		aulaDTO.setLongitudine(aula.getLongitudine());
		return aulaDTO;
	}	
	
	@GetMapping(value="/removeById/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public void removeById(@PathVariable("id") int id) throws AulaNotFoundException{
		aulaService.removeAulaById(id);
	}	
	
	@RequestMapping(value="/getultimaaula",  method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public int getUltimaAula() throws AulaNotFoundException {
		List<Aula> aula = null;
		aula=aulaService.getAll();
		int numero=aula.size();
		return aula.get(numero-1).getIdAula();
	}	
}
