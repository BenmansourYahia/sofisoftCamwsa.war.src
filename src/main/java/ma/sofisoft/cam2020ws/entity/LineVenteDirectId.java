 package ma.sofisoft.cam2020ws.entity;
 
 import java.io.Serializable;
 import javax.persistence.Column;
 import javax.persistence.Embeddable;
 
 
 
 
 @Embeddable
 public class LineVenteDirectId
   implements Serializable
 {
   private int numLigneMouvement;
   private int numMagasin;
   
   public LineVenteDirectId() {}
   
   public LineVenteDirectId(int numLigneMouvement, int numMagasin) {
    this.numLigneMouvement = numLigneMouvement;
    this.numMagasin = numMagasin;
   }
   
   @Column(name = "NUM_LIGNE_MOUVEMENT", nullable = false)
   public int getNumLigneMouvement() {
/* 26 */     return this.numLigneMouvement;
   }
   
   public void setNumLigneMouvement(int numLigneMouvement) {
/* 30 */     this.numLigneMouvement = numLigneMouvement;
   }
   
   @Column(name = "NUM_MAGASIN", nullable = false)
   public int getNumMagasin() {
/* 35 */     return this.numMagasin;
   }
   
   public void setNumMagasin(int numMagasin) {
/* 39 */     this.numMagasin = numMagasin;
   }
   
   public boolean equals(Object other) {
    if (this == other)
     return true;
   if (other == null)
      return false;
   if (!(other instanceof ma.sofisoft.cam2020ws.entity.LineVenteDirectId))
      return false;
    ma.sofisoft.cam2020ws.entity.LineVenteDirectId castOther = (ma.sofisoft.cam2020ws.entity.LineVenteDirectId)other;
     
    return (getNumLigneMouvement() == castOther.getNumLigneMouvement() &&
      getNumMagasin() == castOther.getNumMagasin());
   }
   
   public int hashCode() {
    int result = 17;
     
     result = 37 * result + getNumLigneMouvement();
   result = 37 * result + getNumMagasin();
     return result;
   }
 }

