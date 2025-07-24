package ma.sofisoft.cam2020ws.DAO;

import java.util.Date;
import java.util.List;
import ma.sofisoft.cam2020ws.entity.VueCaMagJourObj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VueCaMagJourObjDAO extends JpaRepository<VueCaMagJourObj, String> {
  @Query("select new ma.sofisoft.cam2020ws.entity.VueCaMagJourObj(vue.numMagasin, vue.codeMagasin, vue.nomMagasin, COALESCE(SUM(vue.montantTTC),0), COALESCE(SUM(vue.quantite),0), COALESCE(SUM(vue.nombreTickets),0), COALESCE(SUM(vue.compteur),0), COALESCE(SUM(vue.objectif),0)) from VueCaMagJourObj vue where vue.jourVente between ?1 and ?2 group by vue.codeMagasin, vue.nomMagasin, vue.numMagasin")
  List<VueCaMagJourObj> getInfosByDateGroupedByMagasin(Date paramDate1, Date paramDate2);
  
  @Query("select new ma.sofisoft.cam2020ws.entity.VueCaMagJourObj(vue.numMagasin, vue.codeMagasin, vue.nomMagasin, COALESCE(SUM(vue.montantTTC),0), COALESCE(SUM(vue.quantite),0), COALESCE(SUM(vue.nombreTickets),0), COALESCE(SUM(vue.compteur),0), COALESCE(SUM(vue.objectif),0)) from VueCaMagJourObj vue where vue.jourVente between ?1 and ?2 and vue.codeMagasin = ?3 group by vue.codeMagasin, vue.nomMagasin, vue.numMagasin")
  VueCaMagJourObj getInfosByDateAndMagasin(Date paramDate1, Date paramDate2, String paramString);
  
  @Query("select new ma.sofisoft.cam2020ws.entity.VueCaMagJourObj(vue.numMagasin, vue.codeMagasin, vue.nomMagasin, COALESCE(SUM(vue.montantTTC),0), COALESCE(SUM(vue.quantite),0), COALESCE(SUM(vue.nombreTickets),0), COALESCE(SUM(vue.compteur),0), COALESCE(SUM(vue.objectif),0)) from VueCaMagJourObj vue group by vue.codeMagasin, vue.nomMagasin, vue.numMagasin")
  List<VueCaMagJourObj> getMagasinsInfos();
  
  @Query("select new ma.sofisoft.cam2020ws.entity.VueCaMagJourObj(vue.jourVente, COALESCE(SUM(vue.montantTTC),0), COALESCE(SUM(vue.quantite),0), COALESCE(SUM(vue.nombreTickets),0), COALESCE(SUM(vue.objectif),0), COALESCE(SUM(vue.compteur),0)) from VueCaMagJourObj vue where vue.jourVente between ?1 and ?2 group by vue.jourVente order by vue.jourVente")
  List<VueCaMagJourObj> getInfosByDateGroupedByVenteDay(Date paramDate1, Date paramDate2);
  
  @Query("select new ma.sofisoft.cam2020ws.entity.VueCaMagJourObj(COALESCE(SUM(vue.montantTTC),0), COALESCE(SUM(vue.quantite),0), COALESCE(SUM(vue.nombreTickets),0), COALESCE(SUM(vue.objectif),0), COALESCE(SUM(vue.compteur),0)) from VueCaMagJourObj vue where vue.jourVente between ?1 and ?2")
  VueCaMagJourObj getInfosByDateNotGrouped(Date paramDate1, Date paramDate2);
}

