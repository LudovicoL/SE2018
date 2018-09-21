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
	@Query("update Aula set grandezza=:grandezza where idAula= :idAula")
		public void update(@Param("grandezza") String grandezza,@Param("idAula") int idAula);

	 @Modifying
	 @Transactional
	 @Query("delete from Aula u where u.idAula=:idAula")
	    public void delete(@Param("idAula") int idAula);
}
