 package ma.sofisoft.cam2020ws.model;
 
 
 public class UserModel
 {
   private long numUtilisateur;
   private long numMagasin;
   private String nom;
   private String motPasse;
   private Long numVendeur;
   
   public UserModel(long numUtilisateur, long numMagasin, String nom, String motPasse, Long numVendeur) {
    this.numUtilisateur = numUtilisateur;
    this.numMagasin = numMagasin;
     this.nom = nom;
    this.motPasse = motPasse;
     this.numVendeur = numVendeur;
   }
 
   
   public long getNumUtilisateur() {
    return this.numUtilisateur;
   }
   public void setNumUtilisateur(long numUtilisateur) {
     this.numUtilisateur = numUtilisateur;
   }
   public long getNumMagasin() {
     return this.numMagasin;
   }
   public void setNumMagasin(long numMagasin) {
     this.numMagasin = numMagasin;
   }
   public String getNom() {
     return this.nom;
   }
   public void setNom(String nom) {
   this.nom = nom;
   }
   public String getMotPasse() {
    return this.motPasse;
   }
   public void setMotPasse(String motPasse) {
     this.motPasse = motPasse;
   }
   public Long getNumVendeur() {
    return this.numVendeur;
   }
   public void setNumVendeur(Long numVendeur) {
    this.numVendeur = numVendeur;
   }
 }
