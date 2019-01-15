package it.unisalento.se.saw.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import it.unisalento.se.saw.domain.Insegnamento;
import it.unisalento.se.saw.domain.Libretto;
import it.unisalento.se.saw.domain.Studente;
import it.unisalento.se.saw.dto.LibrettoDTO;

public interface LibrettoRepository extends JpaRepository<Libretto, Integer>{

	
	@Query("select l from Libretto l where l.studente=:idStudente and l.insegnamento=:idInsegnamento")
	public Libretto getLibrettoByIds(@Param("idStudente") Studente studente, @Param("idInsegnamento") Insegnamento insegnamento );
	
	@Modifying
	@Transactional
	@Query("update Libretto set attivo=:attivo where idLibretto=:idLibretto")
		public void update(@Param("idLibretto") int idLibretto,@Param("attivo") int attivo);

	@Query("select l from Libretto l where l.studente=:idStudente and l.attivo=1")
	public List<Libretto> getLibrettoByIdStudente(@Param("idStudente") Studente studente);
	
	@Query("select l.studente from Libretto l where l.insegnamento=:idInsegnamento and l.attivo=1")
	public List<Studente> getStudentiByIdInsegnamento(@Param("idInsegnamento") Insegnamento insegnamento);
	
	
}
