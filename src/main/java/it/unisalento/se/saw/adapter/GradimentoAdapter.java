package it.unisalento.se.saw.adapter;

import it.unisalento.se.saw.domain.Gradimento;
import it.unisalento.se.saw.domain.Lezione;
import it.unisalento.se.saw.domain.Materiale;
import it.unisalento.se.saw.domain.Studente;
import it.unisalento.se.saw.dto.GradimentoDTO;

public class GradimentoAdapter {
	
	public static Gradimento GradimentoDTOToGradimento(GradimentoDTO gradimentoDTO, Studente studente, Lezione lezione, Materiale materiale){
		Gradimento gradimento=new Gradimento();
		gradimento.setVoto(gradimentoDTO.getVoto());
		gradimento.setStudente(studente);
		gradimento.setMateriale(materiale);
		gradimento.setLezione(lezione);
		return gradimento;	
	}
	public static GradimentoDTO GradimentoToGradimentoDTO(Gradimento gradimento){
		GradimentoDTO gradimentoDTO=new GradimentoDTO();
		gradimentoDTO.setIdGradimento(gradimento.getIdGradimento());
		gradimentoDTO.setVoto(gradimento.getVoto());
		gradimentoDTO.setIdStudente(gradimento.getStudente().getIdStudente());
		gradimentoDTO.setIdMateriale(gradimento.getMateriale().getIdMateriale());
		gradimentoDTO.setIdLezione(gradimento.getLezione().getIdLezione());
		return gradimentoDTO;
	}
}

