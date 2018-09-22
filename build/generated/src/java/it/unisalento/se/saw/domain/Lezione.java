package it.unisalento.se.saw.domain;
// Generated 22-set-2018 13.19.06 by Hibernate Tools 5.2.0.Final


import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Lezione generated by hbm2java
 */
@Entity
@Table(name="lezione"
    ,catalog="mydb"
)
public class Lezione  implements java.io.Serializable {


     private Integer idLezione;
     private Aula aula;
     private Insegnamento insegnamento;
     private Date datainizio;
     private int abilitazione;
     private Date datafine;
     private Set<Gradimento> gradimentos = new HashSet<Gradimento>(0);
     private Set<Materiale> materiales = new HashSet<Materiale>(0);

    public Lezione() {
    }

	
    public Lezione(Aula aula, Insegnamento insegnamento, int abilitazione) {
        this.aula = aula;
        this.insegnamento = insegnamento;
        this.abilitazione = abilitazione;
    }
    public Lezione(Aula aula, Insegnamento insegnamento, Date datainizio, int abilitazione, Date datafine, Set<Gradimento> gradimentos, Set<Materiale> materiales) {
       this.aula = aula;
       this.insegnamento = insegnamento;
       this.datainizio = datainizio;
       this.abilitazione = abilitazione;
       this.datafine = datafine;
       this.gradimentos = gradimentos;
       this.materiales = materiales;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idLezione", unique=true, nullable=false)
    public Integer getIdLezione() {
        return this.idLezione;
    }
    
    public void setIdLezione(Integer idLezione) {
        this.idLezione = idLezione;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Aula_idAula", nullable=false)
    public Aula getAula() {
        return this.aula;
    }
    
    public void setAula(Aula aula) {
        this.aula = aula;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Insegnamento_idInsegnamento", nullable=false)
    public Insegnamento getInsegnamento() {
        return this.insegnamento;
    }
    
    public void setInsegnamento(Insegnamento insegnamento) {
        this.insegnamento = insegnamento;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="datainizio", length=19)
    public Date getDatainizio() {
        return this.datainizio;
    }
    
    public void setDatainizio(Date datainizio) {
        this.datainizio = datainizio;
    }

    
    @Column(name="abilitazione", nullable=false)
    public int getAbilitazione() {
        return this.abilitazione;
    }
    
    public void setAbilitazione(int abilitazione) {
        this.abilitazione = abilitazione;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="datafine", length=19)
    public Date getDatafine() {
        return this.datafine;
    }
    
    public void setDatafine(Date datafine) {
        this.datafine = datafine;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="lezione")
    public Set<Gradimento> getGradimentos() {
        return this.gradimentos;
    }
    
    public void setGradimentos(Set<Gradimento> gradimentos) {
        this.gradimentos = gradimentos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="lezione")
    public Set<Materiale> getMateriales() {
        return this.materiales;
    }
    
    public void setMateriales(Set<Materiale> materiales) {
        this.materiales = materiales;
    }




}


