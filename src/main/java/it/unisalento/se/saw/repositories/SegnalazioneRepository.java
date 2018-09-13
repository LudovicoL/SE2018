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
	@Query("update Segnalazione s set s.descrizione=:descrizione, s.Docente_idDocente=:Docente_idDocente, s.Strumento_idStrumento=:Strumento_idStrumento, s.Aula_idAula=:Aula_idAula, s.Segreteria_idSegreteria=:Segreteria_idSegreteria, s.abilitazione:=abilitazione where s.idSegnalazione=:idSegnalazione")
	public void update(@Param("descrizione") String descrizione, @Param("Docente_idDocente") int Docente_idDocente, @Param("Strumento_idStrumento") int Strumento_idStrumento, @Param("Aula_idAula") int Aula_idAula, @Param("Segreteria_idSegreteria") int Segreteria_idSegreteria, @Param("abilitazione") boolean abilitazione, @Param("idSegnalazione") int idSegnalazione);


}
