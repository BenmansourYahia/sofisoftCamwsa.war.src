 package ma.sofisoft.cam2020ws.entity;
 
 import java.io.Serializable;
 import javax.persistence.AttributeOverride;
 import javax.persistence.AttributeOverrides;
 import javax.persistence.Column;
 import javax.persistence.EmbeddedId;
 import javax.persistence.Entity;
 import javax.persistence.Table;
 import ma.sofisoft.cam2020ws.entity.CfgUtilisateurId;
 
 
 
 @Entity
 @Table(name = "CFG_UTILISATEUR")
 public class CfgUtilisateur
   implements Serializable
 {
   private CfgUtilisateurId id;
   private long numGrpUtilisateur;
   private String codeUtilisateur;
   private String nom;
   private String motPasse;
   private Long numVendeur;
   private Long codeDepot;
   private boolean optVendeur;
   
   public CfgUtilisateur() {}
   
   public CfgUtilisateur(CfgUtilisateurId id, long numGrpUtilisateur, String codeUtilisateur, boolean optVendeur) {
     this.id = id;
     this.numGrpUtilisateur = numGrpUtilisateur;
     this.codeUtilisateur = codeUtilisateur;
    this.optVendeur = optVendeur;
   }
 
   
   public CfgUtilisateur(CfgUtilisateurId id, long numGrpUtilisateur, String codeUtilisateur, String nom, String motPasse, Long numVendeur, Long codeDepot, boolean optVendeur) {
     this.id = id;
     this.numGrpUtilisateur = numGrpUtilisateur;
     this.codeUtilisateur = codeUtilisateur;
    this.nom = nom;
    this.motPasse = motPasse;
     this.numVendeur = numVendeur;
    this.codeDepot = codeDepot;
     this.optVendeur = optVendeur;
   }
 
 
 
   
   @EmbeddedId
   @AttributeOverrides({@AttributeOverride(name = "numUtilisateur", column = @Column(name = "NUM_UTILISATEUR", nullable = false, precision = 10, scale = 0)), @AttributeOverride(name = "numMagasin", column = @Column(name = "NUM_MAGASIN", nullable = false, precision = 10, scale = 0))})
   public CfgUtilisateurId getId() {
    return this.id;
   }
   
   public void setId(CfgUtilisateurId id) {
     this.id = id;
   }
   
   @Column(name = "NUM_GRP_UTILISATEUR", nullable = false, precision = 10, scale = 0)
   public long getNumGrpUtilisateur() {
     return this.numGrpUtilisateur;
   }
   
   public void setNumGrpUtilisateur(long numGrpUtilisateur) {
    this.numGrpUtilisateur = numGrpUtilisateur;
   }
   
   @Column(name = "CODE_UTILISATEUR", nullable = false, length = 15)
   public String getCodeUtilisateur() {
    return this.codeUtilisateur;
   }
   
   public void setCodeUtilisateur(String codeUtilisateur) {
    this.codeUtilisateur = codeUtilisateur;
   }
   
   @Column(name = "NOM", length = 30)
   public String getNom() {
    return this.nom;
   }
   
   public void setNom(String nom) {
  this.nom = nom;
   }
   
   @Column(name = "MOT_PASSE", length = 15)
   public String getMotPasse() {
    return this.motPasse;
   }
   
   public void setMotPasse(String motPasse) {
  this.motPasse = motPasse;
   }
   
   @Column(name = "NUM_VENDEUR", precision = 10, scale = 0)
   public Long getNumVendeur() {
   return this.numVendeur;
   }
   
   public void setNumVendeur(Long numVendeur) {
    this.numVendeur = numVendeur;
   }
   
   @Column(name = "CODE_DEPOT", precision = 10, scale = 0)
   public Long getCodeDepot() {
    return this.codeDepot;
   }
   
   public void setCodeDepot(Long codeDepot) {
    this.codeDepot = codeDepot;
   }
   
   @Column(name = "OPT_VENDEUR", nullable = false)
   public boolean isOptVendeur() {
    return this.optVendeur;
   }
   
   public void setOptVendeur(boolean optVendeur) {
    this.optVendeur = optVendeur;
   }
 }
