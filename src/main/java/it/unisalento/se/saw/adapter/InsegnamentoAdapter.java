package it.unisalento.se.saw.adapter;

import it.unisalento.se.saw.domain.Aula;
import it.unisalento.se.saw.domain.Corso;
import it.unisalento.se.saw.domain.Docente;
import it.unisalento.se.saw.domain.Insegnamento;
import it.unisalento.se.saw.dto.AulaDTO;
import it.unisalento.se.saw.dto.InsegnamentoDTO;

public class InsegnamentoAdapter {
	public static Insegnamento InsegnamentoDTOToInsegnamento(InsegnamentoDTO insegnamentoDTO, Corso corso,Docente docente) {
		Insegnamento insegnamento=new Insegnamento();
		insegnamento.setNome(insegnamentoDTO.getNome());
		insegnamento.setAnno(insegnamentoDTO.getAnno());
		insegnamento.setCfu(insegnamentoDTO.getCfu());
		insegnamento.setSemestre(insegnamentoDTO.getSemestre());
		insegnamento.setCorso(corso);
		insegnamento.setDocente(docente);
		insegnamento.setIdInsegnamento(insegnamentoDTO.getIdInsegnamento());
		insegnamento.setAbilitazione(insegnamentoDTO.getAbilitazione());
		return insegnamento;
	}
	
	public static InsegnamentoDTO InsegnamentoToInsegnamentoDTO(Insegnamento insegnamento) {
		InsegnamentoDTO insegnamentoDTO=new InsegnamentoDTO();
		insegnamentoDTO.setIdInsegnamento(insegnamento.getIdInsegnamento());
		insegnamentoDTO.setNome(insegnamento.getNome());
		insegnamentoDTO.setAnno(insegnamento.getAnno());
		insegnamentoDTO.setCfu(insegnamento.getCfu());
		insegnamentoDTO.setSemestre(insegnamento.getSemestre());
		insegnamentoDTO.setIdCorso(insegnamento.getCorso().getIdCorso());
		insegnamentoDTO.setIdDocente(insegnamento.getDocente().getIdDocente());
		insegnamentoDTO.setNomeCorso(insegnamento.getCorso().getNome());
		insegnamentoDTO.setAbilitazione(insegnamento.getAbilitazione());
		insegnamentoDTO.setNomeDocente(insegnamento.getDocente().getUtente().getNome());
		if(insegnamento.getAbilitazione()==1)
			insegnamentoDTO.setAbilit("Attivo");
		else
			insegnamentoDTO.setAbilit("Disattivo");
		return insegnamentoDTO;
	}
}
