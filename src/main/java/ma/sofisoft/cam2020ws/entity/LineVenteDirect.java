 package ma.sofisoft.cam2020ws.entity;
 
 import com.fasterxml.jackson.annotation.JsonIgnore;
 import java.io.Serializable;
 import java.math.BigDecimal;
 import javax.persistence.AttributeOverride;
 import javax.persistence.AttributeOverrides;
 import javax.persistence.Column;
 import javax.persistence.EmbeddedId;
 import javax.persistence.Entity;
 import javax.persistence.JoinColumn;
 import javax.persistence.JoinColumns;
 import javax.persistence.ManyToOne;
 import javax.persistence.Table;
 import ma.sofisoft.cam2020ws.entity.LineVenteDirectId;
 import ma.sofisoft.cam2020ws.entity.StkProduitsGenerique;
 import ma.sofisoft.cam2020ws.entity.StkVenteDirecte;
 

 
 @Entity
 @Table(name = "LINE_VENTE_DIRECT")
 public class LineVenteDirect
   implements Serializable
 {
   private LineVenteDirectId id;
   private int numProduit;
   private int numMvt;
   private BigDecimal quantite;
   @JsonIgnore
   private BigDecimal bruteht;
   @JsonIgnore
   private BigDecimal tauxTva;
   @JsonIgnore
   private String codeSaisie;
   @JsonIgnore
   private BigDecimal reste;
   @JsonIgnore
   private Integer status;
   @JsonIgnore
   private BigDecimal tauxRemise;
   @JsonIgnore
   private BigDecimal erreurCaisse;
   @JsonIgnore
   private BigDecimal mntcommission;
   @JsonIgnore
   private BigDecimal mntremisepromo;
   @JsonIgnore
   private Long numDims;
   private BigDecimal prixVente;
   @JsonIgnore
   private Long numVendeur;
   @JsonIgnore
   private Long numPromotion;
   @JsonIgnore
   private Long numListe;
   @JsonIgnore
   private BigDecimal qteNegative;
   @JsonIgnore
   private BigDecimal pmp;
   @JsonIgnore
   private String codePromo;
   
   public LineVenteDirect(LineVenteDirectId id, int numProduit, int numMvt, long lieuSaisie, String typeMvt, int livre) {
    this.id = id;
    this.numProduit = numProduit;
     this.numMvt = numMvt;
    this.lieuSaisie = lieuSaisie;
    this.typeMvt = typeMvt;
     this.livre = livre; } @JsonIgnore private Integer typePromo; @JsonIgnore private Integer statusReassort; @JsonIgnore private BigDecimal resteReassort; @JsonIgnore private long lieuSaisie; @JsonIgnore private String typeMvt; @JsonIgnore private int livre; @JsonIgnore private BigDecimal quantiteDedResa; @JsonIgnore private BigDecimal mntremisepromoPays; @JsonIgnore private BigDecimal prixVentePays; @JsonIgnore private BigDecimal prixRevient; @JsonIgnore private String codeAction; @JsonIgnore private String codePromoSuiv; @JsonIgnore private String codePromoPrec; @JsonIgnore
   private String numComposant; @JsonIgnore
   private String codeLot; @JsonIgnore
   private BigDecimal tauxRemisePied; @JsonIgnore
   private Long numLigneLm; @JsonIgnore
  private Long lieuSaisieLm; private StkVenteDirecte stkVenteDirecte; private StkProduitsGenerique stkProduitsGenerique; public LineVenteDirect() {} public LineVenteDirect(LineVenteDirectId id, int numProduit, int numMvt, BigDecimal quantite, BigDecimal tauxRemise, BigDecimal prixVente) { this.id = id;
     this.numProduit = numProduit;
    this.numMvt = numMvt;
    this.quantite = quantite;
     this.tauxRemise = tauxRemise;
     this.prixVente = prixVente; }
 
 
 
 
 
 
 
 
 
 
   
   public LineVenteDirect(LineVenteDirectId id, int numProduit, int numMvt, BigDecimal quantite, BigDecimal bruteht, BigDecimal tauxTva, String codeSaisie, BigDecimal reste, Integer status, BigDecimal tauxRemise, BigDecimal erreurCaisse, BigDecimal mntcommission, BigDecimal mntremisepromo, Long numDims, BigDecimal prixVente, Long numVendeur, Long numPromotion, Long numListe, BigDecimal qteNegative, BigDecimal pmp, String codePromo, Integer typePromo, Integer statusReassort, BigDecimal resteReassort, long lieuSaisie, String typeMvt, int livre, BigDecimal quantiteDedResa, BigDecimal mntremisepromoPays, BigDecimal prixVentePays, BigDecimal prixRevient, String codeAction, String codePromoSuiv, String codePromoPrec, String numComposant, String codeLot, BigDecimal tauxRemisePied, Long numLigneLm, Long lieuSaisieLm, String codeUtilisateurForcer) {
    this.id = id;
   this.numProduit = numProduit;
    this.numMvt = numMvt;
    this.quantite = quantite;
   this.bruteht = bruteht;
  this.tauxTva = tauxTva;
   this.codeSaisie = codeSaisie;
   this.reste = reste;
    this.status = status;
    this.tauxRemise = tauxRemise;
     this.erreurCaisse = erreurCaisse;
     this.mntcommission = mntcommission;
    this.mntremisepromo = mntremisepromo;
    this.numDims = numDims;
   this.prixVente = prixVente;
    this.numVendeur = numVendeur;
   this.numPromotion = numPromotion;
     this.numListe = numListe;
    this.qteNegative = qteNegative;
     this.pmp = pmp;
     this.codePromo = codePromo;
     this.typePromo = typePromo;
    this.statusReassort = statusReassort;
  this.resteReassort = resteReassort;
     this.lieuSaisie = lieuSaisie;
     this.typeMvt = typeMvt;
    this.livre = livre;
    this.quantiteDedResa = quantiteDedResa;
    this.mntremisepromoPays = mntremisepromoPays;
    this.prixVentePays = prixVentePays;
     this.prixRevient = prixRevient;
     this.codeAction = codeAction;
     this.codePromoSuiv = codePromoSuiv;
     this.codePromoPrec = codePromoPrec;
     this.numComposant = numComposant;
     this.codeLot = codeLot;
this.tauxRemisePied = tauxRemisePied;
     this.numLigneLm = numLigneLm;
     this.lieuSaisieLm = lieuSaisieLm;
   }
 
 
 
   
   @EmbeddedId
   @AttributeOverrides({@AttributeOverride(name = "numLigneMouvement", column = @Column(name = "NUM_LIGNE_MOUVEMENT", nullable = false)), @AttributeOverride(name = "numMagasin", column = @Column(name = "NUM_MAGASIN", nullable = false))})
   public LineVenteDirectId getId() {
/* 157 */     return this.id;
   }
   
   public void setId(LineVenteDirectId id) {
/* 161 */     this.id = id;
   }
   
   @Column(name = "NUM_PRODUIT", nullable = false)
   public int getNumProduit() {
/* 166 */     return this.numProduit;
   }
   
   public void setNumProduit(int numProduit) {
/* 170 */     this.numProduit = numProduit;
   }
   
   @Column(name = "NUM_MVT", nullable = false)
   public int getNumMvt() {
/* 175 */     return this.numMvt;
   }
   
   public void setNumMvt(int numMvt) {
/* 179 */     this.numMvt = numMvt;
   }
   
   @Column(name = "QUANTITE", precision = 18, scale = 5)
   public BigDecimal getQuantite() {
/* 184 */     return this.quantite;
   }
   
   public void setQuantite(BigDecimal quantite) {
/* 188 */     this.quantite = quantite;
   }
   
   @Column(name = "BRUTEHT", precision = 10)
   public BigDecimal getBruteht() {
/* 193 */     return this.bruteht;
   }
   
   public void setBruteht(BigDecimal bruteht) {
/* 197 */     this.bruteht = bruteht;
   }
   
   @Column(name = "TAUX_TVA", precision = 10)
   public BigDecimal getTauxTva() {
/* 202 */     return this.tauxTva;
   }
   
   public void setTauxTva(BigDecimal tauxTva) {
/* 206 */     this.tauxTva = tauxTva;
   }
   
   @Column(name = "CODE_SAISIE")
   public String getCodeSaisie() {
/* 211 */     return this.codeSaisie;
   }
   
   public void setCodeSaisie(String codeSaisie) {
/* 215 */     this.codeSaisie = codeSaisie;
   }
   
   @Column(name = "RESTE", precision = 10)
   public BigDecimal getReste() {
/* 220 */     return this.reste;
   }
   
   public void setReste(BigDecimal reste) {
/* 224 */     this.reste = reste;
   }
   
   @Column(name = "STATUS")
   public Integer getStatus() {
/* 229 */     return this.status;
   }
   
   public void setStatus(Integer status) {
/* 233 */     this.status = status;
   }
   
   @Column(name = "TAUX_REMISE", precision = 5)
   public BigDecimal getTauxRemise() {
/* 238 */     return this.tauxRemise;
   }
   
   public void setTauxRemise(BigDecimal tauxRemise) {
/* 242 */     this.tauxRemise = tauxRemise;
   }
   
   @Column(name = "ERREUR_CAISSE", precision = 10)
   public BigDecimal getErreurCaisse() {
/* 247 */     return this.erreurCaisse;
   }
   
   public void setErreurCaisse(BigDecimal erreurCaisse) {
/* 251 */     this.erreurCaisse = erreurCaisse;
   }
   
   @Column(name = "MNTCOMMISSION", precision = 10)
   public BigDecimal getMntcommission() {
/* 256 */     return this.mntcommission;
   }
   
   public void setMntcommission(BigDecimal mntcommission) {
/* 260 */     this.mntcommission = mntcommission;
   }
   
   @Column(name = "MNTREMISEPROMO", precision = 10)
   public BigDecimal getMntremisepromo() {
/* 265 */     return this.mntremisepromo;
   }
   
   public void setMntremisepromo(BigDecimal mntremisepromo) {
/* 269 */     this.mntremisepromo = mntremisepromo;
   }
   
   @Column(name = "NUM_DIMS", precision = 10, scale = 0)
   public Long getNumDims() {
/* 274 */     return this.numDims;
   }
   
   public void setNumDims(Long numDims) {
/* 278 */     this.numDims = numDims;
   }
   
   @Column(name = "PRIX_VENTE", precision = 10)
   public BigDecimal getPrixVente() {
/* 283 */     return this.prixVente;
   }
   
   public void setPrixVente(BigDecimal prixVente) {
/* 287 */     this.prixVente = prixVente;
   }
   
   @Column(name = "NUM_VENDEUR", precision = 10, scale = 0)
   public Long getNumVendeur() {
/* 292 */     return this.numVendeur;
   }
   
   public void setNumVendeur(Long numVendeur) {
/* 296 */     this.numVendeur = numVendeur;
   }
   
   @Column(name = "NUM_PROMOTION", precision = 10, scale = 0)
   public Long getNumPromotion() {
/* 301 */     return this.numPromotion;
   }
   
   public void setNumPromotion(Long numPromotion) {
/* 305 */     this.numPromotion = numPromotion;
   }
   
   @Column(name = "NUM_LISTE", precision = 10, scale = 0)
   public Long getNumListe() {
/* 310 */     return this.numListe;
   }
   
   public void setNumListe(Long numListe) {
/* 314 */     this.numListe = numListe;
   }
   
   @Column(name = "QTE_NEGATIVE", precision = 10)
   public BigDecimal getQteNegative() {
/* 319 */     return this.qteNegative;
   }
   
   public void setQteNegative(BigDecimal qteNegative) {
/* 323 */     this.qteNegative = qteNegative;
   }
   
   @Column(name = "PMP", precision = 18)
   public BigDecimal getPmp() {
/* 328 */     return this.pmp;
   }
   
   public void setPmp(BigDecimal pmp) {
/* 332 */     this.pmp = pmp;
   }
   
   @Column(name = "CODE_PROMO")
   public String getCodePromo() {
/* 337 */     return this.codePromo;
   }
   
   public void setCodePromo(String codePromo) {
/* 341 */     this.codePromo = codePromo;
   }
   
   @Column(name = "TYPE_PROMO")
   public Integer getTypePromo() {
/* 346 */     return this.typePromo;
   }
   
   public void setTypePromo(Integer typePromo) {
/* 350 */     this.typePromo = typePromo;
   }
   
   @Column(name = "STATUS_REASSORT")
   public Integer getStatusReassort() {
/* 355 */     return this.statusReassort;
   }
   
   public void setStatusReassort(Integer statusReassort) {
/* 359 */     this.statusReassort = statusReassort;
   }
   
   @Column(name = "RESTE_REASSORT", precision = 10)
   public BigDecimal getResteReassort() {
/* 364 */     return this.resteReassort;
   }
   
   public void setResteReassort(BigDecimal resteReassort) {
/* 368 */     this.resteReassort = resteReassort;
   }
   
   @Column(name = "LIEU_SAISIE", nullable = false, precision = 18, scale = 0)
   public long getLieuSaisie() {
/* 373 */     return this.lieuSaisie;
   }
   
   public void setLieuSaisie(long lieuSaisie) {
/* 377 */     this.lieuSaisie = lieuSaisie;
   }
   
   @Column(name = "TYPE_MVT", nullable = false, length = 10)
   public String getTypeMvt() {
/* 382 */     return this.typeMvt;
   }
   
   public void setTypeMvt(String typeMvt) {
/* 386 */     this.typeMvt = typeMvt;
   }
   
   @Column(name = "LIVRE", nullable = false)
   public int getLivre() {
/* 391 */     return this.livre;
   }
   
   public void setLivre(int livre) {
/* 395 */     this.livre = livre;
   }
   
   @Column(name = "QUANTITE_DED_RESA", precision = 18)
   public BigDecimal getQuantiteDedResa() {
/* 400 */     return this.quantiteDedResa;
   }
   
   public void setQuantiteDedResa(BigDecimal quantiteDedResa) {
/* 404 */     this.quantiteDedResa = quantiteDedResa;
   }
   
   @Column(name = "MNTREMISEPROMO_PAYS", precision = 18)
   public BigDecimal getMntremisepromoPays() {
/* 409 */     return this.mntremisepromoPays;
   }
   
   public void setMntremisepromoPays(BigDecimal mntremisepromoPays) {
/* 413 */     this.mntremisepromoPays = mntremisepromoPays;
   }
   
   @Column(name = "PRIX_VENTE_PAYS", precision = 18)
   public BigDecimal getPrixVentePays() {
/* 418 */     return this.prixVentePays;
   }
   
   public void setPrixVentePays(BigDecimal prixVentePays) {
/* 422 */     this.prixVentePays = prixVentePays;
   }
   
   @Column(name = "PRIX_REVIENT", precision = 18, scale = 3)
   public BigDecimal getPrixRevient() {
/* 427 */     return this.prixRevient;
   }
   
   public void setPrixRevient(BigDecimal prixRevient) {
/* 431 */     this.prixRevient = prixRevient;
   }
   
   @Column(name = "CODE_ACTION", length = 20)
   public String getCodeAction() {
/* 436 */     return this.codeAction;
   }
   
   public void setCodeAction(String codeAction) {
/* 440 */     this.codeAction = codeAction;
   }
   
   @Column(name = "CODE_PROMO_SUIV", length = 10)
   public String getCodePromoSuiv() {
/* 445 */     return this.codePromoSuiv;
   }
   
   public void setCodePromoSuiv(String codePromoSuiv) {
/* 449 */     this.codePromoSuiv = codePromoSuiv;
   }
   
   @Column(name = "CODE_PROMO_PREC", length = 10)
   public String getCodePromoPrec() {
/* 454 */     return this.codePromoPrec;
   }
   
   public void setCodePromoPrec(String codePromoPrec) {
/* 458 */     this.codePromoPrec = codePromoPrec;
   }
   
   @Column(name = "NUM_COMPOSANT", length = 2)
   public String getNumComposant() {
/* 463 */     return this.numComposant;
   }
   
   public void setNumComposant(String numComposant) {
/* 467 */     this.numComposant = numComposant;
   }
   
   @Column(name = "CODE_LOT", length = 10)
   public String getCodeLot() {
/* 472 */     return this.codeLot;
   }
   
   public void setCodeLot(String codeLot) {
/* 476 */     this.codeLot = codeLot;
   }
   
   @Column(name = "TAUX_REMISE_PIED", precision = 10, scale = 4)
   public BigDecimal getTauxRemisePied() {
/* 481 */     return this.tauxRemisePied;
   }
   
   public void setTauxRemisePied(BigDecimal tauxRemisePied) {
/* 485 */     this.tauxRemisePied = tauxRemisePied;
   }
   
   @Column(name = "NUM_LIGNE_LM", precision = 18, scale = 0)
   public Long getNumLigneLm() {
/* 490 */     return this.numLigneLm;
   }
   
   public void setNumLigneLm(Long numLigneLm) {
/* 494 */     this.numLigneLm = numLigneLm;
   }
   
   @Column(name = "LIEU_SAISIE_LM", precision = 18, scale = 0)
   public Long getLieuSaisieLm() {
/* 499 */     return this.lieuSaisieLm;
   }
 
   
   public void setLieuSaisieLm(Long lieuSaisieLm) {
/* 504 */     this.lieuSaisieLm = lieuSaisieLm;
   }
 

   
   @JsonIgnore
   @ManyToOne
   @JoinColumns({@JoinColumn(name = "NUM_MVT", insertable = false, updatable = false, nullable = false, referencedColumnName = "NUM_MVT"), @JoinColumn(name = "NUM_MAGASIN", insertable = false, updatable = false, nullable = false, referencedColumnName = "NUM_MAGASIN")})
   public StkVenteDirecte getStkVenteDirecte() {
/* 530 */     return this.stkVenteDirecte;
   }
   
   public void setStkVenteDirecte(StkVenteDirecte stkVenteDirecte) {
/* 534 */     this.stkVenteDirecte = stkVenteDirecte;
   }
 
 
 
 
   
   @ManyToOne
   @JoinColumn(name = "NUM_PRODUIT", referencedColumnName = "NUM_PRODUIT", insertable = false, updatable = false)
   public StkProduitsGenerique getStkProduitsGenerique() {
/* 544 */     return this.stkProduitsGenerique;
   }
   
   public void setStkProduitsGenerique(StkProduitsGenerique stkProduitsGenerique) {
     this.stkProduitsGenerique = stkProduitsGenerique;
   }
 }

