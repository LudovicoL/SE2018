package it.unisalento.se.saw.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import it.unisalento.se.saw.domain.Docente;
import it.unisalento.se.saw.domain.Lezione;
import it.unisalento.se.saw.domain.Materiale;

public interface MaterialeRepository extends JpaRepository<Materiale, Integer>{
/*
	@Modifying
	@Transactional
	@Query("update Materiale m set m.descrizione=:descrizione, m.percorso=:percorso, m.Docente_idDocente=:Docente_idDocente, m.Lezione_idLezione=:Lezione_idLezione, m.abilitazione=:abilitazione where m.idMateriale= :idMateriale")
	public void update(@Param("descrizione") String descrizione, @Param("percorso") String percorso, @Param("Docente_idDocente") int Docente_idDocente, @Param("Lezione_idLezione") int Lezione_idLezione, @Param("abilitazione") int abilitazione, @Param("idMateriale") int idMateriale);
*/
	
}
