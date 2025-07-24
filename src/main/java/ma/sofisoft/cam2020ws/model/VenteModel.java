 package ma.sofisoft.cam2020ws.model;
 
 import java.math.BigDecimal;
 import java.util.Date;
 import java.util.List;
 import ma.sofisoft.cam2020ws.entity.StkVenteDirecteId;
 import ma.sofisoft.cam2020ws.model.ProduitModel;
 
 public class VenteModel
 {
   private StkVenteDirecteId id;
   private Date dateMvt;
   private BigDecimal montantTtc;
   private double quantite;
   private int hour;
   private List<ProduitModel> listProduits;
   
   public StkVenteDirecteId getId() {
     return this.id;
   }
   public void setId(StkVenteDirecteId id) {
     this.id = id;
   }
   public Date getDateMvt() {
     return this.dateMvt;
   }
   public void setDateMvt(Date dateMvt) {
     this.dateMvt = dateMvt;
   }
   public BigDecimal getMontantTtc() {
    return this.montantTtc;
   }
   public void setMontantTtc(BigDecimal montantTtc) {
    this.montantTtc = montantTtc;
   }
   public List<ProduitModel> getListProduits() {
    return this.listProduits;
   }
   public void setListProduits(List<ProduitModel> listProduits) {
    this.listProduits = listProduits;
   }
   public double getQuantite() {
     return this.quantite;
   }
   public void setQuantite(double quantite) {
    this.quantite = quantite;
   }
   public int getHour() {
    return this.hour;
   }
   public void setHour(int hour) {
    this.hour = hour;
   }
 }

