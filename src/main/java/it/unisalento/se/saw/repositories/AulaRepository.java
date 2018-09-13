package it.unisalento.se.saw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import it.unisalento.se.saw.domain.Aula;


public interface AulaRepository extends JpaRepository<Aula, Integer>{
	@Query("select a from Aula a where a.idAula=:idAula")
	public Aula getAulaById(@Param("idAula") int idAula);

	@Modifying
	@Transactional
	@Query("update Aula a set a.nome=:nome, a.grandezza=:grandezza, a.latitudine=:latitudine, a.longitudine=:longitudine a.abilitazione:=abilitazione where a.idAula= :idAula")
		public void update(@Param("nome") String nome, @Param("grandezza") int grandezza, @Param("latitudine") double latitudine, @Param("longitudine") double longitudine, @Param("abilitazione") boolean abilitazione, @Param("idAula") int idAula);

}
