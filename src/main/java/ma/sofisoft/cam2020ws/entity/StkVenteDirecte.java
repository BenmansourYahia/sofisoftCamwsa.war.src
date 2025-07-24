 package ma.sofisoft.cam2020ws.entity;
 
 import com.fasterxml.jackson.annotation.JsonIgnore;
 import com.fasterxml.jackson.databind.annotation.JsonSerialize;
 import java.io.Serializable;
 import java.math.BigDecimal;
 import java.util.Date;
 import java.util.HashSet;
 import java.util.Set;
 import javax.persistence.AttributeOverride;
 import javax.persistence.AttributeOverrides;
 import javax.persistence.CascadeType;
 import javax.persistence.Column;
 import javax.persistence.EmbeddedId;
 import javax.persistence.Entity;
 import javax.persistence.FetchType;
 import javax.persistence.OneToMany;
 import javax.persistence.Table;
 import javax.persistence.Temporal;
 import javax.persistence.TemporalType;
 import javax.persistence.Transient;
 import ma.sofisoft.cam2020ws.entity.LineVenteDirect;
 import ma.sofisoft.cam2020ws.entity.StkVenteDirecteId;
 import org.hibernate.annotations.CreationTimestamp;
 import org.hibernate.annotations.Immutable;
 
 

 
 @JsonSerialize
 @Entity
 @Table(name = "STK_VENTE_DIRECTE")
 @Immutable
 public class StkVenteDirecte
   implements Serializable
 {
   private StkVenteDirecteId id;
   @JsonIgnore
   private long numVendeur;
   @JsonIgnore
   private long codeDepot;
   private Date dateMvt;
   @JsonIgnore
   private BigDecimal montantHt;
   @JsonIgnore
   private BigDecimal montantRemise;
   @JsonIgnore
   private BigDecimal montantTva;
   private String numVente;
   @JsonIgnore
   private Long numUtilisateur;
   @JsonIgnore
   private Integer typevente;
   private BigDecimal montantTtc;
   @JsonIgnore
   private BigDecimal mntremisepromo;
   @JsonIgnore
   private BigDecimal erreurcaisse;
   private BigDecimal tauxRemise;
   @JsonIgnore
   private Long numClient;
   @JsonIgnore
   private Short numCaisse;
   @JsonIgnore
   private Long numVenteRetour;
   @JsonIgnore
   private BigDecimal montantReste;
   @JsonIgnore
   private BigDecimal acompte;
   @JsonIgnore
   private String observation;
   @JsonIgnore
   private long numJournee;
   @JsonIgnore
   private BigDecimal montantRendu;
   @JsonIgnore
   private Long numAvoirPromo;
   @JsonIgnore
   private Long numMagasinClient;
   @JsonIgnore
   private Long numPromoProvoque;
   @JsonIgnore
   private long lieuSaisie;
   @JsonIgnore
   private String typeMvt;
   @JsonIgnore
   private int majStk;
   private int sensStk;
   @JsonIgnore
   private int majResa;
   private Set<LineVenteDirect> lineVenteDirects = new HashSet<>(); @JsonIgnore private int import_; @JsonIgnore private int dedResa; @JsonIgnore private int dedLivr; @JsonIgnore private Long numMotif; @JsonIgnore private BigDecimal montantHtPays; @JsonIgnore private BigDecimal montantRemisePays; @JsonIgnore private BigDecimal montantTvaPays; @JsonIgnore private BigDecimal montantTtcPays; @JsonIgnore private BigDecimal mntremisepromoPays; @JsonIgnore private BigDecimal montantRestePays; @JsonIgnore private BigDecimal montantRenduPays; @JsonIgnore private Long numDevise; @JsonIgnore private BigDecimal tauxDevise; @JsonIgnore private Integer uniteDevise; @JsonIgnore private String codeRemise; @JsonIgnore private Character statusFacture; @JsonIgnore private String numFacture; @JsonIgnore private Long numJourneeCaissier; @JsonIgnore private Date datetimeCreation; @JsonIgnore private String codeActionPrincipale; @JsonIgnore private BigDecimal droitTimbre; @JsonIgnore private String codePlvEncours; @JsonIgnore private BigDecimal baseRemise; @JsonIgnore
   private BigDecimal tauxRemiseAccorde; @JsonIgnore
   private String typeTypeMvt; @JsonIgnore
   private String codeUtilisateurAutorise; @JsonIgnore
   private String indexChaises; @JsonIgnore
   private Integer pointsFidelite; @JsonIgnore
   private int hour; @JsonIgnore
   private Integer nmbreTicket; private int numMvt; private long numMagasin; @Column(name = "NUM_MVT", insertable = false, updatable = false, nullable = false)
   public int getNumMvt() { return this.numMvt; }
 
   
   public void setNumMvt(int numMvt) {
/* 125 */     this.numMvt = numMvt;
   }
   
   @Column(name = "NUM_MAGASIN", insertable = false, updatable = false, nullable = false, precision = 10, scale = 0)
   public long getNumMagasin() {
/* 130 */     return this.numMagasin;
   }
   
   public void setNumMagasin(long numMagasin) {
/* 134 */     this.numMagasin = numMagasin;
   }
 
 
   
   public StkVenteDirecte() {}
 
   
   public StkVenteDirecte(StkVenteDirecteId id, long numVendeur, long codeDepot, String numVente, long numJournee, long lieuSaisie, String typeMvt, int majStk, int sensStk, int majResa, int import_, int dedResa, int dedLivr) {
     this.id = id;
     this.numVendeur = numVendeur;
    this.codeDepot = codeDepot;
    this.numVente = numVente;
    this.numJournee = numJournee;
     this.lieuSaisie = lieuSaisie;
     this.typeMvt = typeMvt;
     this.majStk = majStk;
    this.sensStk = sensStk;
    this.majResa = majResa;
    this.import_ = import_;
     this.dedResa = dedResa;
     this.dedLivr = dedLivr;
   }
 
 
 
 
 
   
   public StkVenteDirecte(StkVenteDirecteId id, Date dateMvt, String numVente, BigDecimal montantTtc, BigDecimal tauxRemise, int sensStk) {
     this.id = id;
     this.dateMvt = dateMvt;
     this.numVente = numVente;
     this.montantTtc = montantTtc;
     this.tauxRemise = tauxRemise;
    this.sensStk = sensStk;
   }
 

   
   public StkVenteDirecte(StkVenteDirecteId id, long numVendeur, long codeDepot, Date dateMvt, BigDecimal montantHt, BigDecimal montantRemise, BigDecimal montantTva, String numVente, Long numUtilisateur, Integer typevente, BigDecimal montantTtc, BigDecimal mntremisepromo, BigDecimal erreurcaisse, BigDecimal tauxRemise, Long numClient, Short numCaisse, Long numVenteRetour, BigDecimal montantReste, BigDecimal acompte, String observation, long numJournee, BigDecimal montantRendu, Long numAvoirPromo, Long numMagasinClient, Long numPromoProvoque, long lieuSaisie, String typeMvt, int majStk, int sensStk, int majResa, int import_, int dedResa, int dedLivr, Long numMotif, BigDecimal montantHtPays, BigDecimal montantRemisePays, BigDecimal montantTvaPays, BigDecimal montantTtcPays, BigDecimal mntremisepromoPays, BigDecimal montantRestePays, BigDecimal montantRenduPays, Long numDevise, BigDecimal tauxDevise, Integer uniteDevise, String codeRemise, Character statusFacture, String numFacture, Long numJourneeCaissier, Date datetimeCreation, String codeActionPrincipale, BigDecimal droitTimbre, String codePlvEncours, BigDecimal baseRemise, BigDecimal tauxRemiseAccorde, String typeTypeMvt, String codeUtilisateurAutorise, String indexChaises, Integer pointsFidelite) {
   this.id = id;
     this.numVendeur = numVendeur;
     this.codeDepot = codeDepot;
    this.dateMvt = dateMvt;
    this.montantHt = montantHt;
    this.montantRemise = montantRemise;
    this.montantTva = montantTva;
     this.numVente = numVente;
     this.numUtilisateur = numUtilisateur;
     this.typevente = typevente;
     this.montantTtc = montantTtc;
     this.mntremisepromo = mntremisepromo;
     this.erreurcaisse = erreurcaisse;
    this.tauxRemise = tauxRemise;
    this.numClient = numClient;
     this.numCaisse = numCaisse;
     this.numVenteRetour = numVenteRetour;
   this.montantReste = montantReste;
     this.acompte = acompte;
    this.observation = observation;
    this.numJournee = numJournee;
    this.montantRendu = montantRendu;
    this.numAvoirPromo = numAvoirPromo;
    this.numMagasinClient = numMagasinClient;
    this.numPromoProvoque = numPromoProvoque;
    this.lieuSaisie = lieuSaisie;
    this.typeMvt = typeMvt;
    this.majStk = majStk;
    this.sensStk = sensStk;
     this.majResa = majResa;
     this.import_ = import_;
     this.dedResa = dedResa;
    this.dedLivr = dedLivr;
     this.numMotif = numMotif;
    this.montantHtPays = montantHtPays;
    this.montantRemisePays = montantRemisePays;
     this.montantTvaPays = montantTvaPays;
     this.montantTtcPays = montantTtcPays;
     this.mntremisepromoPays = mntremisepromoPays;
     this.montantRestePays = montantRestePays;
    this.montantRenduPays = montantRenduPays;
    this.numDevise = numDevise;
    this.tauxDevise = tauxDevise;
     this.uniteDevise = uniteDevise;
    this.codeRemise = codeRemise;
     this.statusFacture = statusFacture;
    this.numFacture = numFacture;
    this.numJourneeCaissier = numJourneeCaissier;
     this.datetimeCreation = datetimeCreation;
     this.codeActionPrincipale = codeActionPrincipale;
     this.droitTimbre = droitTimbre;
    this.codePlvEncours = codePlvEncours;
    this.baseRemise = baseRemise;
    this.tauxRemiseAccorde = tauxRemiseAccorde;
    this.typeTypeMvt = typeTypeMvt;
    this.codeUtilisateurAutorise = codeUtilisateurAutorise;
    this.indexChaises = indexChaises;
     this.pointsFidelite = pointsFidelite;
   }
   
   public StkVenteDirecte(Date dateMvt, BigDecimal MontantTTC, int hour) {
    this.dateMvt = dateMvt;
     this.hour = hour;
     this.montantTtc = MontantTTC;
   }
 
 
 
   
   @EmbeddedId
   @AttributeOverrides({@AttributeOverride(name = "numMvt", column = @Column(name = "NUM_MVT", nullable = false)), @AttributeOverride(name = "numMagasin", column = @Column(name = "NUM_MAGASIN", nullable = false, precision = 10, scale = 0))})
   public StkVenteDirecteId getId() {
/* 258 */     return this.id;
   }
   
   public void setId(StkVenteDirecteId id) {
/* 262 */     this.id = id;
   }
 
 
   
   @Column(name = "NUM_VENDEUR", length = 23)
   public long getVendeurMag() {
/* 269 */     return this.numVendeur;
   }
   
   public void setVendeurMag(long vendeurMag) {
/* 273 */     this.numVendeur = vendeurMag;
   }
   
   @Column(name = "CODE_DEPOT", nullable = false, precision = 10, scale = 0)
   public long getCodeDepot() {
/* 278 */     return this.codeDepot;
   }
   
   public void setCodeDepot(long codeDepot) {
/* 282 */     this.codeDepot = codeDepot;
   }
   
   @CreationTimestamp
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "DATE_MVT", length = 23)
   public Date getDateMvt() {
/* 289 */     return this.dateMvt;
   }
   
   public void setDateMvt(Date dateMvt) {
/* 293 */     this.dateMvt = dateMvt;
   }
   
   @Column(name = "MONTANT_HT", precision = 18, scale = 3)
   public BigDecimal getMontantHt() {
/* 298 */     return this.montantHt;
   }
   
   public void setMontantHt(BigDecimal montantHt) {
/* 302 */     this.montantHt = montantHt;
   }
   
   @Column(name = "MONTANT_REMISE", precision = 10)
   public BigDecimal getMontantRemise() {
/* 307 */     return this.montantRemise;
   }
   
   public void setMontantRemise(BigDecimal montantRemise) {
/* 311 */     this.montantRemise = montantRemise;
   }
   
   @Column(name = "MONTANT_TVA", precision = 18, scale = 3)
   public BigDecimal getMontantTva() {
/* 316 */     return this.montantTva;
   }
   
   public void setMontantTva(BigDecimal montantTva) {
/* 320 */     this.montantTva = montantTva;
   }
   
   @Column(name = "NUM_VENTE", nullable = false, length = 15)
   public String getNumVente() {
/* 325 */     return this.numVente;
   }
   
   public void setNumVente(String numVente) {
/* 329 */     this.numVente = numVente;
   }
   
   @Column(name = "NUM_UTILISATEUR", precision = 10, scale = 0)
   public Long getNumUtilisateur() {
/* 334 */     return this.numUtilisateur;
   }
   
   public void setNumUtilisateur(Long numUtilisateur) {
/* 338 */     this.numUtilisateur = numUtilisateur;
   }
   
   @Column(name = "TYPEVENTE")
   public Integer getTypevente() {
/* 343 */     return this.typevente;
   }
   
   public void setTypevente(Integer typevente) {
/* 347 */     this.typevente = typevente;
   }
   
   @Column(name = "MONTANT_TTC", precision = 10)
   public BigDecimal getMontantTtc() {
/* 352 */     return this.montantTtc;
   }
   
   public void setMontantTtc(BigDecimal montantTtc) {
/* 356 */     this.montantTtc = montantTtc;
   }
   
   @Column(name = "MNTREMISEPROMO", precision = 10)
   public BigDecimal getMntremisepromo() {
/* 361 */     return this.mntremisepromo;
   }
   
   public void setMntremisepromo(BigDecimal mntremisepromo) {
/* 365 */     this.mntremisepromo = mntremisepromo;
   }
   
   @Column(name = "ERREURCAISSE", precision = 10)
   public BigDecimal getErreurcaisse() {
/* 370 */     return this.erreurcaisse;
   }
   
   public void setErreurcaisse(BigDecimal erreurcaisse) {
/* 374 */     this.erreurcaisse = erreurcaisse;
   }
   
   @Column(name = "TAUX_REMISE", precision = 10, scale = 4)
   public BigDecimal getTauxRemise() {
/* 379 */     return this.tauxRemise;
   }
   
   public void setTauxRemise(BigDecimal tauxRemise) {
/* 383 */     this.tauxRemise = tauxRemise;
   }
   
   @Column(name = "NUM_CLIENT", precision = 10, scale = 0)
   public Long getNumClient() {
/* 388 */     return this.numClient;
   }
   
   public void setNumClient(Long numClient) {
/* 392 */     this.numClient = numClient;
   }
   
   @Column(name = "NUM_CAISSE", precision = 3, scale = 0)
   public Short getNumCaisse() {
/* 397 */     return this.numCaisse;
   }
   
   public void setNumCaisse(Short numCaisse) {
/* 401 */     this.numCaisse = numCaisse;
   }
   
   @Column(name = "NUM_VENTE_RETOUR", precision = 10, scale = 0)
   public Long getNumVenteRetour() {
/* 406 */     return this.numVenteRetour;
   }
   
   public void setNumVenteRetour(Long numVenteRetour) {
/* 410 */     this.numVenteRetour = numVenteRetour;
   }
   
   @Column(name = "MONTANT_RESTE", precision = 10)
   public BigDecimal getMontantReste() {
/* 415 */     return this.montantReste;
   }
   
   public void setMontantReste(BigDecimal montantReste) {
/* 419 */     this.montantReste = montantReste;
   }
   
   @Column(name = "ACOMPTE", precision = 10)
   public BigDecimal getAcompte() {
/* 424 */     return this.acompte;
   }
   
   public void setAcompte(BigDecimal acompte) {
/* 428 */     this.acompte = acompte;
   }
   
   @Column(name = "OBSERVATION", length = 50)
   public String getObservation() {
/* 433 */     return this.observation;
   }
   
   public void setObservation(String observation) {
/* 437 */     this.observation = observation;
   }
   
   @Column(name = "NUM_JOURNEE", nullable = false, precision = 18, scale = 0)
   public long getNumJournee() {
/* 442 */     return this.numJournee;
   }
   
   public void setNumJournee(long numJournee) {
/* 446 */     this.numJournee = numJournee;
   }
   
   @Column(name = "MONTANT_RENDU", precision = 18)
   public BigDecimal getMontantRendu() {
/* 451 */     return this.montantRendu;
   }
   
   public void setMontantRendu(BigDecimal montantRendu) {
/* 455 */     this.montantRendu = montantRendu;
   }
   
   @Column(name = "NUM_AVOIR_PROMO", precision = 18, scale = 0)
   public Long getNumAvoirPromo() {
/* 460 */     return this.numAvoirPromo;
   }
   
   public void setNumAvoirPromo(Long numAvoirPromo) {
/* 464 */     this.numAvoirPromo = numAvoirPromo;
   }
   
   @Column(name = "NUM_MAGASIN_CLIENT", precision = 10, scale = 0)
   public Long getNumMagasinClient() {
/* 469 */     return this.numMagasinClient;
   }
   
   public void setNumMagasinClient(Long numMagasinClient) {
/* 473 */     this.numMagasinClient = numMagasinClient;
   }
   
   @Column(name = "NUM_PROMO_PROVOQUE", precision = 10, scale = 0)
   public Long getNumPromoProvoque() {
/* 478 */     return this.numPromoProvoque;
   }
   
   public void setNumPromoProvoque(Long numPromoProvoque) {
/* 482 */     this.numPromoProvoque = numPromoProvoque;
   }
   
   @Column(name = "LIEU_SAISIE", nullable = false, precision = 18, scale = 0)
   public long getLieuSaisie() {
/* 487 */     return this.lieuSaisie;
   }
   
   public void setLieuSaisie(long lieuSaisie) {
/* 491 */     this.lieuSaisie = lieuSaisie;
   }
   
   @Column(name = "TYPE_MVT", nullable = false, length = 10)
   public String getTypeMvt() {
/* 496 */     return this.typeMvt;
   }
   
   public void setTypeMvt(String typeMvt) {
/* 500 */     this.typeMvt = typeMvt;
   }
   
   @Column(name = "MAJ_STK", nullable = false)
   public int getMajStk() {
/* 505 */     return this.majStk;
   }
   
   public void setMajStk(int majStk) {
/* 509 */     this.majStk = majStk;
   }
   
   @Column(name = "SENS_STK", nullable = false)
   public int getSensStk() {
/* 514 */     return this.sensStk;
   }
   
   public void setSensStk(int sensStk) {
/* 518 */     this.sensStk = sensStk;
   }
   
   @Column(name = "MAJ_RESA", nullable = false)
   public int getMajResa() {
/* 523 */     return this.majResa;
   }
   
   public void setMajResa(int majResa) {
/* 527 */     this.majResa = majResa;
   }
   
   @Column(name = "IMPORT", nullable = false)
   public int getImport_() {
/* 532 */     return this.import_;
   }
   
   public void setImport_(int import_) {
/* 536 */     this.import_ = import_;
   }
   
   @Column(name = "DED_RESA", nullable = false)
   public int getDedResa() {
/* 541 */     return this.dedResa;
   }
   
   public void setDedResa(int dedResa) {
/* 545 */     this.dedResa = dedResa;
   }
   
   @Column(name = "DED_LIVR", nullable = false)
   public int getDedLivr() {
/* 550 */     return this.dedLivr;
   }
   
   public void setDedLivr(int dedLivr) {
/* 554 */     this.dedLivr = dedLivr;
   }
   
   @Column(name = "NUM_MOTIF", precision = 18, scale = 0)
   public Long getNumMotif() {
/* 559 */     return this.numMotif;
   }
   
   public void setNumMotif(Long numMotif) {
/* 563 */     this.numMotif = numMotif;
   }
   
   @Column(name = "MONTANT_HT_PAYS", precision = 18)
   public BigDecimal getMontantHtPays() {
/* 568 */     return this.montantHtPays;
   }
   
   public void setMontantHtPays(BigDecimal montantHtPays) {
/* 572 */     this.montantHtPays = montantHtPays;
   }
   
   @Column(name = "MONTANT_REMISE_PAYS", precision = 18)
   public BigDecimal getMontantRemisePays() {
/* 577 */     return this.montantRemisePays;
   }
   
   public void setMontantRemisePays(BigDecimal montantRemisePays) {
/* 581 */     this.montantRemisePays = montantRemisePays;
   }
   
   @Column(name = "MONTANT_TVA_PAYS", precision = 18)
   public BigDecimal getMontantTvaPays() {
/* 586 */     return this.montantTvaPays;
   }
   
   public void setMontantTvaPays(BigDecimal montantTvaPays) {
/* 590 */     this.montantTvaPays = montantTvaPays;
   }
   
   @Column(name = "MONTANT_TTC_PAYS", precision = 18)
   public BigDecimal getMontantTtcPays() {
/* 595 */     return this.montantTtcPays;
   }
   
   public void setMontantTtcPays(BigDecimal montantTtcPays) {
/* 599 */     this.montantTtcPays = montantTtcPays;
   }
   
   @Column(name = "MNTREMISEPROMO_PAYS", precision = 18)
   public BigDecimal getMntremisepromoPays() {
/* 604 */     return this.mntremisepromoPays;
   }
   
   public void setMntremisepromoPays(BigDecimal mntremisepromoPays) {
/* 608 */     this.mntremisepromoPays = mntremisepromoPays;
   }
   
   @Column(name = "MONTANT_RESTE_PAYS", precision = 18)
   public BigDecimal getMontantRestePays() {
/* 613 */     return this.montantRestePays;
   }
   
   public void setMontantRestePays(BigDecimal montantRestePays) {
/* 617 */     this.montantRestePays = montantRestePays;
   }
   
   @Column(name = "MONTANT_RENDU_PAYS", precision = 18)
   public BigDecimal getMontantRenduPays() {
/* 622 */     return this.montantRenduPays;
   }
   
   public void setMontantRenduPays(BigDecimal montantRenduPays) {
/* 626 */     this.montantRenduPays = montantRenduPays;
   }
   
   @Column(name = "NUM_DEVISE", precision = 10, scale = 0)
   public Long getNumDevise() {
/* 631 */     return this.numDevise;
   }
   
   public void setNumDevise(Long numDevise) {
/* 635 */     this.numDevise = numDevise;
   }
   
   @Column(name = "TAUX_DEVISE", precision = 10, scale = 4)
   public BigDecimal getTauxDevise() {
/* 640 */     return this.tauxDevise;
   }
   
   public void setTauxDevise(BigDecimal tauxDevise) {
/* 644 */     this.tauxDevise = tauxDevise;
   }
   
   @Column(name = "UNITE_DEVISE")
   public Integer getUniteDevise() {
/* 649 */     return this.uniteDevise;
   }
   
   public void setUniteDevise(Integer uniteDevise) {
/* 653 */     this.uniteDevise = uniteDevise;
   }
   
   @Column(name = "code_remise", length = 10)
   public String getCodeRemise() {
/* 658 */     return this.codeRemise;
   }
   
   public void setCodeRemise(String codeRemise) {
/* 662 */     this.codeRemise = codeRemise;
   }
   
   @Column(name = "STATUS_FACTURE", length = 1)
   public Character getStatusFacture() {
/* 667 */     return this.statusFacture;
   }
   
   public void setStatusFacture(Character statusFacture) {
/* 671 */     this.statusFacture = statusFacture;
   }
   
   @Column(name = "NUM_FACTURE", length = 20)
   public String getNumFacture() {
/* 676 */     return this.numFacture;
   }
   
   public void setNumFacture(String numFacture) {
/* 680 */     this.numFacture = numFacture;
   }
   
   @Column(name = "NUM_JOURNEE_CAISSIER", precision = 18, scale = 0)
   public Long getNumJourneeCaissier() {
/* 685 */     return this.numJourneeCaissier;
   }
   
   public void setNumJourneeCaissier(Long numJourneeCaissier) {
/* 689 */     this.numJourneeCaissier = numJourneeCaissier;
   }
   
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "DATETIME_CREATION", length = 23)
   public Date getDatetimeCreation() {
/* 695 */     return this.datetimeCreation;
   }
   
   public void setDatetimeCreation(Date datetimeCreation) {
/* 699 */     this.datetimeCreation = datetimeCreation;
   }
   
   @Column(name = "CODE_ACTION_PRINCIPALE", length = 20)
   public String getCodeActionPrincipale() {
/* 704 */     return this.codeActionPrincipale;
   }
   
   public void setCodeActionPrincipale(String codeActionPrincipale) {
/* 708 */     this.codeActionPrincipale = codeActionPrincipale;
   }
   
   @Column(name = "DROIT_TIMBRE", precision = 18)
   public BigDecimal getDroitTimbre() {
/* 713 */     return this.droitTimbre;
   }
   
   public void setDroitTimbre(BigDecimal droitTimbre) {
/* 717 */     this.droitTimbre = droitTimbre;
   }
   
   @Column(name = "CODE_PLV_ENCOURS", length = 20)
   public String getCodePlvEncours() {
/* 722 */     return this.codePlvEncours;
   }
   
   public void setCodePlvEncours(String codePlvEncours) {
/* 726 */     this.codePlvEncours = codePlvEncours;
   }
   
   @Column(name = "BASE_REMISE", precision = 10)
   public BigDecimal getBaseRemise() {
/* 731 */     return this.baseRemise;
   }
   
   public void setBaseRemise(BigDecimal baseRemise) {
/* 735 */     this.baseRemise = baseRemise;
   }
   
   @Column(name = "TAUX_REMISE_ACCORDE", precision = 10, scale = 4)
   public BigDecimal getTauxRemiseAccorde() {
/* 740 */     return this.tauxRemiseAccorde;
   }
   
   public void setTauxRemiseAccorde(BigDecimal tauxRemiseAccorde) {
/* 744 */     this.tauxRemiseAccorde = tauxRemiseAccorde;
   }
   
   @Column(name = "TYPE_TYPE_MVT")
   public String getTypeTypeMvt() {
/* 749 */     return this.typeTypeMvt;
   }
   
   public void setTypeTypeMvt(String typeTypeMvt) {
/* 753 */     this.typeTypeMvt = typeTypeMvt;
   }
   
   @Column(name = "CODE_UTILISATEUR_AUTORISE")
   public String getCodeUtilisateurAutorise() {
/* 758 */     return this.codeUtilisateurAutorise;
   }
   
   public void setCodeUtilisateurAutorise(String codeUtilisateurAutorise) {
/* 762 */     this.codeUtilisateurAutorise = codeUtilisateurAutorise;
   }
   
   @Column(name = "INDEX_CHAISES")
   public String getIndexChaises() {
/* 767 */     return this.indexChaises;
   }
   
   public void setIndexChaises(String indexChaises) {
/* 771 */     this.indexChaises = indexChaises;
   }
   
   @Column(name = "POINTS_FIDELITE")
   public Integer getPointsFidelite() {
/* 776 */     return this.pointsFidelite;
   }
   
   public void setPointsFidelite(Integer pointsFidelite) {
/* 780 */     this.pointsFidelite = pointsFidelite;
   }
   
   @Transient
   public int getHour() {
/* 785 */     return this.hour;
   }
   
   public void setHour(int hour) {
/* 789 */     this.hour = hour;
   }
   
   @Transient
   public Integer getNmbreTicket() {
/* 794 */     return this.nmbreTicket;
   }
   
   public void setNmbreTicket(Integer nmbreTicket) {
/* 798 */     this.nmbreTicket = nmbreTicket;
   }
   
   @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy = "stkVenteDirecte")
   public Set<LineVenteDirect> getLineVenteDirects() {
/* 803 */     return this.lineVenteDirects;
   }
   
   public void setLineVenteDirects(Set<LineVenteDirect> lineVenteDirects) {
/* 807 */     this.lineVenteDirects = lineVenteDirects;
   }
 }

