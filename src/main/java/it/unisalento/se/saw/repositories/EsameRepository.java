package it.unisalento.se.saw.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import it.unisalento.se.saw.domain.Aula;
import it.unisalento.se.saw.domain.Docente;
import it.unisalento.se.saw.domain.Esame;
import it.unisalento.se.saw.domain.Insegnamento;
import it.unisalento.se.saw.domain.Lezione;

public interface EsameRepository extends JpaRepository<Esame, Integer>{
/*
	@Modifying
	@Transactional
	@Query("update Esame e set e.data=:data, e.tipo=:tipo, e.Insegnamento_idInsegnamento=:Insegnamento_idInsegnamento, e.Aula_idAula=:Aula_idAula, e.abilitazione=:abilitazione where e.idEsame=:idEsame")
	public void update(@Param("data") String data, @Param("tipo") String tipo, @Param("Insegnamento_idInsegnamento") int Insegnamento_idInsegnamento, @Param("Aula_idAula") int Aula_idAula, @Param("abilitazione") int abilitazione, @Param("idEsame") int idEsame);
*/
	
	@Query("SELECT a FROM Aula a where a.idAula not in (select e.aula from Esame e where e.datainizio<=:datainizio and e.datafine>=:datainizio or e.datainizio<=:datafine and e.datafine>=:datafine or e.datainizio<=:datainizio and e.datafine>=:datafine or e.datainizio>=:datainizio and e.datafine<=:datafine)")
	public List<Aula> auleLibereEsame(@Param("datainizio") Date datainizio,@Param("datafine") Date datafine);

	
	@Query("select count(e)from Esame e where (e.datainizio<=:datainizio and e.datafine>=:datainizio or e.datainizio<=:datafine and e.datafine>=:datafine or e.datainizio<=:datainizio and e.datafine>=:datafine or e.datainizio>=:datainizio and e.datafine<=:datafine)  and e.insegnamento=:idInsegnamento")
	public int esameEsistente(@Param("datainizio") Date datainizio,@Param("datafine") Date datafine, @Param("idInsegnamento") Insegnamento insegnamento);

	@Query("SELECT e FROM Esame e where e.insegnamento in (SELECT i.idInsegnamento FROM Insegnamento i where i.docente=:idDocente) and e.datainizio>=:datainizio and e.datafine<=:datafine order by e.datainizio ")
	public List<Esame> esameDocente(@Param("datainizio") Date datainizio,@Param("datafine") Date datafine,@Param("idDocente") Docente docente);

	@Query("SELECT e FROM Esame e where e.insegnamento=:idInsegnamento and e.datainizio>=:datainizio")
	public List<Esame> esameInsegnamento(@Param("datainizio") Date datainizio,@Param("idInsegnamento") Insegnamento insegnamento);

	@Query("SELECT e FROM Esame e where e.insegnamento in (select i.idInsegnamento from Insegnamento i where i.corso in (select s.corso from Studente s where s.idStudente=:idStudente)) and e.datainizio>=:datainizio and e.datafine<=:datafine order by e.datainizio")
	public List<Esame> esameStudente(@Param("datainizio") Date datainizio,@Param("datafine") Date datafine,@Param("idStudente") Integer idstudente);

}
