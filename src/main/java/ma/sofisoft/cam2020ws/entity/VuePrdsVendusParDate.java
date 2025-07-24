 package ma.sofisoft.cam2020ws.entity;
 
 import java.util.Date;
 import javax.persistence.Column;
 import javax.persistence.EmbeddedId;
 import javax.persistence.Entity;
 import javax.persistence.Table;
 import ma.sofisoft.cam2020ws.entity.VuePrdsId;
 import org.hibernate.annotations.Immutable;
 
 
 
 
 
 
 
 
 
 
 
 
 
 @Entity
 @Table(name = "vue_prds_vendus_par_date")
 @Immutable
 public class VuePrdsVendusParDate
 {
   @EmbeddedId
   private VuePrdsId id;
   @Column(name = "num_magasin")
   private int numMagasin;
   @Column(name = "code_produit_dims", insertable = false, updatable = false, nullable = false)
   private String codeProduitDims;
   @Column(name = "code_produit_gen")
   private String codeProduitGen;
   @Column(name = "designation", insertable = false, updatable = false, nullable = false)
   private String designation;
   @Column(name = "quantite")
   private long quantite;
   @Column(name = "date_Mvt", insertable = false, updatable = false, nullable = false)
   private Date date;
   @Column(name = "prix_vente")
   private double prixVente;
   @Column(name = "total")
   private double total;
   @Column(name = "libelle_dim1")
   private String libelleDim1;
   @Column(name = "libelle_dim2")
   private String libelleDim2;
   @Column(name = "num_produit")
   private long numProduit;
   
   public VuePrdsVendusParDate(long numProduit, String codeProduitGen, String designation, long quantite, double total, double prixVente) {
     this.codeProduitGen = codeProduitGen;
     this.designation = designation;
     this.quantite = quantite;
    this.total = total;
   this.prixVente = prixVente;
    this.numProduit = numProduit;
   }
   
   public VuePrdsVendusParDate(long numProduit, String codeProduitDims, String designation, long quantite, double total, double prixVente, String dim1, String dim2) {
   this.numProduit = numProduit;
    this.codeProduitDims = codeProduitDims;
   this.designation = designation;
   this.quantite = quantite;
    this.total = total;
    this.prixVente = prixVente;
    this.libelleDim1 = dim1;
    this.libelleDim2 = dim2;
   }
   
   public VuePrdsVendusParDate(long numProduit, String codeProduitGen, String codeProduitDims, String designation, long quantite, double total, double prixVente, String dim1, String dim2) {
    this.numProduit = numProduit;
    this.codeProduitDims = codeProduitDims;
    this.codeProduitGen = codeProduitGen;
    this.designation = designation;
     this.quantite = quantite;
    this.total = total;
     this.prixVente = prixVente;
    this.libelleDim1 = dim1;
    this.libelleDim2 = dim2;
   }
   
   public String getCodeProduitGen() {
/*  86 */     return this.codeProduitGen;
   }
   
   public void setCodeProduitGen(String codeProduitGen) {
/*  90 */     this.codeProduitGen = codeProduitGen;
   }
   
   public String getLibelleDim1() {
/*  94 */     return this.libelleDim1;
   }
   
   public void setLibelleDim1(String libelleDim1) {
/*  98 */     this.libelleDim1 = libelleDim1;
   }
   
   public String getLibelleDim2() {
/* 102 */     return this.libelleDim2;
   }
   
   public void setLibelleDim2(String libelleDim2) {
/* 106 */     this.libelleDim2 = libelleDim2;
   }
 
   
   public long getNumProduit() {
/* 111 */     return this.numProduit;
   }
   
   public void setNumProduit(long numProduit) {
/* 115 */     this.numProduit = numProduit;
   }
   
   public VuePrdsId getId() {
/* 119 */     return this.id;
   }
   
   public void setId(VuePrdsId id) {
/* 123 */     this.id = id;
   }
   
   public int getNumMagasin() {
/* 127 */     return this.numMagasin;
   }
   
   public void setNumMagasin(int numMagasin) {
/* 131 */     this.numMagasin = numMagasin;
   }
   
   public String getCodeProduitDims() {
/* 135 */     return this.codeProduitDims;
   }
   
   public void setCodeProduitDims(String codeProduit) {
/* 139 */     this.codeProduitDims = codeProduit;
   }
   
   public String getDesignation() {
/* 143 */     return this.designation;
   }
   
   public void setDesignation(String designation) {
/* 147 */     this.designation = designation;
   }
   
   public long getQuantite() {
/* 151 */     return this.quantite;
   }
   
   public void setQuantite(long quantite) {
/* 155 */     this.quantite = quantite;
   }
   
   public Date getDate() {
/* 159 */     return this.date;
   }
   
   public void setDate(Date date) {
/* 163 */     this.date = date;
   }
   
   public double getTotal() {
/* 167 */     return this.total;
   }
   
   public void setTotal(double total) {
/* 171 */     this.total = total;
   }
 
   
   public double getPrixVente() {
/* 176 */     return this.prixVente;
   }
 
   
   public void setPrixVente(double prixVente) {
/* 181 */     this.prixVente = prixVente;
   }
 }

