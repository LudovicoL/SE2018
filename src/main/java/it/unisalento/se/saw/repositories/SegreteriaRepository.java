package it.unisalento.se.saw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import it.unisalento.se.saw.domain.Segreteria;

public interface SegreteriaRepository extends JpaRepository<Segreteria, Integer>{
	
	@Modifying
	@Transactional
	@Query("update Segreteria s set s.stipendio=:stipendio, s.Utente_idUtente=:Utente_idUtente where s.idSegreteria=:idSegreteria")
	public void update(@Param("stipendio") int stipendio, @Param("Utente_idUtente") int Utente_idUtente, @Param("idSegreteria") int idSegreteria);


}
