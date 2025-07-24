 package ma.sofisoft.cam2020ws.model;
import java.math.BigDecimal;

 public class BestSalePrdModel
 {
   private int Quantite;
   private int NumProduit;
   private String CodeProduit;
   private String Designation;
   private double Total;
   private double prixVente;
   
   public int getQuantite() {
   return this.Quantite;
   }
   public void setQuantite(int quantite) {
   this.Quantite = quantite;
   }
   public int getNumProduit() {
     return this.NumProduit;
   }
   public void setNumProduit(int numProduit) {
     this.NumProduit = numProduit;
   }
   public String getCodeProduit() {
    return this.CodeProduit;
   }
   public void setCodeProduit(String codeProduit) {
     this.CodeProduit = codeProduit;
   }
   public String getDesignation() {
   return this.Designation;
   }
   public void setDesignation(String designation) {
     this.Designation = designation;
   }
   public double getTotal() {
     this.Total = this.Quantite * this.prixVente;
   return this.Total;
   }
   public void setTotal(double total) {
  this.Total = total;
   }
   public double getPrixVente() {
    return this.prixVente;
   }
   public void setPrixVente(double prixVente) {
    this.prixVente = prixVente;
   }
 }

