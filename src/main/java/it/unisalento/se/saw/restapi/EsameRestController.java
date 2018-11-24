package it.unisalento.se.saw.restapi;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
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
import it.unisalento.se.saw.Iservices.IEsameService;
import it.unisalento.se.saw.Iservices.IInsegnamentoService;
import it.unisalento.se.saw.adapter.EsameAdapter;
import it.unisalento.se.saw.adapter.InsegnamentoAdapter;
import it.unisalento.se.saw.domain.Aula;
import it.unisalento.se.saw.domain.Corso;
import it.unisalento.se.saw.domain.Docente;
import it.unisalento.se.saw.domain.Esame;
import it.unisalento.se.saw.domain.Insegnamento;
import it.unisalento.se.saw.domain.Esame;
import it.unisalento.se.saw.dto.EsameDTO;
import it.unisalento.se.saw.dto.InsegnamentoDTO;
import it.unisalento.se.saw.exceptions.AulaNotFoundException;
import it.unisalento.se.saw.exceptions.CorsoNotFoundException;
import it.unisalento.se.saw.exceptions.DocenteNotFoundException;
import it.unisalento.se.saw.exceptions.EsameNotFoundException;
import it.unisalento.se.saw.exceptions.InsegnamentoNotFoundException;
import it.unisalento.se.saw.services.EsameService;
import it.unisalento.se.saw.exceptions.EsameNotFoundException;

@RestController() //puoi usare i metodi taggati all'interno con l'annotazione responsebody
@RequestMapping(value="/esame")

public class EsameRestController {
	
	@Autowired
	IEsameService esameService;
	@Autowired
	IAulaService aulaService;
	@Autowired
	IInsegnamentoService insegnamentoService;
	@Autowired
	IDocenteService docenteService;	
	public EsameRestController() {
		super();
	}
		
	public EsameRestController(IEsameService esameService) {
		this.esameService = esameService;
	}

	@PatchMapping(value="/update", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody Esame esame) throws EsameNotFoundException {
		esameService.update(esame);
	}
	
	
	
	@PostMapping(value="save", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void post(@RequestBody EsameDTO esameDTO) throws InsegnamentoNotFoundException, AulaNotFoundException, ParseException {
		Esame esame=new Esame();
		Aula aula=aulaService.getById(esameDTO.getIdAula());
		Insegnamento insegnamento=insegnamentoService.getById(esameDTO.getIdInsegnamento());
		esame=EsameAdapter.EsameDTOToEsame(esameDTO, aula, insegnamento);
		esameService.save(esame);
	}
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<EsameDTO> getAll() throws EsameNotFoundException {;
		List<Esame> esami = null;
		List<EsameDTO> esamiDTO=new ArrayList<EsameDTO>();
		esami=(esameService.getAll());
		Iterator<Esame> esam = esami.iterator();
		while(esam.hasNext()) {
			EsameDTO esameDTO= new EsameDTO();
			Esame esame=esam.next();
			esameDTO=EsameAdapter.EsameToEsameDTO(esame);
			esamiDTO.add(esameDTO);	
		}
		return esamiDTO;
	}
	
	@GetMapping(value="/getEsameByIdInsegnamento/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	//quello che arriva in id sopra mettilo in id sotto
	public List<EsameDTO> getById(@PathVariable("id") int id) throws EsameNotFoundException, ParseException {
		List<Esame> esami = null;
		List<EsameDTO> esamiDTO=new ArrayList<EsameDTO>();
		esami=(esameService.getAll());
		Iterator<Esame> esam = esami.iterator();
		while(esam.hasNext()) {
			EsameDTO esameDTO= new EsameDTO();
			Esame esame=esam.next();
			if(esame.getInsegnamento().getIdInsegnamento()==id) {
				esameDTO=EsameAdapter.EsameToEsameDTO(esame);
				esamiDTO.add(esameDTO);	
			}
		}
		return esamiDTO;
	}
	
	@GetMapping(value="/esameesistente/{datainizio}/{datafine}/{idInsegnamento}", produces=MediaType.APPLICATION_JSON_VALUE)
	public int EsameEsistente(@PathVariable("datainizio") Date datainizio,@PathVariable("datafine") Date datafine,@PathVariable("idInsegnamento") int idInsegnamento) throws ParseException{
		return esameService.esameEsistente(datainizio, datafine, idInsegnamento);
	}
	
	@GetMapping(value="/esamedocente/{datainizio}/{datafine}/{idDocente}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<EsameDTO> EsameDocente(@PathVariable("datainizio") Date datainizio,@PathVariable("datafine") Date datafine,@PathVariable("idDocente") int idDocente) throws ParseException, DocenteNotFoundException{
		System.out.println(datainizio);
		Docente docente=new Docente();
		docente=docenteService.getById(idDocente);		
		List<Esame> esami = null;
		List<EsameDTO> esamiDTO=new ArrayList<EsameDTO>();
		esami=(esameService.esameDocente(datainizio,datafine,docente));
		Iterator<Esame> esam = esami.iterator();
		while(esam.hasNext()) {
			EsameDTO esameDTO= new EsameDTO();
			Esame esame=esam.next();
			esameDTO=EsameAdapter.EsameToEsameDTO(esame);
			esameDTO.setNomeInsegnamento(esame.getInsegnamento().getNome());
			esameDTO.setNomeaula(esame.getAula().getNome());
			esamiDTO.add(esameDTO);	
		}
		return esamiDTO;
	}	
	
	@GetMapping(value="/getByIdInsegnamento/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	//quello che arriva in id sopra mettilo in id sotto
	public List<EsameDTO> getByIdInsegnamento(@PathVariable("id") int id) throws InsegnamentoNotFoundException{
		Insegnamento insegnamento=insegnamentoService.getById(id);
		System.out.println(insegnamento);
		GregorianCalendar oggi=new GregorianCalendar();
		Date data=oggi.getTime();
		List<Esame> esame=esameService.listaEsamiByInsegnamento(data,insegnamento);
		Iterator<Esame> exam = esame.iterator();
		List<EsameDTO> esaDTO=new ArrayList<EsameDTO>();
		while(exam.hasNext()) {
			EsameDTO esameDTO= new EsameDTO();
			Esame esam=exam.next();
			esameDTO=EsameAdapter.EsameToEsameDTO(esam);
			esaDTO.add(esameDTO);	
		}
		return esaDTO;
	}
	
	@GetMapping(value="/esamestudente/{datainizio}/{datafine}/{idStudente}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<EsameDTO> EsameStudente(@PathVariable("datainizio") Date datainizio,@PathVariable("datafine") Date datafine,@PathVariable("idStudente") int idStudente) throws ParseException, DocenteNotFoundException{
		System.out.println(datainizio);	
		List<Esame> esami = null;
		List<EsameDTO> esamiDTO=new ArrayList<EsameDTO>();
		esami=(esameService.esameStudente(datainizio,datafine,idStudente));
		Iterator<Esame> esam = esami.iterator();
		while(esam.hasNext()) {
			EsameDTO esameDTO= new EsameDTO();
			Esame esame=esam.next();
			esameDTO=EsameAdapter.EsameToEsameDTO(esame);
			esameDTO.setNomeInsegnamento(esame.getInsegnamento().getNome());
			esameDTO.setNomeaula(esame.getAula().getNome());
			esamiDTO.add(esameDTO);	
		}
		return esamiDTO;
	}	
}
