package it.unisalento.se.saw.adapter;

import it.unisalento.se.saw.domain.Aula;
import it.unisalento.se.saw.domain.Strumento;
import it.unisalento.se.saw.dto.StrumentoDTO;

public class StrumentoAdapter {
	public static Strumento StrumentoDTOToStrumento(StrumentoDTO strumentoDTO, Aula aula) {
		Strumento strumento=new Strumento();
		strumento.setNome(strumentoDTO.getNome());
		strumento.setFunzionante(strumentoDTO.getFunzionante());
		strumento.setAula(aula);
		strumento.setAbilitazione(strumentoDTO.getAbilitazione());
		return strumento;
	}
	
	public static StrumentoDTO StrumentoToStrumentoDTO(Strumento strumento) {
		StrumentoDTO strumentoDTO=new StrumentoDTO();
		strumentoDTO.setNome(strumento.getNome());
		strumentoDTO.setFunzionante(strumento.getFunzionante());
		strumentoDTO.setIdAula(strumento.getAula().getIdAula());
		strumentoDTO.setAbilitazione(strumento.getAbilitazione());
		return strumentoDTO;
	}	
	
		
}
