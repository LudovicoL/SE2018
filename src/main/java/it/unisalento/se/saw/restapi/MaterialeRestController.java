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

import it.unisalento.se.saw.Iservices.IDocenteService;
import it.unisalento.se.saw.Iservices.IInsegnamentoService;
import it.unisalento.se.saw.Iservices.ILezioneService;
import it.unisalento.se.saw.Iservices.IMaterialeService;
import it.unisalento.se.saw.adapter.LezioneAdapter;
import it.unisalento.se.saw.adapter.MaterialeAdapter;
import it.unisalento.se.saw.domain.Aula;
import it.unisalento.se.saw.domain.Docente;
import it.unisalento.se.saw.domain.Insegnamento;
import it.unisalento.se.saw.domain.Lezione;
import it.unisalento.se.saw.domain.Materiale;
import it.unisalento.se.saw.dto.LezioneDTO;
import it.unisalento.se.saw.dto.MaterialeDTO;
import it.unisalento.se.saw.exceptions.AulaNotFoundException;
import it.unisalento.se.saw.exceptions.DocenteNotFoundException;
import it.unisalento.se.saw.exceptions.InsegnamentoNotFoundException;
import it.unisalento.se.saw.exceptions.LezioneNotFoundException;
import it.unisalento.se.saw.exceptions.MaterialeNotFoundException;

@RestController() //puoi usare i metodi taggati all'interno con l'annotazione responsebody
@RequestMapping(value="/materiale")

public class MaterialeRestController {
	
	@Autowired
	IMaterialeService materialeService;
	
	@Autowired
	IDocenteService docenteService;
	
	@Autowired
	ILezioneService lezioneService;
	
	@Autowired
	IInsegnamentoService insegnamentoService;
	
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
	
	@PostMapping(value="save", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void post(@RequestBody MaterialeDTO materialeDTO) throws DocenteNotFoundException, LezioneNotFoundException {
		Docente docente=docenteService.getById(materialeDTO.getIdDocente());
		Lezione lezione=lezioneService.getById(materialeDTO.getIdLezione());
		Materiale materiale=MaterialeAdapter.MaterialeDTOToMateriale(materialeDTO,docente,lezione);
		materialeService.save(materiale);
	}
	
	@GetMapping(value="/getByIdInsegnamento/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<MaterialeDTO> getByIdInsegnamento(@PathVariable("id") int id) throws MaterialeNotFoundException, InsegnamentoNotFoundException {;
		List<MaterialeDTO> materialiDTO=new ArrayList<MaterialeDTO>();
		List<Materiale> materiali=(materialeService.getAll());
		Iterator<Materiale> material = materiali.iterator();
		while(material.hasNext()) {
			MaterialeDTO materialeDTO= new MaterialeDTO();
			Materiale materiale=material.next();
			System.out.println(materiale.getLezione().getInsegnamento().getIdInsegnamento());
			if(materiale.getLezione().getInsegnamento().getIdInsegnamento()==id) {
				materialeDTO=MaterialeAdapter.MaterialeToMaterialeDTO(materiale);
				materialiDTO.add(materialeDTO);	
			}
		}
		return materialiDTO;
	}
}
