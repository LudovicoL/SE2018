package it.unisalento.se.saw.restapi;

import java.text.ParseException;
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

import it.unisalento.se.saw.Iservices.IGradimentoService;
import it.unisalento.se.saw.Iservices.IMaterialeService;
import it.unisalento.se.saw.Iservices.IStudenteService;
import it.unisalento.se.saw.adapter.GradimentoAdapter;
import it.unisalento.se.saw.adapter.InsegnamentoAdapter;
import it.unisalento.se.saw.adapter.StudenteAdapter;
import it.unisalento.se.saw.adapter.UtenteAdapter;
import it.unisalento.se.saw.domain.Corso;
import it.unisalento.se.saw.domain.Gradimento;
import it.unisalento.se.saw.domain.Insegnamento;
import it.unisalento.se.saw.domain.Materiale;
import it.unisalento.se.saw.domain.Studente;
import it.unisalento.se.saw.domain.Utente;
import it.unisalento.se.saw.dto.GradimentoDTO;
import it.unisalento.se.saw.dto.InsegnamentoDTO;
import it.unisalento.se.saw.dto.StudenteDTO;
import it.unisalento.se.saw.exceptions.CorsoNotFoundException;
import it.unisalento.se.saw.exceptions.GradimentoNotFoundException;
import it.unisalento.se.saw.exceptions.MaterialeNotFoundException;
import it.unisalento.se.saw.exceptions.StudenteNotFoundException;
import it.unisalento.se.saw.exceptions.UtenteNotFoundException;

@RestController() //puoi usare i metodi taggati all'interno con l'annotazione responsebody
@RequestMapping(value="/gradimento")

public class GradimentoRestController {
	
	@Autowired
	IGradimentoService gradimentoService;
	
	@Autowired
	IMaterialeService materialeService;
	
	@Autowired
	IStudenteService studenteService;
	
	public GradimentoRestController() {
		super();
	}
	
	public GradimentoRestController(IGradimentoService gradimentoService) {
		this.gradimentoService = gradimentoService;
	}
	
	@PostMapping(value="saveMateriale", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void post(@RequestBody GradimentoDTO gradimentoDTO) throws MaterialeNotFoundException, StudenteNotFoundException  {
		System.out.println(gradimentoDTO);
		Gradimento gradimento=new Gradimento();
		Materiale materiale=new Materiale();
		Studente studente=new Studente();
		materiale=materialeService.getById(gradimentoDTO.getIdMateriale());
		studente=studenteService.getById(gradimentoDTO.getIdStudente());
		gradimento=GradimentoAdapter.GradimentoDTOToGradimento(gradimentoDTO, studente, null, materiale);
		gradimentoService.save(gradimento);
	}
	
	@GetMapping(value="/getGiaVotato/{idMateriale}/{idStudente}", produces=MediaType.APPLICATION_JSON_VALUE)
	//quello che arriva in id sopra mettilo in id sotto
	public Integer getGiaVotato(@PathVariable("idMateriale") int idMateriale,@PathVariable("idStudente") int idStudente) throws StudenteNotFoundException, MaterialeNotFoundException {
		Studente studente=studenteService.getById(idStudente);
		Materiale materiale =materialeService.getById(idMateriale);
		return gradimentoService.getGiaVotato(studente, materiale);		
	}
	

}
