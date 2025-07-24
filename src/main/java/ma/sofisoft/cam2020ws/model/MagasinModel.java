 package ma.sofisoft.cam2020ws.model;
 
 
 
 
 public class MagasinModel
 {
   private long numMagasin;
   private String codeMagasin;
   private String nomMagasin;
   
   public MagasinModel(long numMagasin, String codeMagasin, String nomMagasin) {
    this.numMagasin = numMagasin;
    this.codeMagasin = codeMagasin;
   this.nomMagasin = nomMagasin;
   }
   
   public String getCodeMagasin() {
/* 19 */     return this.codeMagasin;
   }
   public void setCodeMagasin(String codeMagasin) {
/* 22 */     this.codeMagasin = codeMagasin;
   }
   public long getNumMagasin() {
/* 25 */     return this.numMagasin;
   }
   public void setNumMagasin(long numMagasin) {
/* 28 */     this.numMagasin = numMagasin;
   }
   public String getNomMagasin() {
/* 31 */     return this.nomMagasin;
   }
   public void setNomMagasin(String nomMagasin) {
/* 34 */     this.nomMagasin = nomMagasin;
   }
 }

