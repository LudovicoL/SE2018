package it.unisalento.se.saw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import it.unisalento.se.saw.domain.Lezione;

public interface LezioneRepository extends JpaRepository<Lezione, Integer>{

	@Modifying
	@Transactional
	@Query("update Lezione l set l.data=:data, l.Insegnamento_idInsegnamento=:Insegnamento_idInsegnamento, l.Aula_idAula=:Aula_idAula where l.idLezione=:idLezione")
	public void update(@Param("data") String data, @Param("Insegnamento_idInsegnamento") int Insegnamento_idInsegnamento, @Param("Aula_idAula") int Aula_idAula, @Param("idLezione") int idLezione);
}
