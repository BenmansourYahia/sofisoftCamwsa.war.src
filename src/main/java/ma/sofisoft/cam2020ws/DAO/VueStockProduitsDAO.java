package ma.sofisoft.cam2020ws.DAO;

import java.util.List;
import ma.sofisoft.cam2020ws.entity.VueStockProduits;
import org.springframework.data.jpa.repository.Query;

public interface VueStockProduitsDAO {
  @Query("SELECT vue FROM VueStockProduits vue where vue.quantite !=0 and vue.row between ?1 and ?2")
  List<VueStockProduits> getStockDiffZero(int paramInt1, int paramInt2);
  
  @Query("SELECT vue FROM VueStockProduits vue where vue.row between ?1 and ?2")
  List<VueStockProduits> getStockAvecZero(int paramInt1, int paramInt2);
  
  @Query("SELECT vue FROM VueStockProduits vue where vue.quantite = 0 and vue.row between ?1 and ?2")
  List<VueStockProduits> getStockEqalZero(int paramInt1, int paramInt2);
  
  @Query("SELECT vue FROM VueStockProduits vue where vue.quantite < 0 and vue.row between ?1 and ?2")
  List<VueStockProduits> getStockInfZero(int paramInt1, int paramInt2);
  
  @Query("SELECT vue FROM VueStockProduits vue where vue.quantite > 0 and vue.row between ?1 and ?2")
  List<VueStockProduits> getStockSupZero(int paramInt1, int paramInt2);
}

