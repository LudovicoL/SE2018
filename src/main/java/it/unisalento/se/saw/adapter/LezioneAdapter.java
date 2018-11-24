package it.unisalento.se.saw.adapter;

import java.util.Date;
import it.unisalento.se.saw.domain.Aula;
import it.unisalento.se.saw.domain.Insegnamento;
import it.unisalento.se.saw.domain.Lezione;
import it.unisalento.se.saw.dto.LezioneDTO;


public class LezioneAdapter {
	public static Lezione LezioneDTOToLezione(LezioneDTO lezioneDTO,Aula aula, Insegnamento insegnamento) {
		Date data=new Date();
		Lezione lezione=new Lezione();
		data=lezioneDTO.getDatainizio();
		lezione.setDatainizio(data);
		data=lezioneDTO.getDatafine();
		lezione.setDatafine(data);
		lezione.setAula(aula);
		lezione.setInsegnamento(insegnamento);
		return lezione;
	}
	
	public static LezioneDTO LezioneToLezioneDTO(Lezione lezione) {
		LezioneDTO lezioneDTO=new LezioneDTO();
		Date data=new Date();
		data=lezione.getDatainizio();
		lezioneDTO.setIdLezione(lezione.getIdLezione());
		lezioneDTO.setDatainizio(data);
		data=lezione.getDatafine();
		lezioneDTO.setDatafine(data);
		lezioneDTO.setIdAula(lezione.getAula().getIdAula());
		lezioneDTO.setIdInsegnamento(lezione.getInsegnamento().getIdInsegnamento());
		lezioneDTO.setNomeaula(lezione.getAula().getNome());
		return lezioneDTO;
	}
}