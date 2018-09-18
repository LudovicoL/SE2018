package it.unisalento.se.saw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import it.unisalento.se.saw.domain.Studente;

public interface StudenteRepository extends JpaRepository<Studente, Integer> {
	@Modifying
	@Transactional
	@Query("update Utente u set u.indirizzo=:indirizzo,u.email=:email where u.idUtente=:idUtente")
	public void update(@Param("idUtente") int idUtente, @Param("email") String email,@Param("indirizzo") String indirizzo);

}
