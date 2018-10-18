package it.unisalento.se.saw.restapi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
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
import it.unisalento.se.saw.Iservices.IDocenteService;
import it.unisalento.se.saw.Iservices.IInsegnamentoService;
import it.unisalento.se.saw.Iservices.ILezioneService;
import it.unisalento.se.saw.adapter.AulaAdapter;
import it.unisalento.se.saw.adapter.LezioneAdapter;
import it.unisalento.se.saw.domain.Aula;
import it.unisalento.se.saw.domain.Docente;
import it.unisalento.se.saw.domain.Insegnamento;
import it.unisalento.se.saw.domain.Lezione;
import it.unisalento.se.saw.dto.AulaDTO;
import it.unisalento.se.saw.dto.LezioneDTO;
import it.unisalento.se.saw.exceptions.AulaNotFoundException;
import it.unisalento.se.saw.exceptions.DocenteNotFoundException;
import it.unisalento.se.saw.exceptions.InsegnamentoNotFoundException;
import it.unisalento.se.saw.exceptions.LezioneNotFoundException;

@RestController() //puoi usare i metodi taggati all'interno con l'annotazione responsebody
@RequestMapping(value="/lezione")

public class LezioneRestController {
	@Autowired
	ILezioneService lezioneService;
	@Autowired
	IAulaService aulaService;
	@Autowired
	IInsegnamentoService insegnamentoService;
	@Autowired
	IDocenteService docenteService;
		
	public LezioneRestController() {
		super();
	}
		
	public LezioneRestController(ILezioneService lezioneService) {
		this.lezioneService = lezioneService;
	}
	
	@PatchMapping(value="/update", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody Lezione lezione) throws LezioneNotFoundException {
		lezioneService.update(lezione);
	}
	
	@PostMapping(value="save", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void post(@RequestBody LezioneDTO lezioneDTO) throws InsegnamentoNotFoundException, AulaNotFoundException, ParseException {
		Lezione lezione=new Lezione();
		Aula aula=aulaService.getById(lezioneDTO.getIdAula());
		Insegnamento insegnamento=insegnamentoService.getById(lezioneDTO.getIdInsegnamento());
		lezione=LezioneAdapter.LezioneDTOToLezione(lezioneDTO, aula, insegnamento);
		lezioneService.save(lezione);
	}
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<LezioneDTO> getAll() throws LezioneNotFoundException {;
		List<Lezione> lezioni = null;
		List<LezioneDTO> lezioniDTO=new ArrayList<LezioneDTO>();
		lezioni=(lezioneService.getAll());
		Iterator<Lezione> lezion = lezioni.iterator();
		while(lezion.hasNext()) {
			LezioneDTO lezioneDTO= new LezioneDTO();
			Lezione lezione=lezion.next();
			lezioneDTO=LezioneAdapter.LezioneToLezioneDTO(lezione);
			lezioniDTO.add(lezioneDTO);	
		}
		return lezioniDTO;
	}
	
	@GetMapping(value="/getLezioneByIdInsegnamento/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	//quello che arriva in id sopra mettilo in id sotto
	public List<LezioneDTO> getById(@PathVariable("id") int id) throws LezioneNotFoundException, ParseException {
		List<Lezione> lezioni = null;
		List<LezioneDTO> lezioniDTO=new ArrayList<LezioneDTO>();
		lezioni=(lezioneService.getAll());
		Iterator<Lezione> lezion = lezioni.iterator();
		while(lezion.hasNext()) {
			LezioneDTO lezioneDTO= new LezioneDTO();
			Lezione lezione=lezion.next();
			if(lezione.getInsegnamento().getIdInsegnamento()==id) {
				lezioneDTO=LezioneAdapter.LezioneToLezioneDTO(lezione);
				lezioniDTO.add(lezioneDTO);	
			}
		}
		return lezioniDTO;
	}
	
	@GetMapping(value="/lezioneesistente/{datainizio}/{datafine}/{idInsegnamento}", produces=MediaType.APPLICATION_JSON_VALUE)
	public int lezioneEsistente(@PathVariable("datainizio") Date datainizio,@PathVariable("datafine") Date datafine,@PathVariable("idInsegnamento") int idInsegnamento) throws ParseException{
		//DateFormat formatter1;
		//Date data1,data2;
		//formatter1 = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		//data1=formatter1.parse(datainizio);
		//data2=formatter1.parse(datafine);
		return lezioneService.lezioneEsistente(datainizio, datafine, idInsegnamento);
	}
	
	@GetMapping(value="/lezionedocente/{datainizio}/{datafine}/{idDocente}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<LezioneDTO> lezioneDocente(@PathVariable("datainizio") Date datainizio,@PathVariable("datafine") Date datafine,@PathVariable("idDocente") int idDocente) throws ParseException, DocenteNotFoundException{
		Docente docente=new Docente();
		docente=docenteService.getById(idDocente);		
		List<Lezione> lezioni = null;
		List<LezioneDTO> lezioniDTO=new ArrayList<LezioneDTO>();
		//DateFormat formatter1;
		//Date data1,data2;
		//formatter1 = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		//data1=formatter1.parse(datainizio);
		//data1.setMonth(data1.getMonth()+1);
		//data2=formatter1.parse(datafine);
		//data2.setMonth(data2.getMonth()+1);
		lezioni=(lezioneService.lezioneDocente(datainizio,datafine,docente));
		Iterator<Lezione> lezion = lezioni.iterator();
		while(lezion.hasNext()) {
			LezioneDTO lezioneDTO= new LezioneDTO();
			Lezione lezione=lezion.next();
			lezioneDTO=LezioneAdapter.LezioneToLezioneDTO(lezione);
			lezioneDTO.setNomeInsegnamento(lezione.getInsegnamento().getNome());
			lezioneDTO.setNomeaula(lezione.getAula().getNome());
			lezioniDTO.add(lezioneDTO);	
			System.out.println(lezioneDTO.getDatainizio());
		}
		return lezioniDTO;
	}	
}
