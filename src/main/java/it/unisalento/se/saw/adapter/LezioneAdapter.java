package it.unisalento.se.saw.adapter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import it.unisalento.se.saw.domain.Aula;
import it.unisalento.se.saw.domain.Insegnamento;
import it.unisalento.se.saw.domain.Lezione;
import it.unisalento.se.saw.dto.LezioneDTO;


public class LezioneAdapter {
	public static Lezione LezioneDTOToLezione(LezioneDTO lezioneDTO,Aula aula, Insegnamento insegnamento) throws ParseException{
		DateFormat formatter1;
		formatter1 = new SimpleDateFormat("yyyy-mm-DD hh:mm");
		Lezione lezione=new Lezione();
		lezione.setDatainizio(formatter1.parse(lezioneDTO.getDatainizio()));
		lezione.setDatafine(formatter1.parse(lezioneDTO.getDatafine()));
		lezione.setAula(aula);
		lezione.setInsegnamento(insegnamento);
		return lezione;
	}
	
	public static LezioneDTO LezioneToLezioneDTO(Lezione lezione) {
		LezioneDTO lezioneDTO=new LezioneDTO();
		lezioneDTO.setIdLezione(lezione.getIdLezione());
		lezioneDTO.setDatainizio(lezione.getDatainizio().toString());
		lezioneDTO.setDatafine(lezione.getDatafine().toString());
		lezioneDTO.setIdAula(lezione.getAula().getIdAula());
		lezioneDTO.setIdInsegnamento(lezione.getInsegnamento().getIdInsegnamento());
		return lezioneDTO;
	}
}