package it.unisalento.se.saw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import it.unisalento.se.saw.domain.Corso;

public interface CorsoRepository extends JpaRepository<Corso, Integer>{
    @Modifying
    @Transactional
	@Query("update Corso c set c.nome=:nome, c.facolta=:facolta, c.durata=:durata, c.livello=:livello, c.abilitazione=:abilitazione where c.idCorso=:idCorso")
	public void update(@Param("nome") String nome, @Param("facolta") String facolta, @Param("durata") int durata, @Param("livello") String livello, @Param("abilitazione") int abilitazione, @Param("idCorso") int idCorso);
}