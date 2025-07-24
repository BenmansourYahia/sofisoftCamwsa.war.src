 package ma.sofisoft.cam2020ws.entity;
 
 import java.io.Serializable;
 import javax.persistence.Column;
 import javax.persistence.Embeddable;
 
 
 
 
 @Embeddable
 public class StkVenteDirecteId
   implements Serializable
 {
   private int numMvt;
   private long numMagasin;
   
   public StkVenteDirecteId() {}
   
   public StkVenteDirecteId(int numMvt, long numMagasin) {
    this.numMvt = numMvt;
    this.numMagasin = numMagasin;
   }
   
   @Column(name = "NUM_MVT", nullable = false)
   public int getNumMvt() {
/* 26 */     return this.numMvt;
   }
   
   public void setNumMvt(int numMvt) {
/* 30 */     this.numMvt = numMvt;
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
  if (!(other instanceof ma.sofisoft.cam2020ws.entity.StkVenteDirecteId))
    return false;
    ma.sofisoft.cam2020ws.entity.StkVenteDirecteId castOther = (ma.sofisoft.cam2020ws.entity.StkVenteDirecteId)other;
     
     return (getNumMvt() == castOther.getNumMvt() && getNumMagasin() == castOther.getNumMagasin());
   }
   
   public int hashCode() {
    int result = 17;
     
  result = 37 * result + getNumMvt();
     result = 37 * result + (int)getNumMagasin();
    return result;
   }
 }

