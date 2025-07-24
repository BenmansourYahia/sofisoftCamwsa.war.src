 package ma.sofisoft.cam2020ws.model;
 
 public class StockModel
 {
   private Integer codeDepot;
   private int numProduit;
   private String magasin;
   private String designation;
   private String codeProduit;
   private Integer quantite;
   private Integer numDim1;
   private Integer numDim2;
   private String Dims1;
   private String Dims2;
   
   public Integer getNumDim1() {
/* 17 */     return this.numDim1;
   }
   public void setNumDim1(Integer numDim1) {
/* 20 */     this.numDim1 = numDim1;
   }
   public Integer getNumDim2() {
/* 23 */     return this.numDim2;
   }
   public void setNumDim2(Integer numDim2) {
/* 26 */     this.numDim2 = numDim2;
   }
   public int getNumProduit() {
/* 29 */     return this.numProduit;
   }
   public void setNumProduit(int numProduit) {
/* 32 */     this.numProduit = numProduit;
   }
   public String getMagasin() {
/* 35 */     return this.magasin;
   }
   public void setMagasin(String magasin) {
/* 38 */     this.magasin = magasin;
   }
   public String getDesignation() {
/* 41 */     return this.designation;
   }
   public void setDesignation(String designation) {
/* 44 */     this.designation = designation;
   }
   public String getCodeProduit() {
/* 47 */     return this.codeProduit;
   }
   public void setCodeProduit(String codeProduit) {
/* 50 */     this.codeProduit = codeProduit;
   }
   public Integer getQuantite() {
/* 53 */     return this.quantite;
   }
   
   public void setQuantite(Integer quantite) {
/* 57 */     this.quantite = quantite;
   }
   
   public String getDims1() {
/* 61 */     return this.Dims1;
   }
   public void setDims1(String dims1) {
/* 64 */     this.Dims1 = dims1;
   }
   public String getDims2() {
/* 67 */     return this.Dims2;
   }
   public void setDims2(String dims2) {
/* 70 */     this.Dims2 = dims2;
   }
   public Integer getCodeDepot() {
/* 73 */     return this.codeDepot;
   }
   public void setCodeDepot(Integer codeDepot) {
/* 76 */     this.codeDepot = codeDepot;
   }
 }

