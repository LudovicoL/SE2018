package it.unisalento.se.saw.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import it.unisalento.se.saw.domain.Corso;
import it.unisalento.se.saw.domain.Docente;
import it.unisalento.se.saw.domain.Insegnamento;
import it.unisalento.se.saw.domain.Studente;

public interface InsegnamentoRepository extends JpaRepository<Insegnamento, Integer>{

	@Modifying
	@Transactional
	@Query("update Insegnamento i set i.cfu=:cfu, i.semestre=:semestre, i.anno=:anno where i.idInsegnamento=:idInsegnamento")
	public void update(@Param("cfu") int cfu, @Param("semestre") int semestre, @Param("anno") int anno, @Param("idInsegnamento") int idInsegnamento);

    @Modifying
    @Transactional
	@Query("update Insegnamento i set i.abilitazione=:abilitazione where i.idInsegnamento=:idInsegnamento")
	public void updateabilitazione(@Param("abilitazione") int abilitazione, @Param("idInsegnamento") int idInsegnamento);

    @Query("select i from Insegnamento i where i.corso=:idCorso")
	public List<Insegnamento> listainsegnamentibycorso(@Param("idCorso") Corso corso);

    @Query("select i from Insegnamento i where i.docente=:idDocente")
	public List<Insegnamento> listainsegnamentibydocente(@Param("idDocente") Docente docente);

    @Query("select i from Insegnamento i where i.corso=:idCorso")
	public List<Insegnamento> listainsegnamentibystudente(@Param("idCorso")Corso corso);
    
    @Query("select distinct i.docente from Insegnamento i where i.corso=:idCorso")
	public List<Docente> listainsegnamentibycorsoDistinct(@Param("idCorso") Corso corso);


}
