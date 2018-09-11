package it.unisalento.se.saw.adapter;

import it.unisalento.se.saw.domain.Gradimento;
import it.unisalento.se.saw.dto.GradimentoDTO;

public class GradimentoAdapter {
	
	public static Gradimento GradimentoDTOToGradimento(GradimentoDTO gradimentoDTO){
		Gradimento gradimento=new Gradimento();
		gradimento.setVoto(gradimentoDTO.getVoto());
		gradimento.setIdStudente(gradimentoDTO.getIdStudente());
		gradimento.setIdMateriale(gradimentoDTO.getIdMateriale());
		gradimento.setIdLezione(gradimentoDTO.getIdLezione());
		return gradimento;	
	}
	public static GradimentoDTO GradimentoToGradimentoDTO(Gradimento gradimento){
		GradimentoDTO gradimentoDTO=new GradimentoDTO();
		gradimentoDTO.setIdGradimento(gradimento.getIdGradimento());
		gradimentoDTO.setVoto(gradimento.getVoto());
		gradimentoDTO.setIdStudente(gradimento.getIdStudente());
		gradimentoDTO.setIdMateriale(gradimento.getIdMateriale());
		gradimentoDTO.setIdLezione(gradimento.getIdLezione());
		return gradimentoDTO;
	}
}

