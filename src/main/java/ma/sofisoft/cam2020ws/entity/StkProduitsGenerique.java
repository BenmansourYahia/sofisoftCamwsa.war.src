 package ma.sofisoft.cam2020ws.entity;
 
 import com.fasterxml.jackson.annotation.JsonIgnore;
 import java.io.Serializable;
 import java.math.BigDecimal;
 import java.util.Date;
 import java.util.HashSet;
 import java.util.Set;
 import javax.persistence.Column;
 import javax.persistence.Entity;
 import javax.persistence.FetchType;
 import javax.persistence.Id;
 import javax.persistence.OneToMany;
 import javax.persistence.Table;
 import javax.persistence.Temporal;
 import javax.persistence.TemporalType;
 import javax.persistence.UniqueConstraint;
 import ma.sofisoft.cam2020ws.entity.StkPrdDim;

 @Entity
 @Table(name = "STK_PRODUITS_GENERIQUE", uniqueConstraints = {@UniqueConstraint(columnNames = {"CODE_PRODUIT"})})
 public class StkProduitsGenerique
   implements Serializable
 {
   private int numProduit;
   private long numTva;
   @JsonIgnore
   private Long numSfamille;
   @JsonIgnore
   private Long numFamille;
   @JsonIgnore
   private long numActivite;
   @JsonIgnore
   private long numCompte;
   @JsonIgnore
   private long cptNumCompte;
   @JsonIgnore
   private Long numDevise;
   @JsonIgnore
   private Long numCase;
   @JsonIgnore
   private Byte numEtagere;
   @JsonIgnore
   private Long numRayon;
   @JsonIgnore
   private Long numFournisseur;
   @JsonIgnore
   private Long numGrille;
   @JsonIgnore
   private Long numGrille2;
   @JsonIgnore
   private Long numGrille3;
   @JsonIgnore
   private Long numGrille4;
   private String codeProduit;
   private String codeBarre;
   private String designation;
   private String desingLonge;
   @JsonIgnore
   private String libelleCaisse;
   private BigDecimal prixUnitaire;
   @JsonIgnore
   private BigDecimal prixRevient;
   @JsonIgnore
   private BigDecimal prixCession;
   @JsonIgnore
   private Integer indicateurComposition;
   @JsonIgnore
   private BigDecimal pmp;
   @JsonIgnore
   private BigDecimal dernierPrixAchat;
   @JsonIgnore
   private BigDecimal plafondRemise;
   @JsonIgnore
   private BigDecimal stockMax;
   @JsonIgnore
   private BigDecimal stockMin;
   @JsonIgnore
   private Integer bloqueInv;
   @JsonIgnore
   private String images;
   @JsonIgnore
   private Integer bloque;
   @JsonIgnore
   private BigDecimal tauxMarge;
   @JsonIgnore
   private BigDecimal tauxMargeCession;
   @JsonIgnore
   private BigDecimal prixVenteHt;
   private BigDecimal prixVenteTtc;
   @JsonIgnore
   private BigDecimal stockInt;
   @JsonIgnore
   private BigDecimal pmpInt;
   @JsonIgnore
   private Long numMarque;
   @JsonIgnore
   private Long numModele;
   @JsonIgnore
   private boolean serie;
   @JsonIgnore
   private boolean stock;
   @JsonIgnore
   private boolean prixSaisi;
   @JsonIgnore
   private boolean compose;
   @JsonIgnore
   private Long numSaison;
   @JsonIgnore
   private Long numNiveau3;
   @JsonIgnore
   private Long numNiveau4;
   @JsonIgnore
   private Long numNiveau5;
   @JsonIgnore
   private Boolean livraison;
   @JsonIgnore
   private Boolean vente;
   @JsonIgnore
   private Boolean visible;
   @JsonIgnore
   private Date datePmpInitial;
   @JsonIgnore
   private Date dateDernierPmp;
   @JsonIgnore
   private Date dateLimiteStockage;
   @JsonIgnore
  private Set<StkPrdDim> stkPrdDims = new HashSet<>(0); @JsonIgnore private Date dateCreation; @JsonIgnore private String utilisateurCreat; @JsonIgnore private Date dateModification; @JsonIgnore private String utilisateurModif; @JsonIgnore private Integer delaiExistence; @JsonIgnore private Boolean reception; @JsonIgnore private Boolean commandeFrs; @JsonIgnore private Boolean commande; @JsonIgnore private Date dateBloque; @JsonIgnore private Date dateVisible; @JsonIgnore private Date dateBlqLiv; @JsonIgnore private Date dateBlqRec; @JsonIgnore private Date dateBlqCmd; @JsonIgnore private Date dateBlqCmdFrs; @JsonIgnore private Date dateBlqVente; @JsonIgnore private BigDecimal poids; @JsonIgnore private BigDecimal volume; @JsonIgnore private BigDecimal longueur; @JsonIgnore private BigDecimal largeur; @JsonIgnore private BigDecimal hauteur; @JsonIgnore private BigDecimal prixVente1Ht; @JsonIgnore private BigDecimal prixVente1Ttc; @JsonIgnore private Date datePrixVente1; @JsonIgnore private BigDecimal prixVente2Ht; @JsonIgnore private BigDecimal prixVente2Ttc; @JsonIgnore private Date datePrixVente2; @JsonIgnore private BigDecimal prixVente3Ht; @JsonIgnore private BigDecimal prixVente3Ttc; @JsonIgnore private Date datePrixVente3; @JsonIgnore private BigDecimal prixVente4Ht; @JsonIgnore private BigDecimal prixVente4Ttc; @JsonIgnore private Date datePrixVente4; private BigDecimal derPrixVenteTtc; @JsonIgnore private boolean pese; @JsonIgnore private String codeProduitPese; @JsonIgnore private Character pesePoidsUnite; @JsonIgnore private BigDecimal tauxDeviseAchat; @JsonIgnore private Long devisePrixRevient; @JsonIgnore private BigDecimal tauxDeviseRevient; @JsonIgnore private Long devisePrixVente; @JsonIgnore private BigDecimal tauxDeviseVente; @JsonIgnore private Integer status; @JsonIgnore private BigDecimal tarif1; @JsonIgnore private BigDecimal tarif2; @JsonIgnore private BigDecimal tarif3; @JsonIgnore
   private BigDecimal tarif4; @JsonIgnore
   private BigDecimal tarif5; @JsonIgnore
   private BigDecimal tarif6; @JsonIgnore
   private BigDecimal tarif7; @JsonIgnore
   private BigDecimal tarif8; @JsonIgnore
   private BigDecimal tarif9; @JsonIgnore
   private BigDecimal tarif10; @JsonIgnore
   private Long uniteStockage; @JsonIgnore
   private BigDecimal degre; @JsonIgnore
  private Integer complement; public StkProduitsGenerique() {} public StkProduitsGenerique(int numProduit, long numTva, long numActivite, long numCompte, long cptNumCompte, boolean serie, boolean stock, boolean prixSaisi, boolean compose, boolean pese) { this.numProduit = numProduit;
   this.numTva = numTva;
  this.numActivite = numActivite;
  this.numCompte = numCompte;
   this.cptNumCompte = cptNumCompte;
    this.serie = serie;
     this.stock = stock;
   this.prixSaisi = prixSaisi;
    this.compose = compose;
   this.pese = pese; }
 

 
   
   public StkProduitsGenerique(int numProduit, long numTva, Long numSfamille, Long numFamille, long numActivite, long numCompte, long cptNumCompte, Long numDevise, Long numCase, Byte numEtagere, Long numRayon, Long numFournisseur, Long numGrille, Long numGrille2, Long numGrille3, Long numGrille4, String codeProduit, String codeBarre, String designation, String desingLonge, String libelleCaisse, BigDecimal prixUnitaire, BigDecimal prixRevient, BigDecimal prixCession, Integer indicateurComposition, BigDecimal pmp, BigDecimal dernierPrixAchat, BigDecimal plafondRemise, BigDecimal stockMax, BigDecimal stockMin, Integer bloqueInv, String images, Integer bloque, BigDecimal tauxMarge, BigDecimal tauxMargeCession, BigDecimal prixVenteHt, BigDecimal prixVenteTtc, BigDecimal stockInt, BigDecimal pmpInt, Long numMarque, Long numModele, boolean serie, boolean stock, boolean prixSaisi, boolean compose, Long numSaison, Long numNiveau3, Long numNiveau4, Long numNiveau5, Boolean livraison, Boolean vente, Boolean visible, Date datePmpInitial, Date dateDernierPmp, Date dateLimiteStockage, Date dateCreation, String utilisateurCreat, Date dateModification, String utilisateurModif, Integer delaiExistence, Boolean reception, Boolean commandeFrs, Boolean commande, Date dateBloque, Date dateVisible, Date dateBlqLiv, Date dateBlqRec, Date dateBlqCmd, Date dateBlqCmdFrs, Date dateBlqVente, BigDecimal poids, BigDecimal volume, BigDecimal longueur, BigDecimal largeur, BigDecimal hauteur, BigDecimal prixVente1Ht, BigDecimal prixVente1Ttc, Date datePrixVente1, BigDecimal prixVente2Ht, BigDecimal prixVente2Ttc, Date datePrixVente2, BigDecimal prixVente3Ht, BigDecimal prixVente3Ttc, Date datePrixVente3, BigDecimal prixVente4Ht, BigDecimal prixVente4Ttc, Date datePrixVente4, BigDecimal derPrixVenteTtc, boolean pese, String codeProduitPese, Character pesePoidsUnite, BigDecimal tauxDeviseAchat, Long devisePrixRevient, BigDecimal tauxDeviseRevient, Long devisePrixVente, BigDecimal tauxDeviseVente, Integer status, BigDecimal tarif1, BigDecimal tarif2, BigDecimal tarif3, BigDecimal tarif4, BigDecimal tarif5, BigDecimal tarif6, BigDecimal tarif7, BigDecimal tarif8, BigDecimal tarif9, BigDecimal tarif10, Long uniteStockage, BigDecimal degre, Integer complement, Set<StkPrdDim> stkPrdDims) {
    this.numProduit = numProduit;
    this.numTva = numTva;
    this.numSfamille = numSfamille;
     this.numFamille = numFamille;
     this.numActivite = numActivite;
    this.numCompte = numCompte;
    this.cptNumCompte = cptNumCompte;
   this.numDevise = numDevise;
    this.numCase = numCase;
   this.numEtagere = numEtagere;
    this.numRayon = numRayon;
     this.numFournisseur = numFournisseur;
     this.numGrille = numGrille;
    this.numGrille2 = numGrille2;
     this.numGrille3 = numGrille3;
    this.numGrille4 = numGrille4;
     this.codeProduit = codeProduit;
     this.codeBarre = codeBarre;
     this.designation = designation;
  this.desingLonge = desingLonge;
    this.libelleCaisse = libelleCaisse;
    this.prixUnitaire = prixUnitaire;
     this.prixRevient = prixRevient;
    this.prixCession = prixCession;
     this.indicateurComposition = indicateurComposition;
     this.pmp = pmp;
    this.dernierPrixAchat = dernierPrixAchat;
    this.plafondRemise = plafondRemise;
     this.stockMax = stockMax;
     this.stockMin = stockMin;
    this.bloqueInv = bloqueInv;
    this.images = images;
     this.bloque = bloque;
    this.tauxMarge = tauxMarge;
    this.tauxMargeCession = tauxMargeCession;
     this.prixVenteHt = prixVenteHt;
     this.prixVenteTtc = prixVenteTtc;
    this.stockInt = stockInt;
     this.pmpInt = pmpInt;
     this.numMarque = numMarque;
    this.numModele = numModele;
     this.serie = serie;
    this.stock = stock;
     this.prixSaisi = prixSaisi;
    this.compose = compose;
     this.numSaison = numSaison;
this.numNiveau3 = numNiveau3;
  this.numNiveau4 = numNiveau4;
     this.numNiveau5 = numNiveau5;
     this.livraison = livraison;
     this.vente = vente;
    this.visible = visible;
     this.datePmpInitial = datePmpInitial;
    this.dateDernierPmp = dateDernierPmp;
    this.dateLimiteStockage = dateLimiteStockage;
    this.dateCreation = dateCreation;
    this.utilisateurCreat = utilisateurCreat;
     this.dateModification = dateModification;
    this.delaiExistence = delaiExistence;
   this.reception = reception;
    this.commandeFrs = commandeFrs;
    this.commande = commande;
    this.dateBloque = dateBloque;
   this.dateVisible = dateVisible;
     this.dateBlqLiv = dateBlqLiv;
   this.dateBlqRec = dateBlqRec;
    this.dateBlqCmd = dateBlqCmd;
     this.dateBlqCmdFrs = dateBlqCmdFrs;
     this.dateBlqVente = dateBlqVente;
   this.poids = poids;
     this.volume = volume;
     this.longueur = longueur;
     this.largeur = largeur;
    this.hauteur = hauteur;
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
     this.derPrixVenteTtc = derPrixVenteTtc;
     this.pese = pese;
    this.codeProduitPese = codeProduitPese;
    this.pesePoidsUnite = pesePoidsUnite;
     this.tauxDeviseAchat = tauxDeviseAchat;
     this.devisePrixRevient = devisePrixRevient;
    this.tauxDeviseRevient = tauxDeviseRevient;
     this.devisePrixVente = devisePrixVente;
    this.tauxDeviseVente = tauxDeviseVente;
    this.status = status;
     this.tarif1 = tarif1;
    this.tarif2 = tarif2;
    this.tarif3 = tarif3;
     this.tarif4 = tarif4;
    this.tarif5 = tarif5;
    this.tarif6 = tarif6;
     this.tarif7 = tarif7;
     this.tarif8 = tarif8;
    this.tarif9 = tarif9;
     this.tarif10 = tarif10;
     this.uniteStockage = uniteStockage;
  this.degre = degre;
    this.complement = complement;
     this.stkPrdDims = stkPrdDims;
   }
   
   @Id
   @Column(name = "NUM_PRODUIT", unique = true, nullable = false)
   public int getNumProduit() {
/*  304 */     return this.numProduit;
   }
   
   public void setNumProduit(int numProduit) {
/*  308 */     this.numProduit = numProduit;
   }
   
   @Column(name = "NUM_TVA", nullable = false, precision = 10, scale = 0)
   public long getNumTva() {
/*  313 */     return this.numTva;
   }
   
   public void setNumTva(long numTva) {
/*  317 */     this.numTva = numTva;
   }
   
   @Column(name = "NUM_SFAMILLE", precision = 10, scale = 0)
   public Long getNumSfamille() {
/*  322 */     return this.numSfamille;
   }
   
   public void setNumSfamille(Long numSfamille) {
/*  326 */     this.numSfamille = numSfamille;
   }
   
   @Column(name = "NUM_FAMILLE", precision = 10, scale = 0)
   public Long getNumFamille() {
/*  331 */     return this.numFamille;
   }
   
   public void setNumFamille(Long numFamille) {
/*  335 */     this.numFamille = numFamille;
   }
   
   @Column(name = "NUM_ACTIVITE", nullable = false, precision = 10, scale = 0)
   public long getNumActivite() {
/*  340 */     return this.numActivite;
   }
   
   public void setNumActivite(long numActivite) {
/*  344 */     this.numActivite = numActivite;
   }
   
   @Column(name = "NUM_COMPTE", nullable = false, precision = 10, scale = 0)
   public long getNumCompte() {
/*  349 */     return this.numCompte;
   }
   
   public void setNumCompte(long numCompte) {
/*  353 */     this.numCompte = numCompte;
   }
   
   @Column(name = "CPT_NUM_COMPTE", nullable = false, precision = 10, scale = 0)
   public long getCptNumCompte() {
/*  358 */     return this.cptNumCompte;
   }
   
   public void setCptNumCompte(long cptNumCompte) {
/*  362 */     this.cptNumCompte = cptNumCompte;
   }
   
   @Column(name = "NUM_DEVISE", precision = 10, scale = 0)
   public Long getNumDevise() {
/*  367 */     return this.numDevise;
   }
   
   public void setNumDevise(Long numDevise) {
/*  371 */     this.numDevise = numDevise;
   }
   
   @Column(name = "NUM_CASE", precision = 10, scale = 0)
   public Long getNumCase() {
/*  376 */     return this.numCase;
   }
   
   public void setNumCase(Long numCase) {
/*  380 */     this.numCase = numCase;
   }
   
   @Column(name = "NUM_ETAGERE", precision = 2, scale = 0)
   public Byte getNumEtagere() {
/*  385 */     return this.numEtagere;
   }
   
   public void setNumEtagere(Byte numEtagere) {
/*  389 */     this.numEtagere = numEtagere;
   }
   
   @Column(name = "NUM_RAYON", precision = 10, scale = 0)
   public Long getNumRayon() {
/*  394 */     return this.numRayon;
   }
   
   public void setNumRayon(Long numRayon) {
/*  398 */     this.numRayon = numRayon;
   }
   
   @Column(name = "NUM_FOURNISSEUR", precision = 10, scale = 0)
   public Long getNumFournisseur() {
/*  403 */     return this.numFournisseur;
   }
   
   public void setNumFournisseur(Long numFournisseur) {
/*  407 */     this.numFournisseur = numFournisseur;
   }
   
   @Column(name = "NUM_GRILLE", precision = 10, scale = 0)
   public Long getNumGrille() {
/*  412 */     return this.numGrille;
   }
   
   public void setNumGrille(Long numGrille) {
/*  416 */     this.numGrille = numGrille;
   }
   
   @Column(name = "NUM_GRILLE2", precision = 10, scale = 0)
   public Long getNumGrille2() {
/*  421 */     return this.numGrille2;
   }
   
   public void setNumGrille2(Long numGrille2) {
/*  425 */     this.numGrille2 = numGrille2;
   }
   
   @Column(name = "NUM_GRILLE3", precision = 10, scale = 0)
   public Long getNumGrille3() {
/*  430 */     return this.numGrille3;
   }
   
   public void setNumGrille3(Long numGrille3) {
/*  434 */     this.numGrille3 = numGrille3;
   }
   
   @Column(name = "NUM_GRILLE4", precision = 10, scale = 0)
   public Long getNumGrille4() {
/*  439 */     return this.numGrille4;
   }
   
   public void setNumGrille4(Long numGrille4) {
/*  443 */     this.numGrille4 = numGrille4;
   }
   
   @Column(name = "CODE_PRODUIT", unique = true)
   public String getCodeProduit() {
/*  448 */     return this.codeProduit;
   }
   
   public void setCodeProduit(String codeProduit) {
/*  452 */     this.codeProduit = codeProduit;
   }
   
   @Column(name = "CODE_BARRE")
   public String getCodeBarre() {
/*  457 */     return this.codeBarre;
   }
   
   public void setCodeBarre(String codeBarre) {
/*  461 */     this.codeBarre = codeBarre;
   }
   
   @Column(name = "DESIGNATION", length = 50)
   public String getDesignation() {
/*  466 */     return this.designation;
   }
   
   public void setDesignation(String designation) {
/*  470 */     this.designation = designation;
   }
   
   @Column(name = "DESING_LONGE", length = 200)
   public String getDesingLonge() {
/*  475 */     return this.desingLonge;
   }
   
   public void setDesingLonge(String desingLonge) {
/*  479 */     this.desingLonge = desingLonge;
   }
   
   @Column(name = "LIBELLE_CAISSE", length = 30)
   public String getLibelleCaisse() {
/*  484 */     return this.libelleCaisse;
   }
   
   public void setLibelleCaisse(String libelleCaisse) {
/*  488 */     this.libelleCaisse = libelleCaisse;
   }
   
   @Column(name = "PRIX_UNITAIRE", precision = 18, scale = 3)
   public BigDecimal getPrixUnitaire() {
/*  493 */     return this.prixUnitaire;
   }
   
   public void setPrixUnitaire(BigDecimal prixUnitaire) {
/*  497 */     this.prixUnitaire = prixUnitaire;
   }
   
   @Column(name = "PRIX_REVIENT", precision = 13)
   public BigDecimal getPrixRevient() {
/*  502 */     return this.prixRevient;
   }
   
   public void setPrixRevient(BigDecimal prixRevient) {
/*  506 */     this.prixRevient = prixRevient;
   }
   
   @Column(name = "PRIX_CESSION", precision = 10)
   public BigDecimal getPrixCession() {
/*  511 */     return this.prixCession;
   }
   
   public void setPrixCession(BigDecimal prixCession) {
/*  515 */     this.prixCession = prixCession;
   }
   
   @Column(name = "INDICATEUR_COMPOSITION")
   public Integer getIndicateurComposition() {
/*  520 */     return this.indicateurComposition;
   }
   
   public void setIndicateurComposition(Integer indicateurComposition) {
/*  524 */     this.indicateurComposition = indicateurComposition;
   }
   
   @Column(name = "PMP", precision = 11)
   public BigDecimal getPmp() {
/*  529 */     return this.pmp;
   }
   
   public void setPmp(BigDecimal pmp) {
/*  533 */     this.pmp = pmp;
   }
   
   @Column(name = "DERNIER_PRIX_ACHAT", precision = 11)
   public BigDecimal getDernierPrixAchat() {
/*  538 */     return this.dernierPrixAchat;
   }
   
   public void setDernierPrixAchat(BigDecimal dernierPrixAchat) {
/*  542 */     this.dernierPrixAchat = dernierPrixAchat;
   }
   
   @Column(name = "PLAFOND_REMISE", precision = 10)
   public BigDecimal getPlafondRemise() {
/*  547 */     return this.plafondRemise;
   }
   
   public void setPlafondRemise(BigDecimal plafondRemise) {
/*  551 */     this.plafondRemise = plafondRemise;
   }
   
   @Column(name = "STOCK_MAX", precision = 10)
   public BigDecimal getStockMax() {
/*  556 */     return this.stockMax;
   }
   
   public void setStockMax(BigDecimal stockMax) {
/*  560 */     this.stockMax = stockMax;
   }
   
   @Column(name = "STOCK_MIN", precision = 10)
   public BigDecimal getStockMin() {
/*  565 */     return this.stockMin;
   }
   
   public void setStockMin(BigDecimal stockMin) {
/*  569 */     this.stockMin = stockMin;
   }
   
   @Column(name = "BLOQUE_INV")
   public Integer getBloqueInv() {
/*  574 */     return this.bloqueInv;
   }
   
   public void setBloqueInv(Integer bloqueInv) {
/*  578 */     this.bloqueInv = bloqueInv;
   }
   
   @Column(name = "IMAGES")
   public String getImages() {
/*  583 */     return this.images;
   }
   
   public void setImages(String images) {
/*  587 */     this.images = images;
   }
   
   @Column(name = "BLOQUE")
   public Integer getBloque() {
/*  592 */     return this.bloque;
   }
   
   public void setBloque(Integer bloque) {
/*  596 */     this.bloque = bloque;
   }
   
   @Column(name = "TAUX_MARGE", precision = 10)
   public BigDecimal getTauxMarge() {
/*  601 */     return this.tauxMarge;
   }
   
   public void setTauxMarge(BigDecimal tauxMarge) {
/*  605 */     this.tauxMarge = tauxMarge;
   }
   
   @Column(name = "TAUX_MARGE_CESSION", precision = 10)
   public BigDecimal getTauxMargeCession() {
/*  610 */     return this.tauxMargeCession;
   }
   
   public void setTauxMargeCession(BigDecimal tauxMargeCession) {
/*  614 */     this.tauxMargeCession = tauxMargeCession;
   }
   
   @Column(name = "PRIX_VENTE_HT", precision = 10)
   public BigDecimal getPrixVenteHt() {
/*  619 */     return this.prixVenteHt;
   }
   
   public void setPrixVenteHt(BigDecimal prixVenteHt) {
/*  623 */     this.prixVenteHt = prixVenteHt;
   }
   
   @Column(name = "PRIX_VENTE_TTC", precision = 10)
   public BigDecimal getPrixVenteTtc() {
/*  628 */     return this.prixVenteTtc;
   }
   
   public void setPrixVenteTtc(BigDecimal prixVenteTtc) {
/*  632 */     this.prixVenteTtc = prixVenteTtc;
   }
   
   @Column(name = "STOCK_INT", precision = 10)
   public BigDecimal getStockInt() {
/*  637 */     return this.stockInt;
   }
   
   public void setStockInt(BigDecimal stockInt) {
/*  641 */     this.stockInt = stockInt;
   }
   
   @Column(name = "PMP_INT", precision = 10)
   public BigDecimal getPmpInt() {
/*  646 */     return this.pmpInt;
   }
   
   public void setPmpInt(BigDecimal pmpInt) {
/*  650 */     this.pmpInt = pmpInt;
   }
   
   @Column(name = "Num_marque", precision = 10, scale = 0)
   public Long getNumMarque() {
/*  655 */     return this.numMarque;
   }
   
   public void setNumMarque(Long numMarque) {
/*  659 */     this.numMarque = numMarque;
   }
   
   @Column(name = "Num_modele", precision = 10, scale = 0)
   public Long getNumModele() {
/*  664 */     return this.numModele;
   }
   
   public void setNumModele(Long numModele) {
/*  668 */     this.numModele = numModele;
   }
   
   @Column(name = "SERIE", nullable = false)
   public boolean isSerie() {
/*  673 */     return this.serie;
   }
   
   public void setSerie(boolean serie) {
/*  677 */     this.serie = serie;
   }
   
   @Column(name = "STOCK", nullable = false)
   public boolean isStock() {
/*  682 */     return this.stock;
   }
   
   public void setStock(boolean stock) {
/*  686 */     this.stock = stock;
   }
   
   @Column(name = "PRIX_SAISI", nullable = false)
   public boolean isPrixSaisi() {
/*  691 */     return this.prixSaisi;
   }
   
   public void setPrixSaisi(boolean prixSaisi) {
/*  695 */     this.prixSaisi = prixSaisi;
   }
   
   @Column(name = "COMPOSE", nullable = false)
   public boolean isCompose() {
/*  700 */     return this.compose;
   }
   
   public void setCompose(boolean compose) {
/*  704 */     this.compose = compose;
   }
   
   @Column(name = "NUM_SAISON", precision = 10, scale = 0)
   public Long getNumSaison() {
/*  709 */     return this.numSaison;
   }
   
   public void setNumSaison(Long numSaison) {
/*  713 */     this.numSaison = numSaison;
   }
   
   @Column(name = "NUM_NIVEAU3", precision = 18, scale = 0)
   public Long getNumNiveau3() {
/*  718 */     return this.numNiveau3;
   }
   
   public void setNumNiveau3(Long numNiveau3) {
/*  722 */     this.numNiveau3 = numNiveau3;
   }
   
   @Column(name = "NUM_NIVEAU4", precision = 18, scale = 0)
   public Long getNumNiveau4() {
/*  727 */     return this.numNiveau4;
   }
   
   public void setNumNiveau4(Long numNiveau4) {
/*  731 */     this.numNiveau4 = numNiveau4;
   }
   
   @Column(name = "NUM_NIVEAU5", precision = 18, scale = 0)
   public Long getNumNiveau5() {
/*  736 */     return this.numNiveau5;
   }
   
   public void setNumNiveau5(Long numNiveau5) {
/*  740 */     this.numNiveau5 = numNiveau5;
   }
   
   @Column(name = "LIVRAISON")
   public Boolean getLivraison() {
/*  745 */     return this.livraison;
   }
   
   public void setLivraison(Boolean livraison) {
/*  749 */     this.livraison = livraison;
   }
   
   @Column(name = "VENTE")
   public Boolean getVente() {
/*  754 */     return this.vente;
   }
   
   public void setVente(Boolean vente) {
/*  758 */     this.vente = vente;
   }
   
   @Column(name = "VISIBLE")
   public Boolean getVisible() {
/*  763 */     return this.visible;
   }
   
   public void setVisible(Boolean visible) {
/*  767 */     this.visible = visible;
   }
   
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "DATE_PMP_INITIAL", length = 23)
   public Date getDatePmpInitial() {
/*  773 */     return this.datePmpInitial;
   }
   
   public void setDatePmpInitial(Date datePmpInitial) {
/*  777 */     this.datePmpInitial = datePmpInitial;
   }
   
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "DATE_DERNIER_PMP", length = 23)
   public Date getDateDernierPmp() {
/*  783 */     return this.dateDernierPmp;
   }
   
   public void setDateDernierPmp(Date dateDernierPmp) {
/*  787 */     this.dateDernierPmp = dateDernierPmp;
   }
   
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "DATE_LIMITE_STOCKAGE", length = 23)
   public Date getDateLimiteStockage() {
/*  793 */     return this.dateLimiteStockage;
   }
   
   public void setDateLimiteStockage(Date dateLimiteStockage) {
/*  797 */     this.dateLimiteStockage = dateLimiteStockage;
   }
   
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "DATE_CREATION", length = 23)
   public Date getDateCreation() {
/*  803 */     return this.dateCreation;
   }
   
   public void setDateCreation(Date dateCreation) {
/*  807 */     this.dateCreation = dateCreation;
   }
   
   @Column(name = "UTILISATEUR_CREAT", length = 30)
   public String getUtilisateurCreat() {
/*  812 */     return this.utilisateurCreat;
   }
   
   public void setUtilisateurCreat(String utilisateurCreat) {
/*  816 */     this.utilisateurCreat = utilisateurCreat;
   }
   
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "DATE_MODIFICATION", length = 23)
   public Date getDateModification() {
/*  822 */     return this.dateModification;
   }
   
   public void setDateModification(Date dateModification) {
/*  826 */     this.dateModification = dateModification;
   }
   
   @Column(name = "UTILISATEUR_MODIF", length = 30)
   public String getUtilisateurModif() {
/*  831 */     return this.utilisateurModif;
   }
   
   public void setUtilisateurModif(String utilisateurModif) {
/*  835 */     this.utilisateurModif = utilisateurModif;
   }
   
   @Column(name = "DELAI_EXISTENCE")
   public Integer getDelaiExistence() {
/*  840 */     return this.delaiExistence;
   }
   
   public void setDelaiExistence(Integer delaiExistence) {
/*  844 */     this.delaiExistence = delaiExistence;
   }
   
   @Column(name = "RECEPTION")
   public Boolean getReception() {
/*  849 */     return this.reception;
   }
   
   public void setReception(Boolean reception) {
/*  853 */     this.reception = reception;
   }
   
   @Column(name = "COMMANDE_FRS")
   public Boolean getCommandeFrs() {
/*  858 */     return this.commandeFrs;
   }
   
   public void setCommandeFrs(Boolean commandeFrs) {
/*  862 */     this.commandeFrs = commandeFrs;
   }
   
   @Column(name = "COMMANDE")
   public Boolean getCommande() {
/*  867 */     return this.commande;
   }
   
   public void setCommande(Boolean commande) {
/*  871 */     this.commande = commande;
   }
   
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "DATE_BLOQUE", length = 23)
   public Date getDateBloque() {
/*  877 */     return this.dateBloque;
   }
   
   public void setDateBloque(Date dateBloque) {
/*  881 */     this.dateBloque = dateBloque;
   }
   
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "DATE_VISIBLE", length = 23)
   public Date getDateVisible() {
/*  887 */     return this.dateVisible;
   }
   
   public void setDateVisible(Date dateVisible) {
/*  891 */     this.dateVisible = dateVisible;
   }
   
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "DATE_BLQ_LIV", length = 23)
   public Date getDateBlqLiv() {
/*  897 */     return this.dateBlqLiv;
   }
   
   public void setDateBlqLiv(Date dateBlqLiv) {
/*  901 */     this.dateBlqLiv = dateBlqLiv;
   }
   
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "DATE_BLQ_REC", length = 23)
   public Date getDateBlqRec() {
/*  907 */     return this.dateBlqRec;
   }
   
   public void setDateBlqRec(Date dateBlqRec) {
/*  911 */     this.dateBlqRec = dateBlqRec;
   }
   
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "DATE_BLQ_CMD", length = 23)
   public Date getDateBlqCmd() {
/*  917 */     return this.dateBlqCmd;
   }
   
   public void setDateBlqCmd(Date dateBlqCmd) {
/*  921 */     this.dateBlqCmd = dateBlqCmd;
   }
   
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "DATE_BLQ_CMD_FRS", length = 23)
   public Date getDateBlqCmdFrs() {
/*  927 */     return this.dateBlqCmdFrs;
   }
   
   public void setDateBlqCmdFrs(Date dateBlqCmdFrs) {
/*  931 */     this.dateBlqCmdFrs = dateBlqCmdFrs;
   }
   
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "DATE_BLQ_VENTE", length = 23)
   public Date getDateBlqVente() {
/*  937 */     return this.dateBlqVente;
   }
   
   public void setDateBlqVente(Date dateBlqVente) {
/*  941 */     this.dateBlqVente = dateBlqVente;
   }
   
   @Column(name = "POIDS", precision = 18, scale = 3)
   public BigDecimal getPoids() {
/*  946 */     return this.poids;
   }
   
   public void setPoids(BigDecimal poids) {
/*  950 */     this.poids = poids;
   }
   
   @Column(name = "VOLUME", precision = 18, scale = 3)
   public BigDecimal getVolume() {
/*  955 */     return this.volume;
   }
   
   public void setVolume(BigDecimal volume) {
/*  959 */     this.volume = volume;
   }
   
   @Column(name = "LONGUEUR", precision = 18, scale = 3)
   public BigDecimal getLongueur() {
/*  964 */     return this.longueur;
   }
   
   public void setLongueur(BigDecimal longueur) {
/*  968 */     this.longueur = longueur;
   }
   
   @Column(name = "LARGEUR", precision = 18, scale = 3)
   public BigDecimal getLargeur() {
/*  973 */     return this.largeur;
   }
   
   public void setLargeur(BigDecimal largeur) {
/*  977 */     this.largeur = largeur;
   }
   
   @Column(name = "HAUTEUR", precision = 18, scale = 3)
   public BigDecimal getHauteur() {
/*  982 */     return this.hauteur;
   }
   
   public void setHauteur(BigDecimal hauteur) {
/*  986 */     this.hauteur = hauteur;
   }
   
   @Column(name = "PRIX_VENTE1_HT", precision = 10)
   public BigDecimal getPrixVente1Ht() {
/*  991 */     return this.prixVente1Ht;
   }
   
   public void setPrixVente1Ht(BigDecimal prixVente1Ht) {
/*  995 */     this.prixVente1Ht = prixVente1Ht;
   }
   
   @Column(name = "PRIX_VENTE1_TTC", precision = 10)
   public BigDecimal getPrixVente1Ttc() {
/* 1000 */     return this.prixVente1Ttc;
   }
   
   public void setPrixVente1Ttc(BigDecimal prixVente1Ttc) {
/* 1004 */     this.prixVente1Ttc = prixVente1Ttc;
   }
   
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "DATE_PRIX_VENTE1", length = 23)
   public Date getDatePrixVente1() {
/* 1010 */     return this.datePrixVente1;
   }
   
   public void setDatePrixVente1(Date datePrixVente1) {
/* 1014 */     this.datePrixVente1 = datePrixVente1;
   }
   
   @Column(name = "PRIX_VENTE2_HT", precision = 10)
   public BigDecimal getPrixVente2Ht() {
/* 1019 */     return this.prixVente2Ht;
   }
   
   public void setPrixVente2Ht(BigDecimal prixVente2Ht) {
/* 1023 */     this.prixVente2Ht = prixVente2Ht;
   }
   
   @Column(name = "PRIX_VENTE2_TTC", precision = 10)
   public BigDecimal getPrixVente2Ttc() {
/* 1028 */     return this.prixVente2Ttc;
   }
   
   public void setPrixVente2Ttc(BigDecimal prixVente2Ttc) {
/* 1032 */     this.prixVente2Ttc = prixVente2Ttc;
   }
   
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "DATE_PRIX_VENTE2", length = 23)
   public Date getDatePrixVente2() {
/* 1038 */     return this.datePrixVente2;
   }
   
   public void setDatePrixVente2(Date datePrixVente2) {
/* 1042 */     this.datePrixVente2 = datePrixVente2;
   }
   
   @Column(name = "PRIX_VENTE3_HT", precision = 10)
   public BigDecimal getPrixVente3Ht() {
/* 1047 */     return this.prixVente3Ht;
   }
   
   public void setPrixVente3Ht(BigDecimal prixVente3Ht) {
/* 1051 */     this.prixVente3Ht = prixVente3Ht;
   }
   
   @Column(name = "PRIX_VENTE3_TTC", precision = 10)
   public BigDecimal getPrixVente3Ttc() {
/* 1056 */     return this.prixVente3Ttc;
   }
   
   public void setPrixVente3Ttc(BigDecimal prixVente3Ttc) {
/* 1060 */     this.prixVente3Ttc = prixVente3Ttc;
   }
   
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "DATE_PRIX_VENTE3", length = 23)
   public Date getDatePrixVente3() {
/* 1066 */     return this.datePrixVente3;
   }
   
   public void setDatePrixVente3(Date datePrixVente3) {
/* 1070 */     this.datePrixVente3 = datePrixVente3;
   }
   
   @Column(name = "PRIX_VENTE4_HT", precision = 10)
   public BigDecimal getPrixVente4Ht() {
/* 1075 */     return this.prixVente4Ht;
   }
   
   public void setPrixVente4Ht(BigDecimal prixVente4Ht) {
/* 1079 */     this.prixVente4Ht = prixVente4Ht;
   }
   
   @Column(name = "PRIX_VENTE4_TTC", precision = 10)
   public BigDecimal getPrixVente4Ttc() {
/* 1084 */     return this.prixVente4Ttc;
   }
   
   public void setPrixVente4Ttc(BigDecimal prixVente4Ttc) {
/* 1088 */     this.prixVente4Ttc = prixVente4Ttc;
   }
   
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "DATE_PRIX_VENTE4", length = 23)
   public Date getDatePrixVente4() {
/* 1094 */     return this.datePrixVente4;
   }
   
   public void setDatePrixVente4(Date datePrixVente4) {
/* 1098 */     this.datePrixVente4 = datePrixVente4;
   }
   
   @Column(name = "DER_PRIX_VENTE_TTC", precision = 18)
   public BigDecimal getDerPrixVenteTtc() {
/* 1103 */     return this.derPrixVenteTtc;
   }
   
   public void setDerPrixVenteTtc(BigDecimal derPrixVenteTtc) {
/* 1107 */     this.derPrixVenteTtc = derPrixVenteTtc;
   }
   
   @Column(name = "PESE", nullable = false)
   public boolean isPese() {
/* 1112 */     return this.pese;
   }
   
   public void setPese(boolean pese) {
/* 1116 */     this.pese = pese;
   }
   
   @Column(name = "CODE_PRODUIT_PESE", length = 10)
   public String getCodeProduitPese() {
/* 1121 */     return this.codeProduitPese;
   }
   
   public void setCodeProduitPese(String codeProduitPese) {
/* 1125 */     this.codeProduitPese = codeProduitPese;
   }
   
   @Column(name = "PESE_POIDS_UNITE", length = 1)
   public Character getPesePoidsUnite() {
/* 1130 */     return this.pesePoidsUnite;
   }
   
   public void setPesePoidsUnite(Character pesePoidsUnite) {
/* 1134 */     this.pesePoidsUnite = pesePoidsUnite;
   }
   
   @Column(name = "TAUX_DEVISE_ACHAT", precision = 18, scale = 4)
   public BigDecimal getTauxDeviseAchat() {
/* 1139 */     return this.tauxDeviseAchat;
   }
   
   public void setTauxDeviseAchat(BigDecimal tauxDeviseAchat) {
/* 1143 */     this.tauxDeviseAchat = tauxDeviseAchat;
   }
   
   @Column(name = "DEVISE_PRIX_REVIENT", precision = 18, scale = 0)
   public Long getDevisePrixRevient() {
/* 1148 */     return this.devisePrixRevient;
   }
   
   public void setDevisePrixRevient(Long devisePrixRevient) {
/* 1152 */     this.devisePrixRevient = devisePrixRevient;
   }
   
   @Column(name = "TAUX_DEVISE_REVIENT", precision = 18, scale = 4)
   public BigDecimal getTauxDeviseRevient() {
/* 1157 */     return this.tauxDeviseRevient;
   }
   
   public void setTauxDeviseRevient(BigDecimal tauxDeviseRevient) {
/* 1161 */     this.tauxDeviseRevient = tauxDeviseRevient;
   }
   
   @Column(name = "DEVISE_PRIX_VENTE", precision = 18, scale = 0)
   public Long getDevisePrixVente() {
/* 1166 */     return this.devisePrixVente;
   }
   
   public void setDevisePrixVente(Long devisePrixVente) {
/* 1170 */     this.devisePrixVente = devisePrixVente;
   }
   
   @Column(name = "TAUX_DEVISE_VENTE", precision = 18, scale = 4)
   public BigDecimal getTauxDeviseVente() {
/* 1175 */     return this.tauxDeviseVente;
   }
   
   public void setTauxDeviseVente(BigDecimal tauxDeviseVente) {
/* 1179 */     this.tauxDeviseVente = tauxDeviseVente;
   }
   
   @Column(name = "STATUS")
   public Integer getStatus() {
/* 1184 */     return this.status;
   }
   
   public void setStatus(Integer status) {
/* 1188 */     this.status = status;
   }
   
   @Column(name = "TARIF1", precision = 18)
   public BigDecimal getTarif1() {
/* 1193 */     return this.tarif1;
   }
   
   public void setTarif1(BigDecimal tarif1) {
/* 1197 */     this.tarif1 = tarif1;
   }
   
   @Column(name = "TARIF2", precision = 18)
   public BigDecimal getTarif2() {
/* 1202 */     return this.tarif2;
   }
   
   public void setTarif2(BigDecimal tarif2) {
/* 1206 */     this.tarif2 = tarif2;
   }
   
   @Column(name = "TARIF3", precision = 18)
   public BigDecimal getTarif3() {
/* 1211 */     return this.tarif3;
   }
   
   public void setTarif3(BigDecimal tarif3) {
/* 1215 */     this.tarif3 = tarif3;
   }
   
   @Column(name = "TARIF4", precision = 18)
   public BigDecimal getTarif4() {
/* 1220 */     return this.tarif4;
   }
   
   public void setTarif4(BigDecimal tarif4) {
/* 1224 */     this.tarif4 = tarif4;
   }
   
   @Column(name = "TARIF5", precision = 18)
   public BigDecimal getTarif5() {
/* 1229 */     return this.tarif5;
   }
   
   public void setTarif5(BigDecimal tarif5) {
/* 1233 */     this.tarif5 = tarif5;
   }
   
   @Column(name = "TARIF6", precision = 18)
   public BigDecimal getTarif6() {
/* 1238 */     return this.tarif6;
   }
   
   public void setTarif6(BigDecimal tarif6) {
/* 1242 */     this.tarif6 = tarif6;
   }
   
   @Column(name = "TARIF7", precision = 18)
   public BigDecimal getTarif7() {
/* 1247 */     return this.tarif7;
   }
   
   public void setTarif7(BigDecimal tarif7) {
/* 1251 */     this.tarif7 = tarif7;
   }
   
   @Column(name = "TARIF8", precision = 18)
   public BigDecimal getTarif8() {
/* 1256 */     return this.tarif8;
   }
   
   public void setTarif8(BigDecimal tarif8) {
/* 1260 */     this.tarif8 = tarif8;
   }
   
   @Column(name = "TARIF9", precision = 18)
   public BigDecimal getTarif9() {
/* 1265 */     return this.tarif9;
   }
   
   public void setTarif9(BigDecimal tarif9) {
/* 1269 */     this.tarif9 = tarif9;
   }
   
   @Column(name = "TARIF10", precision = 18)
   public BigDecimal getTarif10() {
/* 1274 */     return this.tarif10;
   }
   
   public void setTarif10(BigDecimal tarif10) {
/* 1278 */     this.tarif10 = tarif10;
   }
   
   @Column(name = "Unite_Stockage", precision = 18, scale = 0)
   public Long getUniteStockage() {
/* 1283 */     return this.uniteStockage;
   }
   
   public void setUniteStockage(Long uniteStockage) {
/* 1287 */     this.uniteStockage = uniteStockage;
   }
   
   @Column(name = "DEGRE", precision = 18, scale = 3)
   public BigDecimal getDegre() {
/* 1292 */     return this.degre;
   }
   
   public void setDegre(BigDecimal degre) {
/* 1296 */     this.degre = degre;
   }
   
   @Column(name = "COMPLEMENT")
   public Integer getComplement() {
/* 1301 */     return this.complement;
   }
   
   public void setComplement(Integer complement) {
/* 1305 */     this.complement = complement;
   }
   
   @OneToMany(fetch = FetchType.LAZY, mappedBy = "stkProduitsGenerique")
   public Set<StkPrdDim> getStkPrdDims() {
/* 1310 */     return this.stkPrdDims;
   }
   
   public void setStkPrdDims(Set<StkPrdDim> stkPrdDims) {
/* 1314 */     this.stkPrdDims = stkPrdDims;
   }
 }

