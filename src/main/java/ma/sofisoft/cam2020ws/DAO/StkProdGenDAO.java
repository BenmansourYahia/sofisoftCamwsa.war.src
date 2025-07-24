package ma.sofisoft.cam2020ws.DAO;

import ma.sofisoft.cam2020ws.entity.StkProduitsGenerique;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StkProdGenDAO extends JpaRepository<StkProduitsGenerique, Integer> {
  StkProduitsGenerique findByCodeProduit(String paramString);
  
  StkProduitsGenerique findByNumProduit(int paramInt);
}

