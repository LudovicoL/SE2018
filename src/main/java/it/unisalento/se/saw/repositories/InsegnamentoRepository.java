package it.unisalento.se.saw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import it.unisalento.se.saw.domain.Insegnamento;

public interface InsegnamentoRepository extends JpaRepository<Insegnamento, Integer>{

	@Modifying
	@Transactional
	@Query("update Insegnamento i set i.nome=:nome, i.cfu=:cfu, i.semestre=:semestre, i.abilitazione:=abilitazione where i.idInsegnamento=:idInsegnamento")
	public void update(@Param("nome") String nome, @Param("cfu") int cfu, @Param("semestre") int semestre, @Param("abilitazione") boolean abilitazione, @Param("idInsegnamento") int idInsegnamento);

}
