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
		corso.setAbilitazione(corsoDTO.getAbilitazione());
		corso.setIdCorso(corsoDTO.getIdCorso());
		return corso;	
	}
	public static CorsoDTO CorsoToCorsoDTO(Corso corso){
		CorsoDTO corsoDTO=new CorsoDTO();
		corsoDTO.setIdCorso(corso.getIdCorso());
		corsoDTO.setNome(corso.getNome());
		corsoDTO.setLivello(corso.getLivello());
		corsoDTO.setDurata(corso.getDurata());
		corsoDTO.setFacolta(corso.getFacolta());
		corsoDTO.setAbilitazione(corso.getAbilitazione());
		if(corso.getAbilitazione()==1)
			corsoDTO.setAbilit("Attivo");
		else
			corsoDTO.setAbilit("Disattivo");
		return corsoDTO;
	}
}
