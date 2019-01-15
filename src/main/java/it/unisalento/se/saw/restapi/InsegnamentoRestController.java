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

import it.unisalento.se.saw.Iservices.ICorsoService;
import it.unisalento.se.saw.Iservices.IDocenteService;
import it.unisalento.se.saw.Iservices.IInsegnamentoService;
import it.unisalento.se.saw.Iservices.IStudenteService;
import it.unisalento.se.saw.Iservices.IUtenteService;
import it.unisalento.se.saw.adapter.DocenteAdapter;
import it.unisalento.se.saw.adapter.InsegnamentoAdapter;
import it.unisalento.se.saw.domain.Corso;
import it.unisalento.se.saw.domain.Docente;
import it.unisalento.se.saw.domain.Insegnamento;
import it.unisalento.se.saw.domain.Studente;
import it.unisalento.se.saw.domain.Utente;
import it.unisalento.se.saw.dto.DocenteDTO;
import it.unisalento.se.saw.dto.InsegnamentoDTO;
import it.unisalento.se.saw.exceptions.CorsoNotFoundException;
import it.unisalento.se.saw.exceptions.DocenteNotFoundException;
import it.unisalento.se.saw.exceptions.InsegnamentoNotFoundException;
import it.unisalento.se.saw.exceptions.StudenteNotFoundException;
import it.unisalento.se.saw.exceptions.UtenteNotFoundException;

@RestController() //puoi usare i metodi taggati all'interno con l'annotazione responsebody
@RequestMapping(value="/insegnamento")
public class InsegnamentoRestController {
	
	@Autowired
	IInsegnamentoService insegnamentoService;
	@Autowired
	ICorsoService corsoService;
	@Autowired
	IDocenteService docenteService;
	@Autowired
	IStudenteService studenteService;
	@Autowired
	IUtenteService utenteService;
	
	public InsegnamentoRestController() {
		super();
	}
	
	public InsegnamentoRestController(IInsegnamentoService insegnamentoService) {
		this.insegnamentoService = insegnamentoService;
	}
	
	
	@PostMapping(value="save", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void post(@RequestBody InsegnamentoDTO insegnamentoDTO) throws InsegnamentoNotFoundException, CorsoNotFoundException, DocenteNotFoundException {
		Insegnamento insegnamento=new Insegnamento();
		Corso corso=corsoService.getById(insegnamentoDTO.getIdCorso());
		Docente docente=docenteService.getById(insegnamentoDTO.getIdDocente());
		insegnamento=InsegnamentoAdapter.InsegnamentoDTOToInsegnamento(insegnamentoDTO, corso, docente);
		insegnamentoService.save(insegnamento);
	}
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<InsegnamentoDTO> getAll() throws InsegnamentoNotFoundException {;
		List<Insegnamento> insegnamento = null;
		List<InsegnamentoDTO> insDTO=new ArrayList<InsegnamentoDTO>();
		insegnamento=(insegnamentoService.getAll());
		Iterator<Insegnamento> insegnament = insegnamento.iterator();
		while(insegnament.hasNext()) {
			InsegnamentoDTO insegnamentoDTO= new InsegnamentoDTO();
			Insegnamento insegn=insegnament.next();
			insegnamentoDTO=InsegnamentoAdapter.InsegnamentoToInsegnamentoDTO(insegn);
			insDTO.add(insegnamentoDTO);	
		}
		return insDTO;
	}
	
	@PatchMapping(value="/update", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody InsegnamentoDTO insegnamentoDTO) {
		insegnamentoService.update(insegnamentoDTO);
	}
	@PatchMapping(value="/updateabilitazione", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void updateabilitazione(@RequestBody InsegnamentoDTO insegnamentoDTO) {
		insegnamentoService.updateAbilitazione(insegnamentoDTO);
	}
	
	
	@GetMapping(value="/getByIdCorso/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	//quello che arriva in id sopra mettilo in id sotto
	public List<InsegnamentoDTO> getByIdCorso(@PathVariable("id") int id) throws CorsoNotFoundException{
		Corso corso=corsoService.getById(id);
		List<Insegnamento> insegnamento=insegnamentoService.listainsegnamentibycorso(corso);
		Iterator<Insegnamento> insegnament = insegnamento.iterator();
		List<InsegnamentoDTO> insDTO=new ArrayList<InsegnamentoDTO>();
		while(insegnament.hasNext()) {
			InsegnamentoDTO insegnamentoDTO= new InsegnamentoDTO();
			Insegnamento insegn=insegnament.next();
			insegnamentoDTO=InsegnamentoAdapter.InsegnamentoToInsegnamentoDTO(insegn);
			insDTO.add(insegnamentoDTO);	
		}
		return insDTO;
	}
	
	@GetMapping(value="/getByIdCorsoDistinct/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	//quello che arriva in id sopra mettilo in id sotto
	public List<DocenteDTO> getByIdCorsoDistinct(@PathVariable("id") int id) throws CorsoNotFoundException, UtenteNotFoundException{
		Corso corso=corsoService.getById(id);
		List<Docente> docenti=new ArrayList<Docente>();
		List<DocenteDTO> docentiDTO=new ArrayList<DocenteDTO>();
		docenti=insegnamentoService.listainsegnamentibycorsoDistinct(corso);
		Iterator<Docente> docent = docenti.iterator();
		while(docent.hasNext()) {
			DocenteDTO docenteDTO= new DocenteDTO();
			Docente doc=docent.next();
			Utente utente=new Utente();
			utente=utenteService.getById(doc.getUtente().getIdUtente());
			docenteDTO=DocenteAdapter.DocenteToDocenteDTO(doc,utente);
			docentiDTO.add(docenteDTO);	
		}
		return docentiDTO;
	}
	
	@GetMapping(value="/getByIdDocente/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	//quello che arriva in id sopra mettilo in id sotto
	public List<InsegnamentoDTO> getByIdDocente(@PathVariable("id") int id) throws DocenteNotFoundException{
		Docente docente=docenteService.getById(id);
		List<Insegnamento> insegnamento=insegnamentoService.listainsegnamentibyDocente(docente);
		Iterator<Insegnamento> insegnament = insegnamento.iterator();
		List<InsegnamentoDTO> insDTO=new ArrayList<InsegnamentoDTO>();
		while(insegnament.hasNext()) {
			InsegnamentoDTO insegnamentoDTO= new InsegnamentoDTO();
			Insegnamento insegn=insegnament.next();
			insegnamentoDTO=InsegnamentoAdapter.InsegnamentoToInsegnamentoDTO(insegn);
			insDTO.add(insegnamentoDTO);	
		}
		return insDTO;
	}
	
	@GetMapping(value="/getByIdStudente/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	//quello che arriva in id sopra mettilo in id sotto
	public List<InsegnamentoDTO> getByIdStudente(@PathVariable("id") int id) throws StudenteNotFoundException{
		Studente studente=studenteService.getById(id);
		List<Insegnamento> insegnamento=insegnamentoService.listainsegnamentibyStudente(studente.getCorso());
		Iterator<Insegnamento> insegnament = insegnamento.iterator();
		List<InsegnamentoDTO> insDTO=new ArrayList<InsegnamentoDTO>();
		while(insegnament.hasNext()) {
			InsegnamentoDTO insegnamentoDTO= new InsegnamentoDTO();
			Insegnamento insegn=insegnament.next();
			insegnamentoDTO=InsegnamentoAdapter.InsegnamentoToInsegnamentoDTO(insegn);
			insDTO.add(insegnamentoDTO);	
		}
		return insDTO;
	}
}
