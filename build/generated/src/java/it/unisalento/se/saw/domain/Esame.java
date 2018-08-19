package it.unisalento.se.saw.domain;
// Generated 19-ago-2018 9.45.50 by Hibernate Tools 5.2.0.Final


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
     private Date data;
     private String tipo;

    public Esame() {
    }

	
    public Esame(Aula aula, Insegnamento insegnamento) {
        this.aula = aula;
        this.insegnamento = insegnamento;
    }
    public Esame(Aula aula, Insegnamento insegnamento, Date data, String tipo) {
       this.aula = aula;
       this.insegnamento = insegnamento;
       this.data = data;
       this.tipo = tipo;
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
    @Column(name="data", length=19)
    public Date getData() {
        return this.data;
    }
    
    public void setData(Date data) {
        this.data = data;
    }

    
    @Column(name="tipo", length=45)
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }




}


