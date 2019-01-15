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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Insegnamento generated by hbm2java
 */
@Entity
@Table(name="insegnamento"
    ,catalog="mydb"
)
public class Insegnamento  implements java.io.Serializable {


     private Integer idInsegnamento;
     private Corso corso;
     private Docente docente;
     private String nome;
     private Integer cfu;
     private Integer semestre;
     private Integer anno;
     private int abilitazione;
     private Set<Lezione> leziones = new HashSet<Lezione>(0);
     private Set<Esame> esames = new HashSet<Esame>(0);
     private Set<Libretto> librettos = new HashSet<Libretto>(0);

    public Insegnamento() {
    }

	
    public Insegnamento(Corso corso, Docente docente, int abilitazione) {
        this.corso = corso;
        this.docente = docente;
        this.abilitazione = abilitazione;
    }
    public Insegnamento(Corso corso, Docente docente, String nome, Integer cfu, Integer semestre, Integer anno, int abilitazione, Set<Lezione> leziones, Set<Esame> esames, Set<Libretto> librettos) {
       this.corso = corso;
       this.docente = docente;
       this.nome = nome;
       this.cfu = cfu;
       this.semestre = semestre;
       this.anno = anno;
       this.abilitazione = abilitazione;
       this.leziones = leziones;
       this.esames = esames;
       this.librettos = librettos;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idInsegnamento", unique=true, nullable=false)
    public Integer getIdInsegnamento() {
        return this.idInsegnamento;
    }
    
    public void setIdInsegnamento(Integer idInsegnamento) {
        this.idInsegnamento = idInsegnamento;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Corso_idCorso", nullable=false)
    public Corso getCorso() {
        return this.corso;
    }
    
    public void setCorso(Corso corso) {
        this.corso = corso;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Docente_idDocente", nullable=false)
    public Docente getDocente() {
        return this.docente;
    }
    
    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    
    @Column(name="nome", length=45)
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    @Column(name="cfu")
    public Integer getCfu() {
        return this.cfu;
    }
    
    public void setCfu(Integer cfu) {
        this.cfu = cfu;
    }

    
    @Column(name="semestre")
    public Integer getSemestre() {
        return this.semestre;
    }
    
    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    
    @Column(name="anno")
    public Integer getAnno() {
        return this.anno;
    }
    
    public void setAnno(Integer anno) {
        this.anno = anno;
    }

    
    @Column(name="abilitazione", nullable=false)
    public int getAbilitazione() {
        return this.abilitazione;
    }
    
    public void setAbilitazione(int abilitazione) {
        this.abilitazione = abilitazione;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="insegnamento")
    public Set<Lezione> getLeziones() {
        return this.leziones;
    }
    
    public void setLeziones(Set<Lezione> leziones) {
        this.leziones = leziones;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="insegnamento")
    public Set<Esame> getEsames() {
        return this.esames;
    }
    
    public void setEsames(Set<Esame> esames) {
        this.esames = esames;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="insegnamento")
    public Set<Libretto> getLibrettos() {
        return this.librettos;
    }
    
    public void setLibrettos(Set<Libretto> librettos) {
        this.librettos = librettos;
    }




}

