package ma.sofisoft.cam2020ws.DAO;

import java.util.List;
import ma.sofisoft.cam2020ws.entity.StkPrdDim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StkPrdDimDAO extends JpaRepository<StkPrdDim, Long> {
  @Query("select dim from StkPrdDim dim where dim.stkProduitsGenerique.numProduit = ?1  ")
  List<StkPrdDim> findByNumProduit(int paramInt);
  
  StkPrdDim findByCodeBarre(String paramString);
  
  StkPrdDim findByCodeProduit(String paramString);
}

