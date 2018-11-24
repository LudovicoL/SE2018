package it.unisalento.se.saw.adapter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import it.unisalento.se.saw.domain.Aula;
import it.unisalento.se.saw.domain.Esame;
import it.unisalento.se.saw.domain.Insegnamento;
import it.unisalento.se.saw.dto.EsameDTO;

public class EsameAdapter {
	public static Esame EsameDTOToEsame(EsameDTO esameDTO,Aula aula, Insegnamento insegnamento) throws ParseException{
		Date data=new Date();
		Esame esame=new Esame();
		data=esameDTO.getDatainizio();
		esame.setDatainizio(data);
		data=esameDTO.getDatafine();
		esame.setDatafine(data);
		esame.setAula(aula);
		esame.setInsegnamento(insegnamento);
		esame.setTipo(esameDTO.getTipo());
		return esame;
	}
	
	public static EsameDTO EsameToEsameDTO(Esame esame) {
		EsameDTO esameDTO=new EsameDTO();
		Date data=new Date();
		data=esame.getDatainizio();
		esameDTO.setIdEsame(esame.getIdEsame());
		esameDTO.setDatainizio(data);
		data=esame.getDatafine();
		esameDTO.setDatafine(data);
		esameDTO.setIdAula(esame.getAula().getIdAula());
		esameDTO.setIdInsegnamento(esame.getInsegnamento().getIdInsegnamento());
		esameDTO.setNomeaula(esame.getAula().getNome());
		esameDTO.setNomeInsegnamento(esame.getInsegnamento().getNome());
		esameDTO.setTipo(esame.getTipo());
		esameDTO.setNomeDocente(esame.getInsegnamento().getDocente().getUtente().getNome()+ " " +(esame.getInsegnamento().getDocente().getUtente().getCognome()));
		return esameDTO;
	}
}
