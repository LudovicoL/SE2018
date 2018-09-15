package it.unisalento.se.saw.adapter;

import it.unisalento.se.saw.domain.Aula;
import it.unisalento.se.saw.dto.AulaDTO;

public class AulaAdapter {
	public static Aula AulaDTOToAula(AulaDTO aulaDTO) {
		Aula aula=new Aula();
		aula.setNome(aulaDTO.getNome());
		aula.setGrandezza(aulaDTO.getGrandezza());
		aula.setLatitudine(aulaDTO.getLatitudine());
		aula.setLongitudine(aulaDTO.getLongitudine());
		return aula;
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
