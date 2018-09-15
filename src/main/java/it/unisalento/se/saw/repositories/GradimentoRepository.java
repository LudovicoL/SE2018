package it.unisalento.se.saw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import it.unisalento.se.saw.domain.Gradimento;

public interface GradimentoRepository extends JpaRepository<Gradimento, Integer> {
	/*@Modifying
	@Transactional
	@Query("update Gradimento g set g.voto=:voto, g.abilitazione=:abilitazione where g.idGradimento=:idGradimento")
	public void update(@Param("voto") int voto, @Param("abilitazione") int abilitazione, @Param("idGradimento") int idGradimento);
*/
}
