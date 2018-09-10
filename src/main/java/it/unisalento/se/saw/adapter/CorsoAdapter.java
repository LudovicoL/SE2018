package it.unisalento.se.saw.adapter;

import it.unisalento.se.saw.domain.Corso;
import it.unisalento.se.saw.dto.CorsoDTO;

public class CorsoAdapter {
	
	public static Corso CorsoDTOToCorso(CorsoDTO corsoDTO){
		Corso corso=new Corso();
		corso.setNome(corsoDTO.getNome());
		corso.setDurata(corsoDTO.getDurata());
		corso.setFacolta(corsoDTO.getFacolta());
		corso.setLivello(corsoDTO.getLivello());
		return corso;	
	}
	public static CorsoDTO CorsoToCorsoDTO(Corso corso){
		CorsoDTO corsoDTO=new CorsoDTO();
		corsoDTO.setIdCorso(corso.getIdCorso());
		corsoDTO.setNome(corso.getNome());
		corsoDTO.setLivello(corso.getLivello());
		corsoDTO.setDurata(corso.getDurata());
		corsoDTO.setFacolta(corso.getFacolta());
		return corsoDTO;
	}
}
