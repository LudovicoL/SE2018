package it.unisalento.se.saw.domain;
// Generated 15-gen-2019 11.20.57 by Hibernate Tools 5.2.0.Final


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Corso generated by hbm2java
 */
@Entity
@Table(name="corso"
    ,catalog="mydb"
)
public class Corso  implements java.io.Serializable {


     private Integer idCorso;
     private String nome;
     private String facolta;
     private Integer durata;
     private String livello;
     private int abilitazione;
     private Set<Insegnamento> insegnamentos = new HashSet<Insegnamento>(0);
     private Set<Studente> studentes = new HashSet<Studente>(0);

    public Corso() {
    }

	
    public Corso(int abilitazione) {
        this.abilitazione = abilitazione;
    }
    public Corso(String nome, String facolta, Integer durata, String livello, int abilitazione, Set<Insegnamento> insegnamentos, Set<Studente> studentes) {
       this.nome = nome;
       this.facolta = facolta;
       this.durata = durata;
       this.livello = livello;
       this.abilitazione = abilitazione;
       this.insegnamentos = insegnamentos;
       this.studentes = studentes;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idCorso", unique=true, nullable=false)
    public Integer getIdCorso() {
        return this.idCorso;
    }
    
    public void setIdCorso(Integer idCorso) {
        this.idCorso = idCorso;
    }

    
    @Column(name="nome", length=45)
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    @Column(name="facolta", length=45)
    public String getFacolta() {
        return this.facolta;
    }
    
    public void setFacolta(String facolta) {
        this.facolta = facolta;
    }

    
    @Column(name="durata")
    public Integer getDurata() {
        return this.durata;
    }
    
    public void setDurata(Integer durata) {
        this.durata = durata;
    }

    
    @Column(name="livello", length=45)
    public String getLivello() {
        return this.livello;
    }
    
    public void setLivello(String livello) {
        this.livello = livello;
    }

    
    @Column(name="abilitazione", nullable=false)
    public int getAbilitazione() {
        return this.abilitazione;
    }
    
    public void setAbilitazione(int abilitazione) {
        this.abilitazione = abilitazione;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="corso")
    public Set<Insegnamento> getInsegnamentos() {
        return this.insegnamentos;
    }
    
    public void setInsegnamentos(Set<Insegnamento> insegnamentos) {
        this.insegnamentos = insegnamentos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="corso")
    public Set<Studente> getStudentes() {
        return this.studentes;
    }
    
    public void setStudentes(Set<Studente> studentes) {
        this.studentes = studentes;
    }




}

