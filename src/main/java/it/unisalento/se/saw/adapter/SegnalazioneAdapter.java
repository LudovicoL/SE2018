package it.unisalento.se.saw.adapter;

import it.unisalento.se.saw.domain.Aula;
import it.unisalento.se.saw.domain.Docente;
import it.unisalento.se.saw.domain.Segnalazione;
import it.unisalento.se.saw.domain.Strumento;
import it.unisalento.se.saw.dto.SegnalazioneDTO;

public class SegnalazioneAdapter {
	public static Segnalazione SegnalazioneDTOToSegnalazione(SegnalazioneDTO segnalazioneDTO, Docente docente, Aula aula) {
		Segnalazione segnalazione=new Segnalazione();
		segnalazione.setDescrizione(segnalazioneDTO.getDescrizione());
		segnalazione.setDocente(docente);
		segnalazione.setAula(aula);
		segnalazione.setAbilitazione(segnalazioneDTO.getAbilitazione());
		segnalazione.setCommento(segnalazioneDTO.getCommento());
		return segnalazione;
	}
	public static SegnalazioneDTO SegnalazioneToSegnalazioneDTO(Segnalazione segnalazione) {
		SegnalazioneDTO segnalazioneDTO=new SegnalazioneDTO();
		segnalazioneDTO.setIdSegnalazione(segnalazione.getIdSegnalazione());
		segnalazioneDTO.setDescrizione(segnalazione.getDescrizione());
		segnalazioneDTO.setAbilitazione(segnalazione.getAbilitazione());
		segnalazioneDTO.setIdAula(segnalazione.getAula().getIdAula());
		segnalazioneDTO.setIdDocente(segnalazione.getDocente().getIdDocente());
		if(segnalazioneDTO.getAbilitazione()==0)
			segnalazioneDTO.setStato("In attesa");
		if(segnalazioneDTO.getAbilitazione()==1)
			segnalazioneDTO.setStato("In carico");
		if(segnalazioneDTO.getAbilitazione()==2)
			segnalazioneDTO.setStato("Risolta");
		if(segnalazioneDTO.getAbilitazione()==3)
			segnalazioneDTO.setStato("Rifiutata");
		segnalazioneDTO.setNomeaula(segnalazione.getAula().getNome());
		segnalazioneDTO.setNomedocente(segnalazione.getDocente().getUtente().getNome()+ " " +segnalazione.getDocente().getUtente().getCognome());
		segnalazioneDTO.setCommento(segnalazione.getCommento());
		return segnalazioneDTO;
	}	
	
}
