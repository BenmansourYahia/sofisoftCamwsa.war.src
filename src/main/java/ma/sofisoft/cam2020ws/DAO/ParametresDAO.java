package ma.sofisoft.cam2020ws.DAO;

import java.util.List;
import ma.sofisoft.cam2020ws.entity.Parametres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ParametresDAO extends JpaRepository<Parametres, String> {
  @Query("select p from Parametres p where p.id.module = ?1")
  List<Parametres> findByModule(String paramString);
}

