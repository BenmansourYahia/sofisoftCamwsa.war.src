 package ma.sofisoft.cam2020ws.entity;
 
 import java.io.Serializable;
 import java.util.Date;
 import javax.persistence.Column;
 import javax.persistence.Embeddable;
 
 
 @Embeddable
 public class VuePrdsId
   implements Serializable
 {
   @Column(name = "code_produit_dims")
   private String codeProduitDims;
   @Column(name = "designation")
   private String designation;
   @Column(name = "date_Mvt")
   private Date date;
   
   public String getCodeProduit() {
/* 21 */     return this.codeProduitDims;
   }
   
   public void setCodeProduit(String codeProduit) {
/* 25 */     this.codeProduitDims = codeProduit;
   }
   
   public String getDesignation() {
/* 29 */     return this.designation;
   }
   
   public void setDesignation(String designation) {
/* 33 */     this.designation = designation;
   }
   
   public Date getDate() {
/* 37 */     return this.date;
   }
   
   public void setDate(Date date) {
/* 41 */     this.date = date;
   }
   
   public boolean equals(Object other) {
    if (this == other)
     return true;
    if (other == null)
     return false;
     if (!(other instanceof ma.sofisoft.cam2020ws.entity.StkVenteDirecteId))
     return false;
     ma.sofisoft.cam2020ws.entity.VuePrdsId castOther = (ma.sofisoft.cam2020ws.entity.VuePrdsId)other;
     
    return (getCodeProduit().equals(castOther.getCodeProduit()) &&
      getDesignation().equals(castOther.getDesignation()) &&
       getDate().compareTo(castOther.getDate()) == 0);
   }
   
   public int hashCode() {
     int result = 17;
     
    result = 37 * result + getCodeProduit().hashCode();
    result = 37 * result + getDesignation().hashCode();
    result = 37 * result + getDate().hashCode();
    return result;
   }
 }

