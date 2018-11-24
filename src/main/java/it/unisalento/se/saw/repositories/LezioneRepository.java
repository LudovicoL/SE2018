package it.unisalento.se.saw.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.unisalento.se.saw.domain.Aula;
import it.unisalento.se.saw.domain.Docente;
import it.unisalento.se.saw.domain.Insegnamento;
import it.unisalento.se.saw.domain.Lezione;
import it.unisalento.se.saw.domain.Studente;


public interface LezioneRepository extends JpaRepository<Lezione, Integer>{
	/*
	@Modifying
	@Transactional
	@Query("update Lezione l set l.data=:data, l.Insegnamento_idInsegnamento=:Insegnamento_idInsegnamento, l.Aula_idAula=:Aula_idAula, l.abilitazione=:abilitazione where l.idLezione=:idLezione")
	public void update(@Param("data") String data, @Param("Insegnamento_idInsegnamento") int Insegnamento_idInsegnamento, @Param("Aula_idAula") int Aula_idAula, @Param("abilitazione") int abilitazione, @Param("idLezione") int idLezione);
*/
	@Query("SELECT a FROM Aula a where a.idAula not in (select l.aula from Lezione l where l.datainizio<=:datainizio and l.datafine>=:datainizio or l.datainizio<=:datafine and l.datafine>=:datafine or l.datainizio<=:datainizio and l.datafine>=:datafine or l.datainizio>=:datainizio and l.datafine<=:datafine)")
	public List<Aula> auleLibere(@Param("datainizio") Date datainizio,@Param("datafine") Date datafine);

	
	@Query("select count(l)from Lezione l where (l.datainizio<=:datainizio and l.datafine>=:datainizio or l.datainizio<=:datafine and l.datafine>=:datafine or l.datainizio<=:datainizio and l.datafine>=:datafine or l.datainizio>=:datainizio and l.datafine<=:datafine)  and l.insegnamento=:idInsegnamento")
	public int lezioneEsistente(@Param("datainizio") Date datainizio,@Param("datafine") Date datafine, @Param("idInsegnamento") Insegnamento insegnamento);

	@Query("SELECT l FROM Lezione l where l.insegnamento in (SELECT i.idInsegnamento FROM Insegnamento i where i.docente=:idDocente) and l.datainizio>=:datainizio and l.datafine<=:datafine order by l.datainizio ")
	public List<Lezione> lezioneDocente(@Param("datainizio") Date datainizio,@Param("datafine") Date datafine,@Param("idDocente") Docente docente);

	@Query("SELECT l FROM Lezione l where l.insegnamento in (select i.idInsegnamento from Insegnamento i where i.corso in (select s.corso from Studente s where s.idStudente=:idStudente)) and l.datainizio>=:datainizio and l.datafine<=:datafine order by l.datainizio")
	public List<Lezione> lezioneStudente(@Param("datainizio") Date datainizio,@Param("datafine") Date datafine,@Param("idStudente") Integer idstudente);

	@Query("SELECT l FROM Lezione l where l.insegnamento=:idInsegnamento")
	public List<Lezione> lezioneInsegnamento(@Param("idInsegnamento") Insegnamento insegnamento);

}
