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
 * Aula generated by hbm2java
 */
@Entity
@Table(name="aula"
    ,catalog="mydb"
)
public class Aula  implements java.io.Serializable {


     private Integer idAula;
     private String nome;
     private String grandezza;
     private Double latitudine;
     private Double longitudine;
     private int abilitazione;
     private Set<Esame> esames = new HashSet<Esame>(0);
     private Set<Segnalazione> segnalaziones = new HashSet<Segnalazione>(0);
     private Set<Lezione> leziones = new HashSet<Lezione>(0);
     private Set<Strumento> strumentos = new HashSet<Strumento>(0);

    public Aula() {
    }

	
    public Aula(int abilitazione) {
        this.abilitazione = abilitazione;
    }
    public Aula(String nome, String grandezza, Double latitudine, Double longitudine, int abilitazione, Set<Esame> esames, Set<Segnalazione> segnalaziones, Set<Lezione> leziones, Set<Strumento> strumentos) {
       this.nome = nome;
       this.grandezza = grandezza;
       this.latitudine = latitudine;
       this.longitudine = longitudine;
       this.abilitazione = abilitazione;
       this.esames = esames;
       this.segnalaziones = segnalaziones;
       this.leziones = leziones;
       this.strumentos = strumentos;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idAula", unique=true, nullable=false)
    public Integer getIdAula() {
        return this.idAula;
    }
    
    public void setIdAula(Integer idAula) {
        this.idAula = idAula;
    }

    
    @Column(name="nome", length=45)
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    @Column(name="grandezza", length=45)
    public String getGrandezza() {
        return this.grandezza;
    }
    
    public void setGrandezza(String grandezza) {
        this.grandezza = grandezza;
    }

    
    @Column(name="latitudine", precision=22, scale=0)
    public Double getLatitudine() {
        return this.latitudine;
    }
    
    public void setLatitudine(Double latitudine) {
        this.latitudine = latitudine;
    }

    
    @Column(name="longitudine", precision=22, scale=0)
    public Double getLongitudine() {
        return this.longitudine;
    }
    
    public void setLongitudine(Double longitudine) {
        this.longitudine = longitudine;
    }

    
    @Column(name="abilitazione", nullable=false)
    public int getAbilitazione() {
        return this.abilitazione;
    }
    
    public void setAbilitazione(int abilitazione) {
        this.abilitazione = abilitazione;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="aula")
    public Set<Esame> getEsames() {
        return this.esames;
    }
    
    public void setEsames(Set<Esame> esames) {
        this.esames = esames;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="aula")
    public Set<Segnalazione> getSegnalaziones() {
        return this.segnalaziones;
    }
    
    public void setSegnalaziones(Set<Segnalazione> segnalaziones) {
        this.segnalaziones = segnalaziones;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="aula")
    public Set<Lezione> getLeziones() {
        return this.leziones;
    }
    
    public void setLeziones(Set<Lezione> leziones) {
        this.leziones = leziones;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="aula")
    public Set<Strumento> getStrumentos() {
        return this.strumentos;
    }
    
    public void setStrumentos(Set<Strumento> strumentos) {
        this.strumentos = strumentos;
    }




}


