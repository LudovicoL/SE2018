package it.unisalento.se.saw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.unisalento.se.saw.domain.Utente;

public interface UtenteRepository extends JpaRepository<Utente, Integer> {
	
	@Query("select u from Utente u where u.idUtente=idUtente")
	public Utente getUserByIdStudente(@Param("idUtente") int idUtente);

}
