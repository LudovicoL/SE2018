package it.unisalento.se.saw.adapter;

import it.unisalento.se.saw.domain.Insegnamento;
import it.unisalento.se.saw.domain.Libretto;
import it.unisalento.se.saw.domain.Studente;
import it.unisalento.se.saw.dto.LibrettoDTO;

public class LibrettoAdapter {
	public static Libretto LibrettoDTOToLibretto(LibrettoDTO librettoDTO,Studente studente, Insegnamento insegnamento) {
		Libretto libretto = new Libretto();
		libretto.setStudente(studente);
		libretto.setInsegnamento(insegnamento);
		libretto.setAttivo(librettoDTO.getAttivo());
		return libretto;
	}
	
	public static LibrettoDTO LibrettoToLibrettoDTO(Libretto libretto) {
		LibrettoDTO librettoDTO=new LibrettoDTO();
		librettoDTO.setIdLibretto(libretto.getIdLibretto());
		librettoDTO.setAttivo(libretto.getAttivo());
		librettoDTO.setIdInsegnamento(libretto.getInsegnamento().getIdInsegnamento());
		librettoDTO.setIdStudente(libretto.getStudente().getIdStudente());
		librettoDTO.setNomeInsegnamento(libretto.getInsegnamento().getNome());
		librettoDTO.setIdDocente(libretto.getInsegnamento().getDocente().getIdDocente());
		return librettoDTO;
	}
}
