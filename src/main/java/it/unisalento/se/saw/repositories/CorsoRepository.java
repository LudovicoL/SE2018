package it.unisalento.se.saw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.unisalento.se.saw.domain.Corso;

public interface CorsoRepository extends JpaRepository<Corso, Integer>{
	@Modifying
	@Query("update Corso c set c.nome=nome where c.idCorso=4")
	public Corso update(@Param("nome") String nome);
}

