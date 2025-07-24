package ma.sofisoft.cam2020ws.DAO;

import java.util.List;
import ma.sofisoft.cam2020ws.entity.LineVenteDirect;
import ma.sofisoft.cam2020ws.entity.LineVenteDirectId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LineVenteDirectDAO extends JpaRepository<LineVenteDirect, LineVenteDirectId> {
  @Query("select new LineVenteDirect(lv.id,lv.numProduit,lv.numMvt, lv.quantite, lv.tauxRemise, lv.prixVente) from LineVenteDirect lv where lv.numMvt = ?1 and lv.id.numMagasin = ?2")
  List<LineVenteDirect> getByNUmMvtAndNumMagasin(int paramInt1, int paramInt2);
  
  List<LineVenteDirect> findByNumMvt(int paramInt);
}

