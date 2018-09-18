package it.unisalento.se.saw.adapter;

import it.unisalento.se.saw.domain.Aula;
import it.unisalento.se.saw.domain.Corso;
import it.unisalento.se.saw.domain.Insegnamento;
import it.unisalento.se.saw.dto.AulaDTO;
import it.unisalento.se.saw.dto.InsegnamentoDTO;

public class InsegnamentoAdapter {
	public static Insegnamento InsegnamentoDTOToInsegnamento(InsegnamentoDTO insegnamentoDTO, Corso corso) {
		Insegnamento insegnamento=new Insegnamento();
		insegnamento.setNome(insegnamentoDTO.getNome());
		insegnamento.setAnno(insegnamentoDTO.getAnno());
		insegnamento.setCfu(insegnamentoDTO.getCfu());
		insegnamento.setSemestre(insegnamentoDTO.getSemestre());
		return insegnamento;
	}
	
	public static AulaDTO AulaToAulaDTO(Aula aula) {
		AulaDTO aulaDTO=new AulaDTO();
		aulaDTO.setIdAula(aula.getIdAula());
		aulaDTO.setNome(aula.getNome());
		aulaDTO.setGrandezza(aula.getGrandezza());
		aulaDTO.setLatitudine(aula.getLatitudine());
		aulaDTO.setLongitudine(aula.getLongitudine());
		return aulaDTO;
	}
}
