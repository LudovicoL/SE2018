package it.unisalento.se.saw.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import it.unisalento.se.saw.Iservices.IStudenteService;
import it.unisalento.se.saw.Iservices.IUtenteService;
import it.unisalento.se.saw.domain.Studente;
import it.unisalento.se.saw.domain.Utente;
import it.unisalento.se.saw.dto.StudenteDTO;
import it.unisalento.se.saw.dto.UtenteDTO;
import it.unisalento.se.saw.exceptions.StudenteNotFoundException;
import it.unisalento.se.saw.services.StudenteService;

@Controller
public class HomeController {
	


	//creo Iaulaservice, iuserservice per far dipendere l interfaccia del servizio al controller e non tutta la sua implementazione
	@Autowired
	IStudenteService studenteService;

	
	@Autowired
	public HomeController() {
		super();
	}
	
	public HomeController(IStudenteService studenteService) {
		this.studenteService = studenteService;
	}
	/*
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public String studente(ModelMap modelMap) throws StudenteNotFoundException {
		Utente utente = studenteService.getById(1);
		UtenteDTO utenteDTO = new UtenteDTO();
		utenteDTO.setName(utente.getNome());
		utenteDTO.setSurname(utente.getCognome());
		System.out.println(utenteDTO.getName());
		modelMap.addAttribute("users", utenteDTO);
		return "users";
	}*/
	
}
