package it.unisalento.se.saw.adapter;
import it.unisalento.se.saw.domain.Docente;
import it.unisalento.se.saw.domain.Lezione;
import it.unisalento.se.saw.domain.Materiale;
import it.unisalento.se.saw.dto.MaterialeDTO;

public class MaterialeAdapter {
	public static Materiale MaterialeDTOToMateriale(MaterialeDTO materialeDTO,Docente docente, Lezione lezione) {
		Materiale materiale=new Materiale();
		materiale.setPercorso(materialeDTO.getPercorso());
		materiale.setDescrizione(materialeDTO.getDescrizione());
		materiale.setDocente(docente);
		materiale.setLezione(lezione);
		return materiale;
	}
	
	public static MaterialeDTO MaterialeToMaterialeDTO(Materiale materiale) {
		MaterialeDTO materialeDTO=new MaterialeDTO();
		materialeDTO.setDescrizione(materiale.getDescrizione());
		materialeDTO.setPercorso(materiale.getPercorso());
		materialeDTO.setData(materiale.getLezione().getDatainizio());
		return materialeDTO;
	}
	

}
