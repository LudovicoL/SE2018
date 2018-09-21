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
import it.unisalento.se.saw.Iservices.IAulaService;
import it.unisalento.se.saw.Iservices.IStrumentoService;
import it.unisalento.se.saw.adapter.StrumentoAdapter;
import it.unisalento.se.saw.domain.Aula;
import it.unisalento.se.saw.domain.Strumento;
import it.unisalento.se.saw.dto.StrumentoDTO;
import it.unisalento.se.saw.exceptions.AulaNotFoundException;
import it.unisalento.se.saw.exceptions.StrumentoNotFoundException;
import it.unisalento.se.saw.repositories.AulaRepository;

@RestController() //puoi usare i metodi taggati all'interno con l'annotazione responsebody
@RequestMapping(value="/strumento")

public class StrumentoRestController {
	@Autowired
	IStrumentoService strumentoService;
	@Autowired
	IAulaService aulaService;
	
	public StrumentoRestController() {
		super();
	}
	
	public StrumentoRestController(IStrumentoService strumentoService) {
		this.strumentoService = strumentoService;
	}
	
	@PostMapping(value="save", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void post(@RequestBody StrumentoDTO strumentoDTO) throws StrumentoNotFoundException, AulaNotFoundException {
		Strumento strumento=new Strumento();
		Aula aula=aulaService.getById(strumentoDTO.getIdAula());
		strumento=StrumentoAdapter.StrumentoDTOToStrumento(strumentoDTO, aula);
		strumentoService.save(strumento);
	}
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<StrumentoDTO> getAll() throws StrumentoNotFoundException, AulaNotFoundException {
		List<StrumentoDTO> strumentiDTO=new ArrayList<StrumentoDTO>();
		List<Strumento> strumenti=strumentoService.getAll();
		Iterator<Strumento> strumentoit=strumenti.iterator();
		while(strumentoit.hasNext()){
			Strumento strumento=strumentoit.next();
			StrumentoDTO strumentoDTO=new StrumentoDTO();
			strumentoDTO=StrumentoAdapter.StrumentoToStrumentoDTO(strumento);
			strumentoDTO.setNomeaula(aulaService.getById(strumentoDTO.getIdAula()).getNome());
			strumentiDTO.add(strumentoDTO);
		}
		return strumentiDTO;
	}
	
	@GetMapping(value="/getById/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public StrumentoDTO getById(@PathVariable("id") int id) throws StrumentoNotFoundException{
		StrumentoDTO strumentoDTO=new StrumentoDTO();
		Strumento strumento=new Strumento();
		strumento=strumentoService.getById(id);
		strumentoDTO=StrumentoAdapter.StrumentoToStrumentoDTO(strumento);
		return strumentoDTO;
	}
	
	@PatchMapping(value="/update", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody StrumentoDTO strumentoDTO){
		//Aula aula=aulaService.getById(strumentoDTO.getIdAula());
		//Strumento strumento=StrumentoAdapter.StrumentoDTOToStrumento(strumentoDTO, aula);
		strumentoService.update(strumentoDTO);
	}
	
	@RequestMapping(value="/delete/{idStrumento}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("idStrumento") int idStrumento) {
		System.out.println(idStrumento);
		strumentoService.delete(idStrumento);
	}
	
}
