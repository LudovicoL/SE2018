package it.unisalento.se.saw.domain;
// Generated 26-ago-2018 11.39.47 by Hibernate Tools 5.2.0.Final


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Docente generated by hbm2java
 */
@Entity
@Table(name="docente"
    ,catalog="mydb"
)
public class Docente  implements java.io.Serializable {


     private Integer idDocente;
     private Utente utente;
     private Integer stipendio;
     private Set<Materiale> materiales = new HashSet<Materiale>(0);
     private Set<Segnalazione> segnalaziones = new HashSet<Segnalazione>(0);
     private Set<Insegnamento> insegnamentos = new HashSet<Insegnamento>(0);

    public Docente() {
    }

	
    public Docente(Utente utente) {
        this.utente = utente;
    }
    public Docente(Utente utente, Integer stipendio, Set<Materiale> materiales, Set<Segnalazione> segnalaziones, Set<Insegnamento> insegnamentos) {
       this.utente = utente;
       this.stipendio = stipendio;
       this.materiales = materiales;
       this.segnalaziones = segnalaziones;
       this.insegnamentos = insegnamentos;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idDocente", unique=true, nullable=false)
    public Integer getIdDocente() {
        return this.idDocente;
    }
    
    public void setIdDocente(Integer idDocente) {
        this.idDocente = idDocente;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Utente_idUtente", nullable=false)
    public Utente getUtente() {
        return this.utente;
    }
    
    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    
    @Column(name="stipendio")
    public Integer getStipendio() {
        return this.stipendio;
    }
    
    public void setStipendio(Integer stipendio) {
        this.stipendio = stipendio;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="docente")
    public Set<Materiale> getMateriales() {
        return this.materiales;
    }
    
    public void setMateriales(Set<Materiale> materiales) {
        this.materiales = materiales;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="docente")
    public Set<Segnalazione> getSegnalaziones() {
        return this.segnalaziones;
    }
    
    public void setSegnalaziones(Set<Segnalazione> segnalaziones) {
        this.segnalaziones = segnalaziones;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="docente_has_insegnamento", catalog="mydb", joinColumns = { 
        @JoinColumn(name="Docente_idDocente", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="Insegnamento_idInsegnamento", nullable=false, updatable=false) })
    public Set<Insegnamento> getInsegnamentos() {
        return this.insegnamentos;
    }
    
    public void setInsegnamentos(Set<Insegnamento> insegnamentos) {
        this.insegnamentos = insegnamentos;
    }




}


