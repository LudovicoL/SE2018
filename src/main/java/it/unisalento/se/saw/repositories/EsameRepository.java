package it.unisalento.se.saw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import it.unisalento.se.saw.domain.Esame;

public interface EsameRepository extends JpaRepository<Esame, Integer>{
/*
	@Modifying
	@Transactional
	@Query("update Esame e set e.data=:data, e.tipo=:tipo, e.Insegnamento_idInsegnamento=:Insegnamento_idInsegnamento, e.Aula_idAula=:Aula_idAula, e.abilitazione=:abilitazione where e.idEsame=:idEsame")
	public void update(@Param("data") String data, @Param("tipo") String tipo, @Param("Insegnamento_idInsegnamento") int Insegnamento_idInsegnamento, @Param("Aula_idAula") int Aula_idAula, @Param("abilitazione") int abilitazione, @Param("idEsame") int idEsame);
*/
}
