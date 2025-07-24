 package ma.sofisoft.cam2020ws.entity;
 
 import javax.persistence.Column;
 import javax.persistence.Id;
 import javax.persistence.Transient;

 public class VueStockProduits
 {
   @Id
   @Column(name = "Row")
   private int row;
   @Column(name = "DESIGNATION")
   private String designation;
   @Column(name = "CODE_PRODUIT")
   private String codeProduit;
   @Column(name = "QUANTITE")
   private Integer quantite;
   @Transient
   private Integer numDim1;
   @Transient
   private Integer numDim2;
   @Transient
   private String Dims1;
   @Transient
   private String Dims2;
   @Transient
   private Integer codeDepot;
   @Transient
   private int numProduit;
   @Transient
   private String magasin;
   
   public int getRow() {
/*  39 */     return this.row;
   }
   public void setRow(int row) {
/*  42 */     this.row = row;
   }
   public String getDesignation() {
/*  45 */     return this.designation;
   }
   public void setDesignation(String designation) {
/*  48 */     this.designation = designation;
   }
   public String getCodeProduit() {
/*  51 */     return this.codeProduit;
   }
   public void setCodeProduit(String codeProduit) {
/*  54 */     this.codeProduit = codeProduit;
   }
   public Integer getQuantite() {
/*  57 */     return this.quantite;
   }
   public void setQuantite(Integer quantite) {
/*  60 */     this.quantite = quantite;
   }
   public Integer getNumDim1() {
/*  63 */     return this.numDim1;
   }
   public void setNumDim1(Integer numDim1) {
/*  66 */     this.numDim1 = numDim1;
   }
   public Integer getNumDim2() {
/*  69 */     return this.numDim2;
   }
   public void setNumDim2(Integer numDim2) {
/*  72 */     this.numDim2 = numDim2;
   }
   public String getDims1() {
/*  75 */     return this.Dims1;
   }
   public void setDims1(String dims1) {
/*  78 */     this.Dims1 = dims1;
   }
   public String getDims2() {
/*  81 */     return this.Dims2;
   }
   public void setDims2(String dims2) {
/*  84 */     this.Dims2 = dims2;
   }
   public Integer getCodeDepot() {
/*  87 */     return this.codeDepot;
   }
   public void setCodeDepot(Integer codeDepot) {
/*  90 */     this.codeDepot = codeDepot;
   }
   public int getNumProduit() {
/*  93 */     return this.numProduit;
   }
   public void setNumProduit(int numProduit) {
/*  96 */     this.numProduit = numProduit;
   }
   public String getMagasin() {
/*  99 */     return this.magasin;
   }
   public void setMagasin(String magasin) {
/* 102 */     this.magasin = magasin;
   }
 }

