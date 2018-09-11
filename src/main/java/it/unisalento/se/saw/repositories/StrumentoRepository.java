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
	@Query("update Strumento s set s.nome=:nome, s.agibile=:agibile, s.Aula_idAula=:Aula_idAula where s.idStrumento=:idStrumento")
	public void update(@Param("nome") String nome, @Param("agibile") int agibile, @Param("Aula_idAula") int Aula_idAula, @Param("idStrumento") int idStrumento);

}
