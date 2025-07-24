 package ma.sofisoft.cam2020ws.entity;
 
 import java.io.Serializable;
 import javax.persistence.Column;
 import javax.persistence.Embeddable;
 
 
 
 
 @Embeddable
 public class CfgUtilisateurId
   implements Serializable
 {
   private long numUtilisateur;
   private long numMagasin;
   
   public CfgUtilisateurId() {}
   
   public CfgUtilisateurId(long numUtilisateur, long numMagasin) {
     this.numUtilisateur = numUtilisateur;
   this.numMagasin = numMagasin;
   }
   
   @Column(name = "NUM_UTILISATEUR", nullable = false, precision = 10, scale = 0)
   public long getNumUtilisateur() {
/* 26 */     return this.numUtilisateur;
   }
   
   public void setNumUtilisateur(long numUtilisateur) {
/* 30 */     this.numUtilisateur = numUtilisateur;
   }
   
   @Column(name = "NUM_MAGASIN", nullable = false, precision = 10, scale = 0)
   public long getNumMagasin() {
/* 35 */     return this.numMagasin;
   }
   
   public void setNumMagasin(long numMagasin) {
/* 39 */     this.numMagasin = numMagasin;
   }
   
   public boolean equals(Object other) {
   if (this == other)

       return true;
   if (other == null)
    return false;
   if (!(other instanceof ma.sofisoft.cam2020ws.entity.CfgUtilisateurId))
    return false;
    ma.sofisoft.cam2020ws.entity.CfgUtilisateurId castOther = (ma.sofisoft.cam2020ws.entity.CfgUtilisateurId)other;
     
    return (getNumUtilisateur() == castOther.getNumUtilisateur() &&
     getNumMagasin() == castOther.getNumMagasin());
   }
   
   public int hashCode() {
    int result = 17;
     
    result = 37 * result + (int)getNumUtilisateur();
    result = 37 * result + (int)getNumMagasin();
    return result;
   }
 }

