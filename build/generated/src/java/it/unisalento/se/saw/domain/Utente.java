package it.unisalento.se.saw.domain;
// Generated 15-gen-2019 11.20.57 by Hibernate Tools 5.2.0.Final


import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Utente generated by hbm2java
 */
@Entity
@Table(name="utente"
    ,catalog="mydb"
)
public class Utente  implements java.io.Serializable {


     private Integer idUtente;
     private String nome;
     private String cognome;
     private Date datanascita;
     private String indirizzo;
     private String email;
     private String password;
     private int abilitazione;
     private Set<Studente> studentes = new HashSet<Studente>(0);
     private Set<Segreteria> segreterias = new HashSet<Segreteria>(0);
     private Set<Docente> docentes = new HashSet<Docente>(0);

    public Utente() {
    }

	
    public Utente(int abilitazione) {
        this.abilitazione = abilitazione;
    }
    public Utente(String nome, String cognome, Date datanascita, String indirizzo, String email, String password, int abilitazione, Set<Studente> studentes, Set<Segreteria> segreterias, Set<Docente> docentes) {
       this.nome = nome;
       this.cognome = cognome;
       this.datanascita = datanascita;
       this.indirizzo = indirizzo;
       this.email = email;
       this.password = password;
       this.abilitazione = abilitazione;
       this.studentes = studentes;
       this.segreterias = segreterias;
       this.docentes = docentes;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idUtente", unique=true, nullable=false)
    public Integer getIdUtente() {
        return this.idUtente;
    }
    
    public void setIdUtente(Integer idUtente) {
        this.idUtente = idUtente;
    }

    
    @Column(name="nome", length=45)
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    @Column(name="cognome", length=45)
    public String getCognome() {
        return this.cognome;
    }
    
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="datanascita", length=10)
    public Date getDatanascita() {
        return this.datanascita;
    }
    
    public void setDatanascita(Date datanascita) {
        this.datanascita = datanascita;
    }

    
    @Column(name="indirizzo", length=45)
    public String getIndirizzo() {
        return this.indirizzo;
    }
    
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    
    @Column(name="email", length=45)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="password", length=64)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="abilitazione", nullable=false)
    public int getAbilitazione() {
        return this.abilitazione;
    }
    
    public void setAbilitazione(int abilitazione) {
        this.abilitazione = abilitazione;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="utente")
    public Set<Studente> getStudentes() {
        return this.studentes;
    }
    
    public void setStudentes(Set<Studente> studentes) {
        this.studentes = studentes;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="utente")
    public Set<Segreteria> getSegreterias() {
        return this.segreterias;
    }
    
    public void setSegreterias(Set<Segreteria> segreterias) {
        this.segreterias = segreterias;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="utente")
    public Set<Docente> getDocentes() {
        return this.docentes;
    }
    
    public void setDocentes(Set<Docente> docentes) {
        this.docentes = docentes;
    }




}

