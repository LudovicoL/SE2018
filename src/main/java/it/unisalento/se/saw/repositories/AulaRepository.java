package it.unisalento.se.saw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.unisalento.se.saw.domain.Aula;
import it.unisalento.se.saw.domain.Utente;

public interface AulaRepository extends JpaRepository<Aula, Integer>{
	@Query("select a from Aula a where a.idAula=:idAula")
	public Aula getAulaById(@Param("idAula") int idAula);

}
