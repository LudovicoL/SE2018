package it.unisalento.se.saw.domain;
// Generated 14-set-2018 11.53.13 by Hibernate Tools 5.2.0.Final


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
 * Strumento generated by hbm2java
 */
@Entity
@Table(name="strumento"
    ,catalog="mydb"
)
public class Strumento  implements java.io.Serializable {


     private Integer idStrumenti;
     private Aula aula;
     private String nome;
     private Integer funzionante;
     private int abilitazione;
     private Set<Segnalazione> segnalaziones = new HashSet<Segnalazione>(0);

    public Strumento() {
    }

	
    public Strumento(Aula aula, int abilitazione) {
        this.aula = aula;
        this.abilitazione = abilitazione;
    }
    public Strumento(Aula aula, String nome, Integer funzionante, int abilitazione, Set<Segnalazione> segnalaziones) {
       this.aula = aula;
       this.nome = nome;
       this.funzionante = funzionante;
       this.abilitazione = abilitazione;
       this.segnalaziones = segnalaziones;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idStrumenti", unique=true, nullable=false)
    public Integer getIdStrumenti() {
        return this.idStrumenti;
    }
    
    public void setIdStrumenti(Integer idStrumenti) {
        this.idStrumenti = idStrumenti;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Aula_idAula", nullable=false)
    public Aula getAula() {
        return this.aula;
    }
    
    public void setAula(Aula aula) {
        this.aula = aula;
    }

    
    @Column(name="nome", length=45)
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    @Column(name="funzionante")
    public Integer getFunzionante() {
        return this.funzionante;
    }
    
    public void setFunzionante(Integer funzionante) {
        this.funzionante = funzionante;
    }

    
    @Column(name="abilitazione", nullable=false)
    public int getAbilitazione() {
        return this.abilitazione;
    }
    
    public void setAbilitazione(int abilitazione) {
        this.abilitazione = abilitazione;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="strumento")
    public Set<Segnalazione> getSegnalaziones() {
        return this.segnalaziones;
    }
    
    public void setSegnalaziones(Set<Segnalazione> segnalaziones) {
        this.segnalaziones = segnalaziones;
    }




}


