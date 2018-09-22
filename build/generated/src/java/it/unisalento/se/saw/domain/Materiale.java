package it.unisalento.se.saw.domain;
// Generated 22-set-2018 13.19.06 by Hibernate Tools 5.2.0.Final


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Materiale generated by hbm2java
 */
@Entity
@Table(name="materiale"
    ,catalog="mydb"
)
public class Materiale  implements java.io.Serializable {


     private Integer idMateriale;
     private Docente docente;
     private Lezione lezione;
     private String descrizione;
     private String percorso;
     private int abilitazione;
     private Set<Gradimento> gradimentos = new HashSet<Gradimento>(0);

    public Materiale() {
    }

	
    public Materiale(Docente docente, Lezione lezione, int abilitazione) {
        this.docente = docente;
        this.lezione = lezione;
        this.abilitazione = abilitazione;
    }
    public Materiale(Docente docente, Lezione lezione, String descrizione, String percorso, int abilitazione, Set<Gradimento> gradimentos) {
       this.docente = docente;
       this.lezione = lezione;
       this.descrizione = descrizione;
       this.percorso = percorso;
       this.abilitazione = abilitazione;
       this.gradimentos = gradimentos;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idMateriale", unique=true, nullable=false)
    public Integer getIdMateriale() {
        return this.idMateriale;
    }
    
    public void setIdMateriale(Integer idMateriale) {
        this.idMateriale = idMateriale;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Docente_idDocente", nullable=false)
    public Docente getDocente() {
        return this.docente;
    }
    
    public void setDocente(Docente docente) {
        this.docente = docente;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Lezione_idLezione", nullable=false)
    public Lezione getLezione() {
        return this.lezione;
    }
    
    public void setLezione(Lezione lezione) {
        this.lezione = lezione;
    }

    
    @Column(name="descrizione", length=128)
    public String getDescrizione() {
        return this.descrizione;
    }
    
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    
    @Column(name="percorso", length=128)
    public String getPercorso() {
        return this.percorso;
    }
    
    public void setPercorso(String percorso) {
        this.percorso = percorso;
    }

    
    @Column(name="abilitazione", nullable=false)
    public int getAbilitazione() {
        return this.abilitazione;
    }
    
    public void setAbilitazione(int abilitazione) {
        this.abilitazione = abilitazione;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="materiale")
    public Set<Gradimento> getGradimentos() {
        return this.gradimentos;
    }
    
    public void setGradimentos(Set<Gradimento> gradimentos) {
        this.gradimentos = gradimentos;
    }




}


