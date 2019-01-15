package it.unisalento.se.saw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import it.unisalento.se.saw.domain.Corso;
import it.unisalento.se.saw.domain.Docente;

public interface DocenteRepository extends JpaRepository<Docente, Integer>{
	@Modifying
	@Transactional
	@Query("update Docente d set d.stipendio=:stipendio where d.idDocente=:idDocente")
	public void update1(@Param("stipendio") int stipendio, @Param("idDocente") int idDocente );

	
	@Modifying
	@Transactional
	@Query("update Utente u set u.email=:email,u.indirizzo=:indirizzo where u.idUtente=:idUtente")
	public void update2(@Param("email") String email,@Param("indirizzo") String indirizzo, @Param("idUtente") int idUtente );

	
    @Modifying
    @Transactional
	@Query("update Utente u set u.abilitazione=:abilitazione where u.idUtente=:idUtente")
	public void updateAbilitazione(@Param("idUtente") int idUtente,@Param("abilitazione") int abilitazione);

    @Query("Select distinct d from Docente d where d.idDocente=:idDocente")
	public Docente docenteById(@Param("idDocente") int idDocente);

}
