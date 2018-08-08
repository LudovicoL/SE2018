package it.unisalento.se.saw.domain;
// Generated 25-lug-2018 12.51.01 by Hibernate Tools 5.2.0.Final


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * StudenteHasEsameId generated by hbm2java
 */
@Embeddable
public class StudenteHasEsameId  implements java.io.Serializable {


     private int studenteIdStudente;
     private int esameIdEsame;

    public StudenteHasEsameId() {
    }

    public StudenteHasEsameId(int studenteIdStudente, int esameIdEsame) {
       this.studenteIdStudente = studenteIdStudente;
       this.esameIdEsame = esameIdEsame;
    }
   


    @Column(name="Studente_idStudente", nullable=false)
    public int getStudenteIdStudente() {
        return this.studenteIdStudente;
    }
    
    public void setStudenteIdStudente(int studenteIdStudente) {
        this.studenteIdStudente = studenteIdStudente;
    }


    @Column(name="Esame_idEsame", nullable=false)
    public int getEsameIdEsame() {
        return this.esameIdEsame;
    }
    
    public void setEsameIdEsame(int esameIdEsame) {
        this.esameIdEsame = esameIdEsame;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof StudenteHasEsameId) ) return false;
		 StudenteHasEsameId castOther = ( StudenteHasEsameId ) other; 
         
		 return (this.getStudenteIdStudente()==castOther.getStudenteIdStudente())
 && (this.getEsameIdEsame()==castOther.getEsameIdEsame());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getStudenteIdStudente();
         result = 37 * result + this.getEsameIdEsame();
         return result;
   }   


}


