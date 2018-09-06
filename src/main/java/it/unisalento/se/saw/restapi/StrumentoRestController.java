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
import it.unisalento.se.saw.Iservices.IStrumentoService;
import it.unisalento.se.saw.domain.Aula;
import it.unisalento.se.saw.domain.Strumento;
import it.unisalento.se.saw.dto.AulaDTO;
import it.unisalento.se.saw.dto.StrumentoDTO;
import it.unisalento.se.saw.exceptions.AulaNotFoundException;
import it.unisalento.se.saw.exceptions.StrumentoNotFoundException;
import it.unisalento.se.saw.services.AulaService;

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
		strumento.setNome(strumentoDTO.getNome());
		Aula aula=aulaService.getById(strumentoDTO.getIdAula());
		strumento.setAgibile(strumentoDTO.getAgibile());
		strumento.setAula(aula);
		strumentoService.save(strumento);
	}
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<StrumentoDTO> getAll() throws StrumentoNotFoundException {
		List<StrumentoDTO> strumentiDTO=new ArrayList<StrumentoDTO>();
		List<Strumento> strumenti=strumentoService.getAll();
		Iterator<Strumento> strumentoit=strumenti.iterator();
		while(strumentoit.hasNext()){
			Strumento strumento=strumentoit.next();
			StrumentoDTO strumentoDTO=new StrumentoDTO();
			strumentoDTO.setNome(strumento.getNome());
			strumentoDTO.setAgibile(strumento.getAgibile());
			strumentiDTO.add(strumentoDTO);
		}
		return strumentiDTO;
	}
	
	@GetMapping(value="/getById/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public StrumentoDTO getById(@PathVariable("id") int id) throws StrumentoNotFoundException{
		StrumentoDTO strumentoDTO=new StrumentoDTO();
		Strumento strumento=new Strumento();
		strumento=strumentoService.getById(id);
		strumentoDTO.setNome(strumento.getNome());
		strumentoDTO.setAgibile(strumento.getAgibile());
		return strumentoDTO;
	}	
}
