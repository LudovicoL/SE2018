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

import it.unisalento.se.saw.Iservices.IGradimentoService;
import it.unisalento.se.saw.adapter.GradimentoAdapter;
import it.unisalento.se.saw.domain.Gradimento;
import it.unisalento.se.saw.dto.GradimentoDTO;
import it.unisalento.se.saw.exceptions.GradimentoNotFoundException;

@RestController() //puoi usare i metodi taggati all'interno con l'annotazione responsebody
@RequestMapping(value="/gradimento")

public class GradimentoRestController {
	
	@Autowired
	IGradimentoService gradimentoService;
	
	public GradimentoRestController() {
		super();
	}
	
	public GradimentoRestController(IGradimentoService gradimentoService) {
		this.gradimentoService = gradimentoService;
	}

}
