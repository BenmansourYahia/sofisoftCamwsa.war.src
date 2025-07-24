 package ma.sofisoft.cam2020ws.entity;
 
 import java.io.Serializable;
 import javax.persistence.Embeddable;
 
 @Embeddable
 public class ParametreId implements Serializable {
   private String module;
   private String parametre;
   
   public String getModule() {
/* 12 */     return this.module;
   }
   
   public void setModule(String module) {
/* 16 */     this.module = module;
   }
   
   public String getParametre() {
/* 20 */     return this.parametre;
   }
   
   public void setParametre(String parametre) {
/* 24 */     this.parametre = parametre;
   }
   
   public boolean equals(Object other) {
     if (this == other)
     return true;
   if (other == null)
       return false;
    if (!(other instanceof ma.sofisoft.cam2020ws.entity.LineVenteDirectId))
      return false;
    ma.sofisoft.cam2020ws.entity.ParametreId castOther = (ma.sofisoft.cam2020ws.entity.ParametreId)other;
     
    return (getParametre().equals(castOther.getParametre()) &&
       getModule() == castOther.getModule());
   }
   
   public int hashCode() {
    int result = 17;
     
     result = 37 * result + this.parametre.hashCode();
     result = 37 * result + this.module.hashCode();
    return result;
   }
 }

