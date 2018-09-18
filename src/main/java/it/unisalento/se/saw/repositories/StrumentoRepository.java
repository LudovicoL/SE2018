package it.unisalento.se.saw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import it.unisalento.se.saw.domain.Strumento;

public interface StrumentoRepository extends JpaRepository<Strumento, Integer>{

	@Modifying
	@Transactional
	@Query("update Strumento s set s.nome=:nome, s.abilitazione=:abilitazione, s.funzionante=:funzionante where s.idStrumenti=:idStrumento")
	public void update(@Param("nome") String nome, @Param("funzionante") int funzionante, @Param("abilitazione") int abilitazione, @Param("idStrumento") int idStrumento);

}
