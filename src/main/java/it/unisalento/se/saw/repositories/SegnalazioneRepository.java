package it.unisalento.se.saw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import it.unisalento.se.saw.domain.Segnalazione;

public interface SegnalazioneRepository extends JpaRepository<Segnalazione, Integer>{
	
	@Modifying
	@Transactional
	@Query("update Segnalazione s set s.abilitazione=:abilitazione where s.idSegnalazione=:idSegnalazione")
	public void update(@Param("abilitazione") int abilitazione, @Param("idSegnalazione") int idSegnalazione);

	@Modifying
	@Transactional
	@Query("delete Segnalazione s where s.idSegnalazione=:idSegnalazione")
	public void delete(@Param("idSegnalazione") int idSegnalazione);

}
