package it.unisalento.se.saw.domain;
// Generated 15-gen-2019 11.20.57 by Hibernate Tools 5.2.0.Final


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
 * Gradimento generated by hbm2java
 */
@Entity
@Table(name="gradimento"
    ,catalog="mydb"
)
public class Gradimento  implements java.io.Serializable {


     private Integer idGradimento;
     private Lezione lezione;
     private Materiale materiale;
     private Studente studente;
     private Integer voto;
     private int abilitazione;
     private String nota;

    public Gradimento() {
    }

	
    public Gradimento(Studente studente, int abilitazione) {
        this.studente = studente;
        this.abilitazione = abilitazione;
    }
    public Gradimento(Lezione lezione, Materiale materiale, Studente studente, Integer voto, int abilitazione, String nota) {
       this.lezione = lezione;
       this.materiale = materiale;
       this.studente = studente;
       this.voto = voto;
       this.abilitazione = abilitazione;
       this.nota = nota;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idGradimento", unique=true, nullable=false)
    public Integer getIdGradimento() {
        return this.idGradimento;
    }
    
    public void setIdGradimento(Integer idGradimento) {
        this.idGradimento = idGradimento;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Lezione_idLezione")
    public Lezione getLezione() {
        return this.lezione;
    }
    
    public void setLezione(Lezione lezione) {
        this.lezione = lezione;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Materiale_idMateriale")
    public Materiale getMateriale() {
        return this.materiale;
    }
    
    public void setMateriale(Materiale materiale) {
        this.materiale = materiale;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Studente_idStudente", nullable=false)
    public Studente getStudente() {
        return this.studente;
    }
    
    public void setStudente(Studente studente) {
        this.studente = studente;
    }

    
    @Column(name="voto")
    public Integer getVoto() {
        return this.voto;
    }
    
    public void setVoto(Integer voto) {
        this.voto = voto;
    }

    
    @Column(name="abilitazione", nullable=false)
    public int getAbilitazione() {
        return this.abilitazione;
    }
    
    public void setAbilitazione(int abilitazione) {
        this.abilitazione = abilitazione;
    }

    
    @Column(name="nota", length=45)
    public String getNota() {
        return this.nota;
    }
    
    public void setNota(String nota) {
        this.nota = nota;
    }




}

