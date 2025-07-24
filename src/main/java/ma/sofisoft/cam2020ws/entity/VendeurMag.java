 package ma.sofisoft.cam2020ws.entity;
 
 import java.io.Serializable;
 import java.math.BigDecimal;
 import java.util.Date;
 import java.util.HashSet;
 import java.util.Set;
 import javax.persistence.Column;
 import javax.persistence.Entity;
 import javax.persistence.Id;
 import javax.persistence.Table;
 import javax.persistence.Temporal;
 import javax.persistence.TemporalType;
 import javax.persistence.UniqueConstraint;
 import ma.sofisoft.cam2020ws.entity.StkVenteDirecte;
 
 
 
 
 @Entity
 @Table(name = "VENDEUR_MAG", uniqueConstraints = {@UniqueConstraint(columnNames = {"MOT_PASSE"})})
 public class VendeurMag
   implements Serializable
 {
   private long numVendeur;
   private Integer numSociete;
   private String codeVendeur;
   private String nom;
   private String prenom;
   private String adresse;
   private Integer appelation;
   private Date dateNaissance;
   private Date dateDebut;
   private Date dateFin;
   private String observation;
   private Integer bloque;
   private BigDecimal commission;
   private Integer typeCom;
   private long numMagasin;
   private String motPasse;
  private Set<StkVenteDirecte> stkVenteDirectes = new HashSet<>(0);
 
   
   public VendeurMag() {}
   
   public VendeurMag(long numVendeur, String codeVendeur, long numMagasin) {
   this.numVendeur = numVendeur;
     this.codeVendeur = codeVendeur;
    this.numMagasin = numMagasin;
   }
 
 
 
   
   public VendeurMag(long numVendeur, Integer numSociete, String codeVendeur, String nom, String prenom, String adresse, Integer appelation, Date dateNaissance, Date dateDebut, Date dateFin, String observation, Integer bloque, BigDecimal commission, Integer typeCom, long numMagasin, String motPasse, Set<StkVenteDirecte> stkVenteDirectes) {
     this.numVendeur = numVendeur;
     this.numSociete = numSociete;
     this.codeVendeur = codeVendeur;
    this.nom = nom;
   this.prenom = prenom;
    this.adresse = adresse;
   this.appelation = appelation;
     this.dateNaissance = dateNaissance;
    this.dateDebut = dateDebut;
     this.dateFin = dateFin;
    this.observation = observation;
     this.bloque = bloque;
    this.commission = commission;
     this.typeCom = typeCom;
    this.numMagasin = numMagasin;
    this.motPasse = motPasse;
    this.stkVenteDirectes = stkVenteDirectes;
   }
 
   
   @Id
   @Column(name = "NUM_VENDEUR", unique = true, nullable = false, precision = 10, scale = 0)
   public long getNumVendeur() {
/*  79 */     return this.numVendeur;
   }
   
   public void setNumVendeur(long numVendeur) {
/*  83 */     this.numVendeur = numVendeur;
   }
   
   @Column(name = "NUM_SOCIETE")
   public Integer getNumSociete() {
/*  88 */     return this.numSociete;
   }
   
   public void setNumSociete(Integer numSociete) {
/*  92 */     this.numSociete = numSociete;
   }
   
   @Column(name = "CODE_VENDEUR", nullable = false, length = 10)
   public String getCodeVendeur() {
/*  97 */     return this.codeVendeur;
   }
   
   public void setCodeVendeur(String codeVendeur) {
/* 101 */     this.codeVendeur = codeVendeur;
   }
   
   @Column(name = "NOM", length = 30)
   public String getNom() {
/* 106 */     return this.nom;
   }
   
   public void setNom(String nom) {
/* 110 */     this.nom = nom;
   }
   
   @Column(name = "PRENOM", length = 30)
   public String getPrenom() {
/* 115 */     return this.prenom;
   }
   
   public void setPrenom(String prenom) {
/* 119 */     this.prenom = prenom;
   }
   
   @Column(name = "ADRESSE", length = 50)
   public String getAdresse() {
/* 124 */     return this.adresse;
   }
   
   public void setAdresse(String adresse) {
/* 128 */     this.adresse = adresse;
   }
   
   @Column(name = "APPELATION")
   public Integer getAppelation() {
/* 133 */     return this.appelation;
   }
   
   public void setAppelation(Integer appelation) {
/* 137 */     this.appelation = appelation;
   }
   
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "DATE_NAISSANCE", length = 23)
   public Date getDateNaissance() {
/* 143 */     return this.dateNaissance;
   }
   
   public void setDateNaissance(Date dateNaissance) {
/* 147 */     this.dateNaissance = dateNaissance;
   }
   
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "DATE_DEBUT", length = 23)
   public Date getDateDebut() {
/* 153 */     return this.dateDebut;
   }
   
   public void setDateDebut(Date dateDebut) {
/* 157 */     this.dateDebut = dateDebut;
   }
   
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "DATE_FIN", length = 23)
   public Date getDateFin() {
/* 163 */     return this.dateFin;
   }
   
   public void setDateFin(Date dateFin) {
/* 167 */     this.dateFin = dateFin;
   }
   
   @Column(name = "OBSERVATION", length = 120)
   public String getObservation() {
/* 172 */     return this.observation;
   }
   
   public void setObservation(String observation) {
/* 176 */     this.observation = observation;
   }
   
   @Column(name = "BLOQUE")
   public Integer getBloque() {
/* 181 */     return this.bloque;
   }
   
   public void setBloque(Integer bloque) {
/* 185 */     this.bloque = bloque;
   }
   
   @Column(name = "COMMISSION", precision = 4)
   public BigDecimal getCommission() {
/* 190 */     return this.commission;
   }
   
   public void setCommission(BigDecimal commission) {
/* 194 */     this.commission = commission;
   }
   
   @Column(name = "TYPE_COM")
   public Integer getTypeCom() {
/* 199 */     return this.typeCom;
   }
   
   public void setTypeCom(Integer typeCom) {
/* 203 */     this.typeCom = typeCom;
   }
   
   @Column(name = "NUM_MAGASIN", nullable = false, precision = 10, scale = 0)
   public long getNumMagasin() {
/* 208 */     return this.numMagasin;
   }
   
   public void setNumMagasin(long numMagasin) {
/* 212 */     this.numMagasin = numMagasin;
   }
   
   @Column(name = "MOT_PASSE", unique = true, length = 15)
   public String getMotPasse() {
/* 217 */     return this.motPasse;
   }
   
   public void setMotPasse(String motPasse) {
/* 221 */     this.motPasse = motPasse;
   }
 }

