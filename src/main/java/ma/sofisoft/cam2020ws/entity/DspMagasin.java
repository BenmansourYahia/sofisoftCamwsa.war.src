 package ma.sofisoft.cam2020ws.entity;
 
 import java.io.Serializable;
 import java.math.BigDecimal;
 import java.util.Date;
 import javax.persistence.Column;
 import javax.persistence.Entity;
 import javax.persistence.Id;
 import javax.persistence.Table;
 import javax.persistence.Temporal;
 import javax.persistence.TemporalType;
 import javax.persistence.UniqueConstraint;
 
 
 
 
 
 @Entity
 @Table(name = "DSP_MAGASIN", uniqueConstraints = {@UniqueConstraint(columnNames = {"CODE_MAGASIN"})})
 public class DspMagasin
   implements Serializable
 {
   private long numMagasin;
   private Integer numSociete;
   private Byte codeCategorie;
   private long numDevise;
   private long cptNumDevise;
   private Long numPaiement;
   private String codeMagasin;
   private String adresse;
   private String ville;
   private String pays;
   private String telephone;
   private String fax;
   private String EMail;
   private String webPage;
   private Integer bloque;
   private String gerant;
   private Integer status;
   private int informatique;
   private Integer nbrLivraison;
   private BigDecimal caAnneePrec;
   private BigDecimal caAnnee;
   private BigDecimal caMois;
   private BigDecimal encours;
   private Integer gererStock;
   private String nomMagasin;
   private String observations;
   private BigDecimal pourcentage;
   private Integer priorite;
   private int typeFacturation;
   private BigDecimal superficie;
   private Long numCompte;
   private Long numRepresentant;
   private String osSerialNumber;
   private String diskSerialNumber;
   private String softCode;
   private String region;
   private String localite;
   private String mobile;
   private String prefixeCodeCmd;
   private String compteurCodeCmd;
   private String prefixeCodeLiv;
   private String compteurCodeLiv;
   private String prefixeCodeFac;
   private String compteurCodeFac;
   private String prefixeCodeReg;
   private String compteurCodeReg;
   private String prefixeCodeRet;
   private String compteurCodeRet;
   private String prefixeCodeAvr;
   private String compteurCodeAvr;
   private String prefixeCodeEch;
   private String compteurCodeEch;
   private int venteHt;
   private int prixVntCatMag;
   private int regMultiDevise;
   private int renduMultiDevise;
   private Integer numRegion;
   private Integer numLocalite;
   private Integer numVille;
   private Date dateOuverture;
   private Long numCompteAuxiliaire;
   private Integer updateBasePos;
   private Integer updatePrgPos;
   private String photoMagasin;
   private Date dateFermeture;
   private BigDecimal coordLongitude;
   private BigDecimal coordLatitude;
   private Integer entrepot;
   private Date dateSurfaceEgale;
   private Integer gereCarManuel;
   private String ice;
   
   public DspMagasin() {}
   
   public DspMagasin(long numMagasin, String codeMagasin, String nomMagasin) {
    this.numMagasin = numMagasin;
     this.codeMagasin = codeMagasin;
    this.nomMagasin = nomMagasin;
   }
 
   
   public DspMagasin(long numMagasin, long numDevise, long cptNumDevise, String codeMagasin, int informatique, int typeFacturation, int venteHt, int prixVntCatMag, int regMultiDevise, int renduMultiDevise) {
     this.numMagasin = numMagasin;
    this.numDevise = numDevise;
    this.cptNumDevise = cptNumDevise;
    this.codeMagasin = codeMagasin;
     this.informatique = informatique;
    this.typeFacturation = typeFacturation;
    this.venteHt = venteHt;
   this.prixVntCatMag = prixVntCatMag;
    this.regMultiDevise = regMultiDevise;
    this.renduMultiDevise = renduMultiDevise;
   }
 
 

   public DspMagasin(long numMagasin, Integer numSociete, Byte codeCategorie, long numDevise, long cptNumDevise, Long numPaiement, String codeMagasin, String adresse, String ville, String pays, String telephone, String fax, String EMail, String webPage, Integer bloque, String gerant, Integer status, int informatique, Integer nbrLivraison, BigDecimal caAnneePrec, BigDecimal caAnnee, BigDecimal caMois, BigDecimal encours, Integer gererStock, String nomMagasin, String observations, BigDecimal pourcentage, Integer priorite, int typeFacturation, BigDecimal superficie, Long numCompte, Long numRepresentant, String osSerialNumber, String diskSerialNumber, String softCode, String region, String localite, String mobile, String prefixeCodeCmd, String compteurCodeCmd, String prefixeCodeLiv, String compteurCodeLiv, String prefixeCodeFac, String compteurCodeFac, String prefixeCodeReg, String compteurCodeReg, String prefixeCodeRet, String compteurCodeRet, String prefixeCodeAvr, String compteurCodeAvr, String prefixeCodeEch, String compteurCodeEch, int venteHt, int prixVntCatMag, int regMultiDevise, int renduMultiDevise, Integer numRegion, Integer numLocalite, Integer numVille, Date dateOuverture, Long numCompteAuxiliaire, Integer updateBasePos, Integer updatePrgPos, String photoMagasin, Date dateFermeture, BigDecimal coordLongitude, BigDecimal coordLatitude, Integer entrepot, Date dateSurfaceEgale, Integer gereCarManuel, String ice) {
    this.numMagasin = numMagasin;
    this.numSociete = numSociete;
     this.codeCategorie = codeCategorie;
   this.numDevise = numDevise;
   this.cptNumDevise = cptNumDevise;
    this.numPaiement = numPaiement;
   this.codeMagasin = codeMagasin;
    this.adresse = adresse;
   this.ville = ville;
     this.pays = pays;
    this.telephone = telephone;
     this.fax = fax;
     this.EMail = EMail;
     this.webPage = webPage;
   this.bloque = bloque;
    this.gerant = gerant;
    this.status = status;
    this.informatique = informatique;
    this.nbrLivraison = nbrLivraison;
    this.caAnneePrec = caAnneePrec;
    this.caAnnee = caAnnee;
     this.caMois = caMois;
     this.encours = encours;
     this.gererStock = gererStock;
    this.nomMagasin = nomMagasin;
     this.observations = observations;
     this.pourcentage = pourcentage;
     this.priorite = priorite;
    this.typeFacturation = typeFacturation;
     this.superficie = superficie;
    this.numCompte = numCompte;
    this.numRepresentant = numRepresentant;
    this.osSerialNumber = osSerialNumber;
  this.diskSerialNumber = diskSerialNumber;
     this.softCode = softCode;
     this.region = region;
     this.localite = localite;
    this.mobile = mobile;
     this.prefixeCodeCmd = prefixeCodeCmd;
    this.compteurCodeCmd = compteurCodeCmd;
    this.prefixeCodeLiv = prefixeCodeLiv;
    this.compteurCodeLiv = compteurCodeLiv;
     this.prefixeCodeFac = prefixeCodeFac;
    this.compteurCodeFac = compteurCodeFac;
     this.prefixeCodeReg = prefixeCodeReg;
     this.compteurCodeReg = compteurCodeReg;
    this.prefixeCodeRet = prefixeCodeRet;
    this.compteurCodeRet = compteurCodeRet;
    this.prefixeCodeAvr = prefixeCodeAvr;
    this.compteurCodeAvr = compteurCodeAvr;
    this.prefixeCodeEch = prefixeCodeEch;
     this.compteurCodeEch = compteurCodeEch;
     this.venteHt = venteHt;
     this.prixVntCatMag = prixVntCatMag;
    this.regMultiDevise = regMultiDevise;
    this.renduMultiDevise = renduMultiDevise;
    this.numRegion = numRegion;
     this.numLocalite = numLocalite;
     this.numVille = numVille;
     this.dateOuverture = dateOuverture;
    this.numCompteAuxiliaire = numCompteAuxiliaire;
     this.updateBasePos = updateBasePos;
    this.updatePrgPos = updatePrgPos;
     this.photoMagasin = photoMagasin;
    this.dateFermeture = dateFermeture;
    this.coordLongitude = coordLongitude;
     this.coordLatitude = coordLatitude;
    this.entrepot = entrepot;
     this.dateSurfaceEgale = dateSurfaceEgale;
    this.gereCarManuel = gereCarManuel;
    this.ice = ice;
   }
 
   
   @Id
   @Column(name = "NUM_MAGASIN", unique = true, nullable = false, precision = 10, scale = 0)
   public long getNumMagasin() {
/* 209 */     return this.numMagasin;
   }
   
   public void setNumMagasin(long numMagasin) {
/* 213 */     this.numMagasin = numMagasin;
   }
   
   @Column(name = "NUM_SOCIETE")
   public Integer getNumSociete() {
/* 218 */     return this.numSociete;
   }
   
   public void setNumSociete(Integer numSociete) {
/* 222 */     this.numSociete = numSociete;
   }
   
   @Column(name = "CODE_CATEGORIE", precision = 2, scale = 0)
   public Byte getCodeCategorie() {
/* 227 */     return this.codeCategorie;
   }
   
   public void setCodeCategorie(Byte codeCategorie) {
/* 231 */     this.codeCategorie = codeCategorie;
   }
   
   @Column(name = "NUM_DEVISE", nullable = false, precision = 10, scale = 0)
   public long getNumDevise() {
/* 236 */     return this.numDevise;
   }
   
   public void setNumDevise(long numDevise) {
/* 240 */     this.numDevise = numDevise;
   }
   
   @Column(name = "CPT_NUM_DEVISE", nullable = false, precision = 10, scale = 0)
   public long getCptNumDevise() {
/* 245 */     return this.cptNumDevise;
   }
   
   public void setCptNumDevise(long cptNumDevise) {
/* 249 */     this.cptNumDevise = cptNumDevise;
   }
   
   @Column(name = "NUM_PAIEMENT", precision = 10, scale = 0)
   public Long getNumPaiement() {
/* 254 */     return this.numPaiement;
   }
   
   public void setNumPaiement(Long numPaiement) {
/* 258 */     this.numPaiement = numPaiement;
   }
   
   @Column(name = "CODE_MAGASIN", unique = true, nullable = false, length = 10)
   public String getCodeMagasin() {
/* 263 */     return this.codeMagasin;
   }
   
   public void setCodeMagasin(String codeMagasin) {
/* 267 */     this.codeMagasin = codeMagasin;
   }
   
   @Column(name = "ADRESSE", length = 50)
   public String getAdresse() {
/* 272 */     return this.adresse;
   }
   
   public void setAdresse(String adresse) {
/* 276 */     this.adresse = adresse;
   }
   
   @Column(name = "VILLE", length = 30)
   public String getVille() {
/* 281 */     return this.ville;
   }
   
   public void setVille(String ville) {
/* 285 */     this.ville = ville;
   }
   
   @Column(name = "PAYS", length = 30)
   public String getPays() {
/* 290 */     return this.pays;
   }
   
   public void setPays(String pays) {
/* 294 */     this.pays = pays;
   }
   
   @Column(name = "TELEPHONE", length = 30)
   public String getTelephone() {
/* 299 */     return this.telephone;
   }
   
   public void setTelephone(String telephone) {
/* 303 */     this.telephone = telephone;
   }
   
   @Column(name = "FAX", length = 30)
   public String getFax() {
/* 308 */     return this.fax;
   }
   
   public void setFax(String fax) {
/* 312 */     this.fax = fax;
   }
   
   @Column(name = "E_MAIL", length = 30)
   public String getEMail() {
/* 317 */     return this.EMail;
   }
   
   public void setEMail(String EMail) {
/* 321 */     this.EMail = EMail;
   }
   
   @Column(name = "WEB_PAGE", length = 50)
   public String getWebPage() {
/* 326 */     return this.webPage;
   }
   
   public void setWebPage(String webPage) {
/* 330 */     this.webPage = webPage;
   }
   
   @Column(name = "BLOQUE")
   public Integer getBloque() {
/* 335 */     return this.bloque;
   }
   
   public void setBloque(Integer bloque) {
/* 339 */     this.bloque = bloque;
   }
   
   @Column(name = "GERANT", length = 30)
   public String getGerant() {
/* 344 */     return this.gerant;
   }
   
   public void setGerant(String gerant) {
/* 348 */     this.gerant = gerant;
   }
   
   @Column(name = "STATUS")
   public Integer getStatus() {
/* 353 */     return this.status;
   }
   
   public void setStatus(Integer status) {
/* 357 */     this.status = status;
   }
   
   @Column(name = "INFORMATIQUE", nullable = false)
   public int getInformatique() {
/* 362 */     return this.informatique;
   }
   
   public void setInformatique(int informatique) {
/* 366 */     this.informatique = informatique;
   }
   
   @Column(name = "NBR_LIVRAISON")
   public Integer getNbrLivraison() {
/* 371 */     return this.nbrLivraison;
   }
   
   public void setNbrLivraison(Integer nbrLivraison) {
/* 375 */     this.nbrLivraison = nbrLivraison;
   }
   
   @Column(name = "CA_ANNEE_PREC", precision = 12)
   public BigDecimal getCaAnneePrec() {
/* 380 */     return this.caAnneePrec;
   }
   
   public void setCaAnneePrec(BigDecimal caAnneePrec) {
/* 384 */     this.caAnneePrec = caAnneePrec;
   }
   
   @Column(name = "CA_ANNEE", precision = 12)
   public BigDecimal getCaAnnee() {
/* 389 */     return this.caAnnee;
   }
   
   public void setCaAnnee(BigDecimal caAnnee) {
/* 393 */     this.caAnnee = caAnnee;
   }
   
   @Column(name = "CA_MOIS", precision = 10)
   public BigDecimal getCaMois() {
/* 398 */     return this.caMois;
   }
   
   public void setCaMois(BigDecimal caMois) {
/* 402 */     this.caMois = caMois;
   }
   
   @Column(name = "ENCOURS", precision = 12)
   public BigDecimal getEncours() {
/* 407 */     return this.encours;
   }
   
   public void setEncours(BigDecimal encours) {
/* 411 */     this.encours = encours;
   }
   
   @Column(name = "GERER_STOCK")
   public Integer getGererStock() {
/* 416 */     return this.gererStock;
   }
   
   public void setGererStock(Integer gererStock) {
/* 420 */     this.gererStock = gererStock;
   }
   
   @Column(name = "NOM_MAGASIN", length = 50)
   public String getNomMagasin() {
/* 425 */     return this.nomMagasin;
   }
   
   public void setNomMagasin(String nomMagasin) {
/* 429 */     this.nomMagasin = nomMagasin;
   }
   
   @Column(name = "OBSERVATIONS", length = 100)
   public String getObservations() {
/* 434 */     return this.observations;
   }
   
   public void setObservations(String observations) {
/* 438 */     this.observations = observations;
   }
   
   @Column(name = "POURCENTAGE", precision = 5)
   public BigDecimal getPourcentage() {
/* 443 */     return this.pourcentage;
   }
   
   public void setPourcentage(BigDecimal pourcentage) {
/* 447 */     this.pourcentage = pourcentage;
   }
   
   @Column(name = "PRIORITE")
   public Integer getPriorite() {
/* 452 */     return this.priorite;
   }
   
   public void setPriorite(Integer priorite) {
/* 456 */     this.priorite = priorite;
   }
   
   @Column(name = "TYPE_FACTURATION", nullable = false)
   public int getTypeFacturation() {
/* 461 */     return this.typeFacturation;
   }
   
   public void setTypeFacturation(int typeFacturation) {
/* 465 */     this.typeFacturation = typeFacturation;
   }
   
   @Column(name = "SUPERFICIE", precision = 7)
   public BigDecimal getSuperficie() {
/* 470 */     return this.superficie;
   }
   
   public void setSuperficie(BigDecimal superficie) {
/* 474 */     this.superficie = superficie;
   }
   
   @Column(name = "num_compte", precision = 10, scale = 0)
   public Long getNumCompte() {
/* 479 */     return this.numCompte;
   }
   
   public void setNumCompte(Long numCompte) {
/* 483 */     this.numCompte = numCompte;
   }
   
   @Column(name = "num_representant", precision = 18, scale = 0)
   public Long getNumRepresentant() {
/* 488 */     return this.numRepresentant;
   }
   
   public void setNumRepresentant(Long numRepresentant) {
/* 492 */     this.numRepresentant = numRepresentant;
   }
   
   @Column(name = "OS_SERIAL_NUMBER")
   public String getOsSerialNumber() {
/* 497 */     return this.osSerialNumber;
   }
   
   public void setOsSerialNumber(String osSerialNumber) {
/* 501 */     this.osSerialNumber = osSerialNumber;
   }
   
   @Column(name = "DISK_SERIAL_NUMBER")
   public String getDiskSerialNumber() {
/* 506 */     return this.diskSerialNumber;
   }
   
   public void setDiskSerialNumber(String diskSerialNumber) {
/* 510 */     this.diskSerialNumber = diskSerialNumber;
   }
   
   @Column(name = "SOFT_CODE")
   public String getSoftCode() {
/* 515 */     return this.softCode;
   }
   
   public void setSoftCode(String softCode) {
/* 519 */     this.softCode = softCode;
   }
   
   @Column(name = "REGION", length = 50)
   public String getRegion() {
/* 524 */     return this.region;
   }
   
   public void setRegion(String region) {
/* 528 */     this.region = region;
   }
   
   @Column(name = "LOCALITE", length = 50)
   public String getLocalite() {
/* 533 */     return this.localite;
   }
   
   public void setLocalite(String localite) {
/* 537 */     this.localite = localite;
   }
   
   @Column(name = "MOBILE", length = 20)
   public String getMobile() {
/* 542 */     return this.mobile;
   }
   
   public void setMobile(String mobile) {
/* 546 */     this.mobile = mobile;
   }
   
   @Column(name = "PREFIXE_CODE_CMD", length = 10)
   public String getPrefixeCodeCmd() {
/* 551 */     return this.prefixeCodeCmd;
   }
   
   public void setPrefixeCodeCmd(String prefixeCodeCmd) {
/* 555 */     this.prefixeCodeCmd = prefixeCodeCmd;
   }
   
   @Column(name = "COMPTEUR_CODE_CMD", length = 7)
   public String getCompteurCodeCmd() {
/* 560 */     return this.compteurCodeCmd;
   }
   
   public void setCompteurCodeCmd(String compteurCodeCmd) {
/* 564 */     this.compteurCodeCmd = compteurCodeCmd;
   }
   
   @Column(name = "PREFIXE_CODE_LIV", length = 10)
   public String getPrefixeCodeLiv() {
/* 569 */     return this.prefixeCodeLiv;
   }
   
   public void setPrefixeCodeLiv(String prefixeCodeLiv) {
/* 573 */     this.prefixeCodeLiv = prefixeCodeLiv;
   }
   
   @Column(name = "COMPTEUR_CODE_LIV", length = 7)
   public String getCompteurCodeLiv() {
/* 578 */     return this.compteurCodeLiv;
   }
   
   public void setCompteurCodeLiv(String compteurCodeLiv) {
/* 582 */     this.compteurCodeLiv = compteurCodeLiv;
   }
   
   @Column(name = "PREFIXE_CODE_FAC", length = 10)
   public String getPrefixeCodeFac() {
/* 587 */     return this.prefixeCodeFac;
   }
   
   public void setPrefixeCodeFac(String prefixeCodeFac) {
/* 591 */     this.prefixeCodeFac = prefixeCodeFac;
   }
   
   @Column(name = "COMPTEUR_CODE_FAC", length = 7)
   public String getCompteurCodeFac() {
/* 596 */     return this.compteurCodeFac;
   }
   
   public void setCompteurCodeFac(String compteurCodeFac) {
/* 600 */     this.compteurCodeFac = compteurCodeFac;
   }
   
   @Column(name = "PREFIXE_CODE_REG", length = 10)
   public String getPrefixeCodeReg() {
/* 605 */     return this.prefixeCodeReg;
   }
   
   public void setPrefixeCodeReg(String prefixeCodeReg) {
/* 609 */     this.prefixeCodeReg = prefixeCodeReg;
   }
   
   @Column(name = "COMPTEUR_CODE_REG", length = 7)
   public String getCompteurCodeReg() {
/* 614 */     return this.compteurCodeReg;
   }
   
   public void setCompteurCodeReg(String compteurCodeReg) {
/* 618 */     this.compteurCodeReg = compteurCodeReg;
   }
   
   @Column(name = "PREFIXE_CODE_RET", length = 10)
   public String getPrefixeCodeRet() {
/* 623 */     return this.prefixeCodeRet;
   }
   
   public void setPrefixeCodeRet(String prefixeCodeRet) {
/* 627 */     this.prefixeCodeRet = prefixeCodeRet;
   }
   
   @Column(name = "COMPTEUR_CODE_RET", length = 7)
   public String getCompteurCodeRet() {
/* 632 */     return this.compteurCodeRet;
   }
   
   public void setCompteurCodeRet(String compteurCodeRet) {
/* 636 */     this.compteurCodeRet = compteurCodeRet;
   }
   
   @Column(name = "PREFIXE_CODE_AVR", length = 10)
   public String getPrefixeCodeAvr() {
/* 641 */     return this.prefixeCodeAvr;
   }
   
   public void setPrefixeCodeAvr(String prefixeCodeAvr) {
/* 645 */     this.prefixeCodeAvr = prefixeCodeAvr;
   }
   
   @Column(name = "COMPTEUR_CODE_AVR", length = 7)
   public String getCompteurCodeAvr() {
/* 650 */     return this.compteurCodeAvr;
   }
   
   public void setCompteurCodeAvr(String compteurCodeAvr) {
/* 654 */     this.compteurCodeAvr = compteurCodeAvr;
   }
   
   @Column(name = "PREFIXE_CODE_ECH", length = 10)
   public String getPrefixeCodeEch() {
/* 659 */     return this.prefixeCodeEch;
   }
   
   public void setPrefixeCodeEch(String prefixeCodeEch) {
/* 663 */     this.prefixeCodeEch = prefixeCodeEch;
   }
   
   @Column(name = "COMPTEUR_CODE_ECH", length = 7)
   public String getCompteurCodeEch() {
/* 668 */     return this.compteurCodeEch;
   }
   
   public void setCompteurCodeEch(String compteurCodeEch) {
/* 672 */     this.compteurCodeEch = compteurCodeEch;
   }
   
   @Column(name = "VENTE_HT", nullable = false)
   public int getVenteHt() {
/* 677 */     return this.venteHt;
   }
   
   public void setVenteHt(int venteHt) {
/* 681 */     this.venteHt = venteHt;
   }
   
   @Column(name = "PRIX_VNT_CAT_MAG", nullable = false)
   public int getPrixVntCatMag() {
/* 686 */     return this.prixVntCatMag;
   }
   
   public void setPrixVntCatMag(int prixVntCatMag) {
/* 690 */     this.prixVntCatMag = prixVntCatMag;
   }
   
   @Column(name = "REG_MULTI_DEVISE", nullable = false)
   public int getRegMultiDevise() {
/* 695 */     return this.regMultiDevise;
   }
   
   public void setRegMultiDevise(int regMultiDevise) {
/* 699 */     this.regMultiDevise = regMultiDevise;
   }
   
   @Column(name = "RENDU_MULTI_DEVISE", nullable = false)
   public int getRenduMultiDevise() {
/* 704 */     return this.renduMultiDevise;
   }
   
   public void setRenduMultiDevise(int renduMultiDevise) {
/* 708 */     this.renduMultiDevise = renduMultiDevise;
   }
   
   @Column(name = "NUM_REGION")
   public Integer getNumRegion() {
/* 713 */     return this.numRegion;
   }
   
   public void setNumRegion(Integer numRegion) {
/* 717 */     this.numRegion = numRegion;
   }
   
   @Column(name = "NUM_LOCALITE")
   public Integer getNumLocalite() {
/* 722 */     return this.numLocalite;
   }
   
   public void setNumLocalite(Integer numLocalite) {
/* 726 */     this.numLocalite = numLocalite;
   }
   
   @Column(name = "NUM_VILLE")
   public Integer getNumVille() {
/* 731 */     return this.numVille;
   }
   
   public void setNumVille(Integer numVille) {
/* 735 */     this.numVille = numVille;
   }
   
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "DATE_OUVERTURE", length = 23)
   public Date getDateOuverture() {
/* 741 */     return this.dateOuverture;
   }
   
   public void setDateOuverture(Date dateOuverture) {
/* 745 */     this.dateOuverture = dateOuverture;
   }
   
   @Column(name = "num_compte_auxiliaire", precision = 18, scale = 0)
   public Long getNumCompteAuxiliaire() {
/* 750 */     return this.numCompteAuxiliaire;
   }
   
   public void setNumCompteAuxiliaire(Long numCompteAuxiliaire) {
/* 754 */     this.numCompteAuxiliaire = numCompteAuxiliaire;
   }
   
   @Column(name = "UPDATE_BASE_POS")
   public Integer getUpdateBasePos() {
/* 759 */     return this.updateBasePos;
   }
   
   public void setUpdateBasePos(Integer updateBasePos) {
/* 763 */     this.updateBasePos = updateBasePos;
   }
   
   @Column(name = "UPDATE_PRG_POS")
   public Integer getUpdatePrgPos() {
/* 768 */     return this.updatePrgPos;
   }
   
   public void setUpdatePrgPos(Integer updatePrgPos) {
/* 772 */     this.updatePrgPos = updatePrgPos;
   }
   
   @Column(name = "PHOTO_MAGASIN")
   public String getPhotoMagasin() {
/* 777 */     return this.photoMagasin;
   }
   
   public void setPhotoMagasin(String photoMagasin) {
/* 781 */     this.photoMagasin = photoMagasin;
   }
   
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "DATE_FERMETURE", length = 23)
   public Date getDateFermeture() {
/* 787 */     return this.dateFermeture;
   }
   
   public void setDateFermeture(Date dateFermeture) {
/* 791 */     this.dateFermeture = dateFermeture;
   }
   
   @Column(name = "COORD_LONGITUDE", precision = 18, scale = 10)
   public BigDecimal getCoordLongitude() {
/* 796 */     return this.coordLongitude;
   }
   
   public void setCoordLongitude(BigDecimal coordLongitude) {
/* 800 */     this.coordLongitude = coordLongitude;
   }
   
   @Column(name = "COORD_LATITUDE", precision = 18, scale = 10)
   public BigDecimal getCoordLatitude() {
/* 805 */     return this.coordLatitude;
   }
   
   public void setCoordLatitude(BigDecimal coordLatitude) {
/* 809 */     this.coordLatitude = coordLatitude;
   }
   
   @Column(name = "ENTREPOT")
   public Integer getEntrepot() {
/* 814 */     return this.entrepot;
   }
   
   public void setEntrepot(Integer entrepot) {
/* 818 */     this.entrepot = entrepot;
   }
   
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "DATE_SURFACE_EGALE", length = 23)
   public Date getDateSurfaceEgale() {
/* 824 */     return this.dateSurfaceEgale;
   }
   
   public void setDateSurfaceEgale(Date dateSurfaceEgale) {
/* 828 */     this.dateSurfaceEgale = dateSurfaceEgale;
   }
   
   @Column(name = "Gere_car_manuel")
   public Integer getGereCarManuel() {
/* 833 */     return this.gereCarManuel;
   }
   
   public void setGereCarManuel(Integer gereCarManuel) {
/* 837 */     this.gereCarManuel = gereCarManuel;
   }
   
   @Column(name = "ICE")
   public String getIce() {
/* 842 */     return this.ice;
   }
   
   public void setIce(String ice) {
/* 846 */     this.ice = ice;
   }
 }

