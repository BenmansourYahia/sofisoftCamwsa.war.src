 package ma.sofisoft.cam2020ws.entity;
 
 import java.util.Date;
 import javax.persistence.Column;
 import javax.persistence.Entity;
 import javax.persistence.Id;
 import javax.persistence.Table;
 import javax.persistence.Transient;
 import ma.sofisoft.cam2020ws.CamController;
 import org.hibernate.annotations.Immutable;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
 
 
 
 
 
 
 @Entity
 @Table(name = "vue_ca_mag_jour_obj")
 @Immutable
 public class VueCaMagJourObj
 {
   @Transient
   Logger logger = LoggerFactory.getLogger(CamController.class);
 
   
   @Column(name = "num_magasin")
   private Integer numMagasin;
   
   @Id
   @Column(name = "code_magasin")
   private String codeMagasin;
   
   @Column(name = "nom_magasin")
   private String nomMagasin;
   
   @Column(name = "montant_ttc")
   private Double montantTTC;
   
   @Column(name = "quantite")
   private Double quantite;
   
   @Column(name = "nbre_ticket")
   private Double nombreTickets;
   
   @Column(name = "jour_vente")
   private Date jourVente;
   
   @Column(name = "Compteur")
   private Double compteur;
   
   @Column(name = "Objectif")
  private Double objectif = Double.valueOf(0.0D);
 
   
  private Double prixMoyen = Double.valueOf(0.0D);
  private Double tauxObjectif = Double.valueOf(0.0D);
  private Double debitMoyen = Double.valueOf(0.0D);
   private Double panierMoyen = Double.valueOf(0.0D);
 
 
 
 
 
 
 
 
   
   public VueCaMagJourObj(Integer numMagasin, String codeMagasin, String nomMagasin, Double montantTTC, Double quantite, Double nombreTickets, Double compteur, Double Objectif) {
     this.numMagasin = numMagasin;
    this.codeMagasin = codeMagasin;
    this.nomMagasin = nomMagasin;
     this.montantTTC = montantTTC;
     this.quantite = quantite;
     this.nombreTickets = nombreTickets;
   this.compteur = compteur;
     
    if (this.quantite != null && this.quantite.doubleValue() != 0.0D) this.prixMoyen = Double.valueOf(this.montantTTC.doubleValue() / this.quantite.doubleValue());
    if (this.nombreTickets != null && this.nombreTickets.doubleValue() != 0.0D) this.debitMoyen = Double.valueOf(this.quantite.doubleValue() / this.nombreTickets.doubleValue());
    if (this.nombreTickets != null && this.nombreTickets.doubleValue() != 0.0D) this.panierMoyen = Double.valueOf(this.montantTTC.doubleValue() / this.nombreTickets.doubleValue());
 
 
 
 
     
     if (Objectif != null && Objectif.doubleValue() == 0.0D && this.montantTTC != null && this.montantTTC.doubleValue() != 0.0D) {
       this.tauxObjectif = Double.valueOf(this.montantTTC.doubleValue() * 100.0D / this.montantTTC.doubleValue());
     } else if (Objectif != null && Objectif.doubleValue() != 0.0D) {
       this.tauxObjectif = Double.valueOf(this.montantTTC.doubleValue() * 100.0D / Objectif.doubleValue());
     } 
   }
 
 
 
 
 
 
 
 
   
   public VueCaMagJourObj(Integer numMagasin, String codeMagasin, String nomMagasin, Double montantTTC, Double quantite, Double nombreTickets) {
   this.numMagasin = numMagasin;
    this.codeMagasin = codeMagasin;
   this.nomMagasin = nomMagasin;
     this.montantTTC = montantTTC;
    this.quantite = quantite;
    this.nombreTickets = nombreTickets;
   }
 
 
 
 
 
 
   
   public VueCaMagJourObj(Date jourVente, Double montantTTC, Double quantite, Double nombreTickets, Double Objectif, Double compteur) {
     this.montantTTC = montantTTC;
     this.quantite = quantite;
    this.nombreTickets = nombreTickets;
     this.jourVente = jourVente;
   this.compteur = compteur;
     
     if (this.quantite != null && this.quantite.doubleValue() != 0.0D) this.prixMoyen = Double.valueOf(this.montantTTC.doubleValue() / this.quantite.doubleValue());
     if (this.nombreTickets != null && this.nombreTickets.doubleValue() != 0.0D) this.debitMoyen = Double.valueOf(this.quantite.doubleValue() / this.nombreTickets.doubleValue());
    if (this.nombreTickets != null && this.nombreTickets.doubleValue() != 0.0D) this.panierMoyen = Double.valueOf(this.montantTTC.doubleValue() / this.nombreTickets.doubleValue());
 
 
 
 
     
    if (Objectif != null && Objectif.doubleValue() == 0.0D && this.montantTTC != null && this.montantTTC.doubleValue() != 0.0D) {
      this.tauxObjectif = Double.valueOf(this.montantTTC.doubleValue() * 100.0D / this.montantTTC.doubleValue());
    } else if (Objectif != null && Objectif.doubleValue() != 0.0D) {
      this.tauxObjectif = Double.valueOf(this.montantTTC.doubleValue() * 100.0D / Objectif.doubleValue());
     } 
   }
 

   
   public VueCaMagJourObj(Double montantTTC, Double quantite, Double nombreTickets, Double Objectif, Double compteur) {
     this.montantTTC = montantTTC;
    this.quantite = quantite;
     this.nombreTickets = nombreTickets;
    this.compteur = compteur;
     
     if (this.quantite != null && this.quantite.doubleValue() != 0.0D) this.prixMoyen = Double.valueOf(this.montantTTC.doubleValue() / this.quantite.doubleValue());
     if (this.nombreTickets != null && this.nombreTickets.doubleValue() != 0.0D) this.debitMoyen = Double.valueOf(this.quantite.doubleValue() / this.nombreTickets.doubleValue());
     if (this.nombreTickets != null && this.nombreTickets.doubleValue() != 0.0D) this.panierMoyen = Double.valueOf(this.montantTTC.doubleValue() / this.nombreTickets.doubleValue());
 
 
 
 
     
     if (Objectif != null && Objectif.doubleValue() == 0.0D && this.montantTTC != null && this.montantTTC.doubleValue() != 0.0D) {
      this.tauxObjectif = Double.valueOf(this.montantTTC.doubleValue() * 100.0D / this.montantTTC.doubleValue());
     } else if (Objectif != null && Objectif.doubleValue() != 0.0D) {
       this.tauxObjectif = Double.valueOf(this.montantTTC.doubleValue() * 100.0D / Objectif.doubleValue());
     } 
   }
 
 
   
   public Double getPrixMoyen() {
/* 176 */     return this.prixMoyen;
   }
   
   public void setPrixMoyen(Double prixMoyen) {
/* 180 */     this.prixMoyen = prixMoyen;
   }
   
   public Double getTauxObjectif() {
/* 184 */     return this.tauxObjectif;
   }
   
   public void setTauxObjectif(Double tauxObjectif) {
/* 188 */     this.tauxObjectif = tauxObjectif;
   }
   
   public Double getDebitMoyen() {
/* 192 */     return this.debitMoyen;
   }
   
   public void setDebitMoyen(Double debitMoyen) {
/* 196 */     this.debitMoyen = debitMoyen;
   }
   
   public Double getPanierMoyen() {
/* 200 */     return this.panierMoyen;
   }
   
   public void setPanierMoyen(Double panierMoyen) {
/* 204 */     this.panierMoyen = panierMoyen;
   }
   
   public String getNomMagasin() {
/* 208 */     return this.nomMagasin;
   }
   public void setNomMagasin(String nomMagasin) {
/* 211 */     this.nomMagasin = nomMagasin;
   }
   
   public Integer getNumMagasin() {
/* 215 */     return this.numMagasin;
   }
   public void setNumMagasin(Integer numMagasin) {
/* 218 */     this.numMagasin = numMagasin;
   }
   
   public String getCodeMagasin() {
/* 222 */     return this.codeMagasin;
   }
   public void setCodeMagasin(String codeMagasin) {
/* 225 */     this.codeMagasin = codeMagasin;
   }
   public Double getMontantTTC() {
/* 228 */     return this.montantTTC;
   }
   public void setMontantTTC(Double montantTTC) {
/* 231 */     this.montantTTC = montantTTC;
   }
   public Date getJourVente() {
/* 234 */     return this.jourVente;
   }
   public void setJourVente(Date jourVente) {
/* 237 */     this.jourVente = jourVente;
   }
   public Double getQuantite() {
/* 240 */     return this.quantite;
   }
   public void setQuantite(Double quantite) {
/* 243 */     this.quantite = quantite;
   }
   public Double getNombreTickets() {
/* 246 */     return this.nombreTickets;
   }
   public void setNombreTickets(Double nombreTickets) {
/* 249 */     this.nombreTickets = nombreTickets;
   }
   
   public Double getCompteur() {
/* 253 */     return this.compteur;
   }
   
   public void setCompteur(Double compteur) {
/* 257 */     this.compteur = compteur;
   }
   
   public Double getObjectif() {
/* 261 */     return this.objectif;
   }
   
   public void setObjectif(Double objectif) {
/* 265 */     this.objectif = objectif;
   }
 }

