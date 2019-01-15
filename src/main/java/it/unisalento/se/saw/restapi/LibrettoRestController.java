package it.unisalento.se.saw.restapi;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hamcrest.text.IsEmptyString;
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

import it.unisalento.se.saw.Iservices.IInsegnamentoService;
import it.unisalento.se.saw.Iservices.ILibrettoService;
import it.unisalento.se.saw.Iservices.IMaterialeService;
import it.unisalento.se.saw.Iservices.IStudenteService;
import it.unisalento.se.saw.adapter.LezioneAdapter;
import it.unisalento.se.saw.adapter.LibrettoAdapter;
import it.unisalento.se.saw.adapter.MaterialeAdapter;
import it.unisalento.se.saw.adapter.StudenteAdapter;
import it.unisalento.se.saw.domain.Aula;
import it.unisalento.se.saw.domain.Docente;
import it.unisalento.se.saw.domain.Insegnamento;
import it.unisalento.se.saw.domain.Lezione;
import it.unisalento.se.saw.domain.Libretto;
import it.unisalento.se.saw.domain.Materiale;
import it.unisalento.se.saw.domain.Studente;
import it.unisalento.se.saw.domain.Utente;
import it.unisalento.se.saw.dto.LezioneDTO;
import it.unisalento.se.saw.dto.LibrettoDTO;
import it.unisalento.se.saw.dto.MaterialeDTO;
import it.unisalento.se.saw.dto.StudenteDTO;
import it.unisalento.se.saw.exceptions.AulaNotFoundException;
import it.unisalento.se.saw.exceptions.DocenteNotFoundException;
import it.unisalento.se.saw.exceptions.InsegnamentoNotFoundException;
import it.unisalento.se.saw.exceptions.LezioneNotFoundException;
import it.unisalento.se.saw.exceptions.LibrettoNotFoundException;
import it.unisalento.se.saw.exceptions.StudenteNotFoundException;

@RestController() //puoi usare i metodi taggati all'interno con l'annotazione responsebody
@RequestMapping(value="/libretto")
public class LibrettoRestController {

	@Autowired
	ILibrettoService librettoService;
	
	@Autowired
	IInsegnamentoService insegnamentoService;
	
	@Autowired
	IStudenteService studenteService;
	
	public LibrettoRestController() {
		super();
	}
	
	public LibrettoRestController(ILibrettoService librettoService) {
		this.librettoService = librettoService;
	}
	
	@PostMapping(value="save", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void post(@RequestBody LibrettoDTO librettoDTO) throws StudenteNotFoundException, InsegnamentoNotFoundException {
		Studente studente=studenteService.getById(librettoDTO.getIdStudente());
		Insegnamento insegnamento=insegnamentoService.getById(librettoDTO.getIdInsegnamento());
		Libretto libretto=LibrettoAdapter.LibrettoDTOToLibretto(librettoDTO,studente,insegnamento);
		System.out.println(libretto.getStudente().getUtente().getNome());
		System.out.println(libretto.getInsegnamento().getNome());
		librettoService.save(libretto);
	}
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<LibrettoDTO> getAll() throws LibrettoNotFoundException {;
		List<Libretto> libretti = null;
		List<LibrettoDTO> librettiDTO=new ArrayList<LibrettoDTO>();
		libretti=(librettoService.getAll());
		Iterator<Libretto> lib = libretti.iterator();
		while(lib.hasNext()) {
			LibrettoDTO librettoDTO= new LibrettoDTO();
			Libretto libretto=lib.next();
			librettoDTO=LibrettoAdapter.LibrettoToLibrettoDTO(libretto);
			librettiDTO.add(librettoDTO);	
		}
		return librettiDTO;
	}
	
	@GetMapping(value="/getLibrettoByIdStudente/{idStudente}", produces=MediaType.APPLICATION_JSON_VALUE)
	//quello che arriva in id sopra mettilo in id sotto
	public List<LibrettoDTO> getByIdStudente(@PathVariable("idStudente") int idStudente) throws StudenteNotFoundException {
		Studente studente=studenteService.getById(idStudente);
		List<Libretto> libretti = null;
		List<LibrettoDTO> librettiDTO=new ArrayList<LibrettoDTO>();
		libretti=librettoService.getByIdStudente(studente);
		Iterator<Libretto> lib = libretti.iterator();
		while(lib.hasNext()) {
			LibrettoDTO librettoDTO= new LibrettoDTO();
			Libretto libretto=lib.next();
			librettoDTO=LibrettoAdapter.LibrettoToLibrettoDTO(libretto);
			librettiDTO.add(librettoDTO);	
		}
		return librettiDTO;
	}
	
	@PatchMapping(value="/update", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody LibrettoDTO librettoDTO) throws AulaNotFoundException {
		librettoService.update(librettoDTO);
	}
	
	@GetMapping(value="/getLibrettoByIds/{idStudente}/{idInsegnamento}", produces=MediaType.APPLICATION_JSON_VALUE)
	//quello che arriva in id sopra mettilo in id sotto
	public LibrettoDTO getByIds(@PathVariable("idStudente") int idStudente,@PathVariable("idInsegnamento") int idInsegnamento) throws StudenteNotFoundException, InsegnamentoNotFoundException {
		Studente studente=new Studente();
		Insegnamento insegnamento=new Insegnamento();
		LibrettoDTO librettoDTO=new LibrettoDTO();
		try{
			studente=studenteService.getById(idStudente);
			insegnamento=insegnamentoService.getById(idInsegnamento);
			librettoDTO= LibrettoAdapter.LibrettoToLibrettoDTO(librettoService.getByIds(studente, insegnamento));
			return librettoDTO;
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return librettoDTO;
		}
	
	}
	@GetMapping(value="/getStudentiByInsegnamento/{idInsegnamento}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<StudenteDTO> getStudentiByIdInsegnamento(@PathVariable("idInsegnamento") int idInsegnamento) throws InsegnamentoNotFoundException{
		List<Studente> studenti = new ArrayList<Studente>();;
		List<StudenteDTO> studDTO=new ArrayList<StudenteDTO>();
		Insegnamento insegnamento= insegnamentoService.getById(idInsegnamento);
		studenti=(librettoService.getStudentiByIdInsegnamento(insegnamento));
		Utente utente=new Utente();
		Iterator<Studente> student = studenti.iterator();
		while(student.hasNext()) {
			StudenteDTO studenteDTO= new StudenteDTO();
			Studente stud=student.next();
			utente=stud.getUtente();
			studenteDTO=StudenteAdapter.StudenteToStudenteDTO(stud, utente);
			studDTO.add(studenteDTO);	
		}
		return studDTO;
	}
	
}
