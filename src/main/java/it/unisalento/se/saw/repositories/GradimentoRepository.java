package it.unisalento.se.saw.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import it.unisalento.se.saw.domain.Docente;
import it.unisalento.se.saw.domain.Gradimento;
import it.unisalento.se.saw.domain.Insegnamento;
import it.unisalento.se.saw.domain.Lezione;
import it.unisalento.se.saw.domain.Materiale;
import it.unisalento.se.saw.domain.Studente;

public interface GradimentoRepository extends JpaRepository<Gradimento, Integer> {
	/*@Modifying
	@Transactional
	@Query("update Gradimento g set g.voto=:voto, g.abilitazione=:abilitazione where g.idGradimento=:idGradimento")
	public void update(@Param("voto") int voto, @Param("abilitazione") int abilitazione, @Param("idGradimento") int idGradimento);
*/
    @Query("select voto from Gradimento as g where g.studente=:idStudente and g.materiale=:idMateriale")
	public Integer getGiaVotato(@Param("idStudente") Studente studente,@Param("idMateriale") Materiale idMateriale);

    @Query("select voto from Gradimento as g where g.studente=:idStudente and g.lezione=:idLezione")
	public Integer getGiaVotatoLezione(@Param("idStudente") Studente studente,@Param("idLezione") Lezione idLezione);

}
