 package ma.sofisoft.cam2020ws.entity;
 
 import com.fasterxml.jackson.annotation.JsonIgnore;
 import java.io.Serializable;
 import java.math.BigDecimal;
 import java.util.Date;
 import javax.persistence.Column;
 import javax.persistence.Entity;
 import javax.persistence.FetchType;
 import javax.persistence.Id;
 import javax.persistence.JoinColumn;
 import javax.persistence.ManyToOne;
 import javax.persistence.Table;
 import javax.persistence.Temporal;
 import javax.persistence.TemporalType;
 import javax.persistence.UniqueConstraint;
 import ma.sofisoft.cam2020ws.entity.StkProduitsGenerique;
 
 
 
 
 @Entity
 @Table(name = "STK_PRD_DIM", uniqueConstraints = {@UniqueConstraint(columnNames = {"CODE_PRODUIT"})})
 public class StkPrdDim
   implements Serializable
 {
   private long numDims;
   private int numProduit;
   @JsonIgnore
   private StkProduitsGenerique stkProduitsGenerique;
   private Long numDim2;
   private Long numDim1;
   private Long numDim3;
   private Long numDim4;
   private Integer numLigneDetail;
   private Long numRayon;
   private Long numEtagere;
   private Long numCase;
   private BigDecimal quantite;
   private Integer bloque;
   private Integer bloqueInv;
   private String codeBarre;
   private BigDecimal pmp;
   private BigDecimal prixRevient;
   private BigDecimal stockMax;
   private BigDecimal stockMin;
   private BigDecimal prixVente;
   private String codeProduit;
   private BigDecimal stockInt;
   private BigDecimal pmpInt;
   private BigDecimal prixUnitaire;
   private BigDecimal prixVente1Ht;
   private BigDecimal prixVente1Ttc;
   private Date datePrixVente1;
   private BigDecimal prixVente2Ht;
   private BigDecimal prixVente2Ttc;
   private Date datePrixVente2;
   private BigDecimal prixVente3Ht;
   private BigDecimal prixVente3Ttc;
   private Date datePrixVente3;
   private BigDecimal prixVente4Ht;
   private BigDecimal prixVente4Ttc;
   private Date datePrixVente4;
   private String image;
   
   public StkPrdDim() {}
   
   public StkPrdDim(long numDims, StkProduitsGenerique stkProduitsGenerique) {
    this.numDims = numDims;
     this.stkProduitsGenerique = stkProduitsGenerique;
   }
 
 
 
 
 
 
 
   
   public StkPrdDim(long numDims, StkProduitsGenerique stkProduitsGenerique, Long numDim2, Long numDim1, Long numDim3, Long numDim4, Integer numLigneDetail, Long numRayon, Long numEtagere, Long numCase, BigDecimal quantite, Integer bloque, Integer bloqueInv, String codeBarre, BigDecimal pmp, BigDecimal prixRevient, BigDecimal stockMax, BigDecimal stockMin, BigDecimal prixVente, String codeProduit, BigDecimal stockInt, BigDecimal pmpInt, BigDecimal prixUnitaire, BigDecimal prixVente1Ht, BigDecimal prixVente1Ttc, Date datePrixVente1, BigDecimal prixVente2Ht, BigDecimal prixVente2Ttc, Date datePrixVente2, BigDecimal prixVente3Ht, BigDecimal prixVente3Ttc, Date datePrixVente3, BigDecimal prixVente4Ht, BigDecimal prixVente4Ttc, Date datePrixVente4, String image) {
    this.numDims = numDims;
    this.stkProduitsGenerique = stkProduitsGenerique;
     this.numDim2 = numDim2;
    this.numDim1 = numDim1;
     this.numDim3 = numDim3;
    this.numDim4 = numDim4;
    this.numLigneDetail = numLigneDetail;
    this.numRayon = numRayon;
    this.numEtagere = numEtagere;
     this.numCase = numCase;
    this.quantite = quantite;
     this.bloque = bloque;
     this.bloqueInv = bloqueInv;
    this.codeBarre = codeBarre;
    this.pmp = pmp;
    this.prixRevient = prixRevient;
     this.stockMax = stockMax;
     this.stockMin = stockMin;
    this.prixVente = prixVente;
   this.codeProduit = codeProduit;
    this.stockInt = stockInt;
    this.pmpInt = pmpInt;
    this.prixUnitaire = prixUnitaire;
    this.prixVente1Ht = prixVente1Ht;
    this.prixVente1Ttc = prixVente1Ttc;
    this.datePrixVente1 = datePrixVente1;
    this.prixVente2Ht = prixVente2Ht;
     this.prixVente2Ttc = prixVente2Ttc;
    this.datePrixVente2 = datePrixVente2;
    this.prixVente3Ht = prixVente3Ht;
     this.prixVente3Ttc = prixVente3Ttc;
     this.datePrixVente3 = datePrixVente3;
  this.prixVente4Ht = prixVente4Ht;
   this.prixVente4Ttc = prixVente4Ttc;
     this.datePrixVente4 = datePrixVente4;
   this.image = image;
   }
   
   @Id
   @Column(name = "NUM_DIMS", unique = true, nullable = false, precision = 10, scale = 0)
   public long getNumDims() {
/* 122 */     return this.numDims;
   }
   
   public void setNumDims(long numDims) {
/* 126 */     this.numDims = numDims;
   }
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "NUM_PRODUIT", nullable = false)
   public StkProduitsGenerique getStkProduitsGenerique() {
/* 132 */     return this.stkProduitsGenerique;
   }
   
   public void setStkProduitsGenerique(StkProduitsGenerique stkProduitsGenerique) {
    this.stkProduitsGenerique = stkProduitsGenerique;
   }
   
   @Column(name = "NUM_DIM2", precision = 10, scale = 0)
   public Long getNumDim2() {
/* 141 */     return this.numDim2;
   }
   
   public void setNumDim2(Long numDim2) {
/* 145 */     this.numDim2 = numDim2;
   }
   
   @Column(name = "NUM_DIM1", precision = 10, scale = 0)
   public Long getNumDim1() {
/* 150 */     return this.numDim1;
   }
   
   public void setNumDim1(Long numDim1) {
/* 154 */     this.numDim1 = numDim1;
   }
   
   @Column(name = "NUM_DIM3", precision = 10, scale = 0)
   public Long getNumDim3() {
/* 159 */     return this.numDim3;
   }
   
   public void setNumDim3(Long numDim3) {
/* 163 */     this.numDim3 = numDim3;
   }
   
   @Column(name = "NUM_DIM4", precision = 10, scale = 0)
   public Long getNumDim4() {
/* 168 */     return this.numDim4;
   }
   
   public void setNumDim4(Long numDim4) {
/* 172 */     this.numDim4 = numDim4;
   }
   
   @Column(name = "NUM_LIGNE_DETAIL")
   public Integer getNumLigneDetail() {
/* 177 */     return this.numLigneDetail;
   }
   
   public void setNumLigneDetail(Integer numLigneDetail) {
/* 181 */     this.numLigneDetail = numLigneDetail;
   }
   
   @Column(name = "NUM_RAYON", precision = 10, scale = 0)
   public Long getNumRayon() {
/* 186 */     return this.numRayon;
   }
   
   public void setNumRayon(Long numRayon) {
/* 190 */     this.numRayon = numRayon;
   }
   
   @Column(name = "NUM_ETAGERE", precision = 10, scale = 0)
   public Long getNumEtagere() {
/* 195 */     return this.numEtagere;
   }
   
   public void setNumEtagere(Long numEtagere) {
/* 199 */     this.numEtagere = numEtagere;
   }
   
   @Column(name = "NUM_CASE", precision = 10, scale = 0)
   public Long getNumCase() {
/* 204 */     return this.numCase;
   }
   
   public void setNumCase(Long numCase) {
/* 208 */     this.numCase = numCase;
   }
   
   @Column(name = "QUANTITE", precision = 10)
   public BigDecimal getQuantite() {
/* 213 */     return this.quantite;
   }
   
   public void setQuantite(BigDecimal quantite) {
/* 217 */     this.quantite = quantite;
   }
   
   @Column(name = "BLOQUE")
   public Integer getBloque() {
/* 222 */     return this.bloque;
   }
   
   public void setBloque(Integer bloque) {
/* 226 */     this.bloque = bloque;
   }
   
   @Column(name = "BLOQUE_INV")
   public Integer getBloqueInv() {
/* 231 */     return this.bloqueInv;
   }
   
   public void setBloqueInv(Integer bloqueInv) {
/* 235 */     this.bloqueInv = bloqueInv;
   }
   
   @Column(name = "CODE_BARRE")
   public String getCodeBarre() {
/* 240 */     return this.codeBarre;
   }
   
   public void setCodeBarre(String codeBarre) {
/* 244 */     this.codeBarre = codeBarre;
   }
   
   @Column(name = "PMP", precision = 11)
   public BigDecimal getPmp() {
/* 249 */     return this.pmp;
   }
   
   public void setPmp(BigDecimal pmp) {
/* 253 */     this.pmp = pmp;
   }
   
   @Column(name = "PRIX_REVIENT", precision = 13)
   public BigDecimal getPrixRevient() {
/* 258 */     return this.prixRevient;
   }
   
   public void setPrixRevient(BigDecimal prixRevient) {
/* 262 */     this.prixRevient = prixRevient;
   }
   
   @Column(name = "STOCK_MAX", precision = 10)
   public BigDecimal getStockMax() {
/* 267 */     return this.stockMax;
   }
   
   public void setStockMax(BigDecimal stockMax) {
/* 271 */     this.stockMax = stockMax;
   }
   
   @Column(name = "STOCK_MIN", precision = 10)
   public BigDecimal getStockMin() {
/* 276 */     return this.stockMin;
   }
   
   public void setStockMin(BigDecimal stockMin) {
/* 280 */     this.stockMin = stockMin;
   }
   
   @Column(name = "PRIX_VENTE", precision = 10)
   public BigDecimal getPrixVente() {
/* 285 */     return this.prixVente;
   }
   
   public void setPrixVente(BigDecimal prixVente) {
/* 289 */     this.prixVente = prixVente;
   }
   
   @Column(name = "CODE_PRODUIT", unique = true)
   public String getCodeProduit() {
/* 294 */     return this.codeProduit;
   }
   
   public void setCodeProduit(String codeProduit) {
/* 298 */     this.codeProduit = codeProduit;
   }
   
   @Column(name = "STOCK_INT", precision = 10)
   public BigDecimal getStockInt() {
/* 303 */     return this.stockInt;
   }
   
   public void setStockInt(BigDecimal stockInt) {
/* 307 */     this.stockInt = stockInt;
   }
   
   @Column(name = "PMP_INT", precision = 11)
   public BigDecimal getPmpInt() {
/* 312 */     return this.pmpInt;
   }
   
   public void setPmpInt(BigDecimal pmpInt) {
/* 316 */     this.pmpInt = pmpInt;
   }
   
   @Column(name = "PRIX_UNITAIRE", precision = 18, scale = 3)
   public BigDecimal getPrixUnitaire() {
/* 321 */     return this.prixUnitaire;
   }
   
   public void setPrixUnitaire(BigDecimal prixUnitaire) {
/* 325 */     this.prixUnitaire = prixUnitaire;
   }
   
   @Column(name = "PRIX_VENTE1_HT", precision = 10)
   public BigDecimal getPrixVente1Ht() {
/* 330 */     return this.prixVente1Ht;
   }
   
   public void setPrixVente1Ht(BigDecimal prixVente1Ht) {
/* 334 */     this.prixVente1Ht = prixVente1Ht;
   }
   
   @Column(name = "PRIX_VENTE1_TTC", precision = 10)
   public BigDecimal getPrixVente1Ttc() {
/* 339 */     return this.prixVente1Ttc;
   }
   
   public void setPrixVente1Ttc(BigDecimal prixVente1Ttc) {
/* 343 */     this.prixVente1Ttc = prixVente1Ttc;
   }
   
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "DATE_PRIX_VENTE1", length = 23)
   public Date getDatePrixVente1() {
/* 349 */     return this.datePrixVente1;
   }
   
   public void setDatePrixVente1(Date datePrixVente1) {
/* 353 */     this.datePrixVente1 = datePrixVente1;
   }
   
   @Column(name = "PRIX_VENTE2_HT", precision = 10)
   public BigDecimal getPrixVente2Ht() {
/* 358 */     return this.prixVente2Ht;
   }
   
   public void setPrixVente2Ht(BigDecimal prixVente2Ht) {
/* 362 */     this.prixVente2Ht = prixVente2Ht;
   }
   
   @Column(name = "PRIX_VENTE2_TTC", precision = 10)
   public BigDecimal getPrixVente2Ttc() {
/* 367 */     return this.prixVente2Ttc;
   }
   
   public void setPrixVente2Ttc(BigDecimal prixVente2Ttc) {
/* 371 */     this.prixVente2Ttc = prixVente2Ttc;
   }
   
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "DATE_PRIX_VENTE2", length = 23)
   public Date getDatePrixVente2() {
/* 377 */     return this.datePrixVente2;
   }
   
   public void setDatePrixVente2(Date datePrixVente2) {
/* 381 */     this.datePrixVente2 = datePrixVente2;
   }
   
   @Column(name = "PRIX_VENTE3_HT", precision = 10)
   public BigDecimal getPrixVente3Ht() {
/* 386 */     return this.prixVente3Ht;
   }
   
   public void setPrixVente3Ht(BigDecimal prixVente3Ht) {
/* 390 */     this.prixVente3Ht = prixVente3Ht;
   }
   
   @Column(name = "PRIX_VENTE3_TTC", precision = 10)
   public BigDecimal getPrixVente3Ttc() {
/* 395 */     return this.prixVente3Ttc;
   }
   
   public void setPrixVente3Ttc(BigDecimal prixVente3Ttc) {
/* 399 */     this.prixVente3Ttc = prixVente3Ttc;
   }
   
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "DATE_PRIX_VENTE3", length = 23)
   public Date getDatePrixVente3() {
/* 405 */     return this.datePrixVente3;
   }
   
   public void setDatePrixVente3(Date datePrixVente3) {
/* 409 */     this.datePrixVente3 = datePrixVente3;
   }
   
   @Column(name = "PRIX_VENTE4_HT", precision = 10)
   public BigDecimal getPrixVente4Ht() {
/* 414 */     return this.prixVente4Ht;
   }
   
   public void setPrixVente4Ht(BigDecimal prixVente4Ht) {
/* 418 */     this.prixVente4Ht = prixVente4Ht;
   }
   
   @Column(name = "PRIX_VENTE4_TTC", precision = 10)
   public BigDecimal getPrixVente4Ttc() {
/* 423 */     return this.prixVente4Ttc;
   }
   
   public void setPrixVente4Ttc(BigDecimal prixVente4Ttc) {
/* 427 */     this.prixVente4Ttc = prixVente4Ttc;
   }
   
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "DATE_PRIX_VENTE4", length = 23)
   public Date getDatePrixVente4() {
/* 433 */     return this.datePrixVente4;
   }
   
   public void setDatePrixVente4(Date datePrixVente4) {
/* 437 */     this.datePrixVente4 = datePrixVente4;
   }
   
   @Column(name = "IMAGE")
   public String getImage() {
/* 442 */     return this.image;
   }
   
   public void setImage(String image) {
/* 446 */     this.image = image;
   }
 
   
   @Column(name = "NUM_PRODUIT", nullable = false, insertable = false, updatable = false, precision = 10, scale = 0)
   public int getNumProduit() {
/* 452 */     return this.numProduit;
   }
   
   public void setNumProduit(int numProduit) {
/* 456 */     this.numProduit = numProduit;
   }
 }

