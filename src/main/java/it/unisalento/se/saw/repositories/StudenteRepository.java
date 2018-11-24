package it.unisalento.se.saw.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import it.unisalento.se.saw.domain.Corso;
import it.unisalento.se.saw.domain.Studente;

public interface StudenteRepository extends JpaRepository<Studente, Integer> {
	@Modifying
	@Transactional
	@Query("update Utente u set u.indirizzo=:indirizzo,u.email=:email where u.idUtente=:idUtente")
	public void update(@Param("idUtente") int idUtente, @Param("email") String email,@Param("indirizzo") String indirizzo);

    @Modifying
    @Transactional
	@Query("update Utente u set u.abilitazione=:abilitazione where u.idUtente=:idUtente")
	public void updateAbilitazione(@Param("idUtente") int idUtente,@Param("abilitazione") int abilitazione);

    @Query("select s from Studente s where s.corso=:idCorso and idStudente!=:idstudente")
	public List<Studente> listastudentibycorso(@Param("idCorso")Corso corso,@Param("idstudente")Integer idstudente);

}
