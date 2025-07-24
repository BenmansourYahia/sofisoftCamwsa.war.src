package ma.sofisoft.cam2020ws.DAO;

import java.util.List;
import ma.sofisoft.cam2020ws.entity.DspMagasin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DspMagasinDAO extends JpaRepository<DspMagasin, Long> {
  @Query("select new DspMagasin(mag.numMagasin,mag.codeMagasin,mag.nomMagasin) from DspMagasin mag where ISNULL(mag.entrepot,0) = 0")
  List<DspMagasin> getMagasins();
}

