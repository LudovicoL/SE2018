package it.unisalento.se.saw.domain;
// Generated 19-ago-2018 9.45.50 by Hibernate Tools 5.2.0.Final


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Segnalazione generated by hbm2java
 */
@Entity
@Table(name="segnalazione"
    ,catalog="mydb"
)
public class Segnalazione  implements java.io.Serializable {


     private Integer idSegnalazione;
     private Aula aula;
     private Docente docente;
     private Segreteria segreteria;
     private Strumento strumento;
     private String descrizione;

    public Segnalazione() {
    }

	
    public Segnalazione(Docente docente) {
        this.docente = docente;
    }
    public Segnalazione(Aula aula, Docente docente, Segreteria segreteria, Strumento strumento, String descrizione) {
       this.aula = aula;
       this.docente = docente;
       this.segreteria = segreteria;
       this.strumento = strumento;
       this.descrizione = descrizione;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idSegnalazione", unique=true, nullable=false)
    public Integer getIdSegnalazione() {
        return this.idSegnalazione;
    }
    
    public void setIdSegnalazione(Integer idSegnalazione) {
        this.idSegnalazione = idSegnalazione;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Aula_idAula")
    public Aula getAula() {
        return this.aula;
    }
    
    public void setAula(Aula aula) {
        this.aula = aula;
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
    @JoinColumn(name="Segreteria_idSegreteria")
    public Segreteria getSegreteria() {
        return this.segreteria;
    }
    
    public void setSegreteria(Segreteria segreteria) {
        this.segreteria = segreteria;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Strumento_idStrumenti")
    public Strumento getStrumento() {
        return this.strumento;
    }
    
    public void setStrumento(Strumento strumento) {
        this.strumento = strumento;
    }

    
    @Column(name="descrizione")
    public String getDescrizione() {
        return this.descrizione;
    }
    
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }




}


