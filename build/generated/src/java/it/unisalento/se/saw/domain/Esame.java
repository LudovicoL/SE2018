package it.unisalento.se.saw.domain;
// Generated 28-ott-2018 8.13.23 by Hibernate Tools 5.2.0.Final


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Esame generated by hbm2java
 */
@Entity
@Table(name="esame"
    ,catalog="mydb"
)
public class Esame  implements java.io.Serializable {


     private Integer idEsame;
     private Aula aula;
     private Insegnamento insegnamento;
     private Date datainizio;
     private String tipo;
     private int abilitazione;
     private Date datafine;

    public Esame() {
    }

	
    public Esame(Aula aula, Insegnamento insegnamento, int abilitazione) {
        this.aula = aula;
        this.insegnamento = insegnamento;
        this.abilitazione = abilitazione;
    }
    public Esame(Aula aula, Insegnamento insegnamento, Date datainizio, String tipo, int abilitazione, Date datafine) {
       this.aula = aula;
       this.insegnamento = insegnamento;
       this.datainizio = datainizio;
       this.tipo = tipo;
       this.abilitazione = abilitazione;
       this.datafine = datafine;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idEsame", unique=true, nullable=false)
    public Integer getIdEsame() {
        return this.idEsame;
    }
    
    public void setIdEsame(Integer idEsame) {
        this.idEsame = idEsame;
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

    
    @Column(name="tipo", length=45)
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
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




}


