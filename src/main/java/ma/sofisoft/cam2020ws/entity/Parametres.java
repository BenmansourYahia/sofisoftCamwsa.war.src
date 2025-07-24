 package ma.sofisoft.cam2020ws.entity;
 
 import javax.persistence.AttributeOverride;
 import javax.persistence.AttributeOverrides;
 import javax.persistence.Column;
 import javax.persistence.EmbeddedId;
 import javax.persistence.Entity;
 import javax.persistence.Table;
 import ma.sofisoft.cam2020ws.entity.ParametreId;
 
 
 
 
 
 
 
 
 
 @Entity
 @Table(name = "parametres")
 public class Parametres
 {
   @EmbeddedId
   @AttributeOverrides({@AttributeOverride(name = "module", column = @Column(name = "module", nullable = false, precision = 10, scale = 0)), @AttributeOverride(name = "parametre", column = @Column(name = "parametre", nullable = false, precision = 10, scale = 0))})
   private ParametreId id;
   @Column(name = "valeur")
   private String valeur;
   @Column(name = "types")
   private Integer types;
   
   public ParametreId getId() {
/* 32 */     return this.id;
   }
   
   public void setId(ParametreId id) {
/* 36 */     this.id = id;
   }
   
   public String getValeur() {
/* 40 */     return this.valeur;
   }
   
   public void setValeur(String valeur) {
/* 44 */     this.valeur = valeur;
   }
   
   public Integer getType() {
/* 48 */     return this.types;
   }
   
   public void setType(Integer type) {
/* 52 */     this.types = type;
   }
 }

