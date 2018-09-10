package it.unisalento.se.saw.adapter;

import it.unisalento.se.saw.domain.Aula;
import it.unisalento.se.saw.domain.Strumento;
import it.unisalento.se.saw.dto.StrumentoDTO;

public class StrumentoAdapter {
	public static Strumento StrumentoDTOToStrumento(StrumentoDTO strumentoDTO, Aula aula) {
		Strumento strumento=new Strumento();
		strumento.setNome(strumentoDTO.getNome());
		strumento.setAgibile(strumentoDTO.getAgibile());
		strumento.setAula(aula);
		return strumento;
	}
	
	public static StrumentoDTO StrumentoToStrumentoDTO(Strumento strumento) {
		StrumentoDTO strumentoDTO=new StrumentoDTO();
		strumentoDTO.setNome(strumento.getNome());
		strumentoDTO.setAgibile(strumento.getAgibile());
		strumentoDTO.setIdAula(strumento.getAula().getIdAula());
		return strumentoDTO;
	}	
	
		
}
